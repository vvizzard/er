/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.ArticleBon;
import com.er.erproject.modele.AssociationArticleBon;
import com.er.erproject.modele.Bon;
import com.er.erproject.modele.Projet;
import com.er.erproject.modele.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vvizard
 */
public class BonService extends BaseService {

    private AssociationService associationService;
    private InventaireService inventaireService;

    public void find(Bon bon) throws Exception {
        hbdao.findById(bon);
        completeLoad(bon);
    }

    public List<Bon> findAll() throws Exception {
        List<Bon> valiny = (List<Bon>) (List<?>) hbdao.findAll(new Bon());
        for (Bon bons : valiny) {
            completeLoad(bons);
        }
        return valiny;
    }

    public void save(Bon bon) throws Exception {
        String cheminPhoto = "E:/vvizard/Projet en cours/ERproject/src/main/webapp/preuveEntree/";
        hbdao.save(bon);
        if (bon.getFilePhoto() != null) {
            UtilService.saveImg(bon.getFilePhoto(), cheminPhoto, "photo" + bon.getId() + ".jpg");
        }
        bon.setPhoto("preuveEntree/photo" + bon.getId() + ".jpg");
        hbdao.update(bon);
        List<ArticleBon> bonTemp = bon.getListeArticle();
        for (ArticleBon ab : bonTemp) {
            AssociationArticleBon temporaire = new AssociationArticleBon();
            temporaire.setId1(ab.getId());
            temporaire.setId2(bon.getId());
            temporaire.setIdUnite(ab.getUnite().getId());
            temporaire.setMontant(ab.getNombre());
            temporaire.setPrixu(ab.getPrixUnitaire());
            hbdao.save(temporaire);
            inventaireService.updateInventaireForArticle(ab);
        }
    }

    public void update(Bon bon) throws Exception {
        hbdao.update(bon);
    }

    private void completeLoad(Bon bon) throws Exception {
        User user = new User();
        user.setId(bon.getIdDemandeur());
        hbdao.findById(user);
        bon.setDemandeur(user);
        Projet projet = new Projet();
        projet.setId(bon.getIdProjet());
        hbdao.findById(projet);
        bon.setProjet(projet);
    }

    public List<Bon> rechercher(Projet p) throws Exception {
        Session session = null;
        List<Bon> list = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Bon.class, "bon");
            criteria.add(Restrictions.eq("idProjet", p.getId()));            
            list = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public AssociationService getAssociationService() {
        return associationService;
    }

    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
    }

    public InventaireService getInventaireService() {
        return inventaireService;
    }

    public void setInventaireService(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

}
