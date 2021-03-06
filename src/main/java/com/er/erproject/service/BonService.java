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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vvizard
 */
public class BonService extends BaseService {

    private AssociationService associationService;
    private InventaireService inventaireService;
    private AssociationArticleBonService associationArticleBonService;

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

    public List<Bon> rechercher(int id, String demandeur, String date) throws Exception {
        Session session = null;
        Date dateD = null;
        int check = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select b.* from bon b "
                    + "join users u on u.id = b.id_user "
                    + "join projet p on p.id = b.id_projet "
                    + "where 1<2  ";
            if (id != 0) {
                qry += "and b.id = :ppj ";
                check += 1;
            }
            if (demandeur.compareTo("") != 0) {
                if (demandeur.contains(" ")) {
                    qry += "and u.nomuser ilike :nom and u.prenomuser ilike :prenom ";
                    check += 10;
                } else {
                    qry += "and (u.nomuser ilike :nom or u.prenomuser ilike :nom) ";
                    check += 100;
                }
            }
            if (date.compareTo("") != 0) {
                qry += " and b.date = :date";
                check += 1000;
                dateD = formatter.parse(date);
            }
            Query query = session.createSQLQuery(qry).addEntity(Bon.class);
            int check2 = 0;
            if (check - 1000 >= 0) {
                query.setParameter("date", dateD);
                check -= 1000;
            }
            if (check - 100 >= 0) {
                query.setParameter("nom", demandeur);
                check -= 100;
            }
            if (check - 10 >= 0) {
                String[] np = demandeur.split(" ");
                query.setParameter("nom", np[0]);
                query.setParameter("prenom", np[1]);
                check -= 10;
            }
            if (check - 1 >= 0) {
                query.setParameter("ppj", id);
            }
            List<Bon> valiny = query.list();
            return valiny;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void save(Bon bon) throws Exception {
        String cheminPhoto = "preuveEntree/";
        hbdao.save(bon);
        if (bon.getFilePhoto() != null) {
            UtilService.saveImg(bon.getFilePhoto(), cheminPhoto, "photo" + bon.getId() + ".jpg");
            bon.setPhoto("preuveEntree/photo" + bon.getId() + ".jpg");
            hbdao.update(bon);
        }
        List<ArticleBon> bonTemp = bon.getListeArticle();
        for (ArticleBon ab : bonTemp) {
            AssociationArticleBon temporaire = new AssociationArticleBon();
            temporaire.setId1(ab.getId());
            temporaire.setId2(bon.getId());
            temporaire.setIdUnite(ab.getUnite().getId());
            temporaire.setMontant(ab.getNombre());
            temporaire.setPrixu(ab.getPrixUnitaire());
            if (bon.getType().compareTo("entree") == 0) {
                temporaire.setNbrDisponible(ab.getNombre());
            } else {
                List<AssociationArticleBon> listeAAB = associationArticleBonService.getListAABDateDesc(ab.getId());
                double nombre = ab.getNombre(), prix = 0;
                for (AssociationArticleBon b : listeAAB) {
                    double test = b.getNbrDisponible() - nombre;
                    if (test >= 0) {
                        prix += nombre * b.getPrixu();
                        b.setNbrDisponible(test);
                        hbdao.update(b);
                        break;
                    } else {
                        prix += b.getNbrDisponible() * b.getPrixu();
                        b.setNbrDisponible(0);
                        hbdao.update(b);
                    }
                }
                temporaire.setPrixt(prix);
                ab.setPt(prix);
            }
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

    public AssociationArticleBonService getAssociationArticleBonService() {
        return associationArticleBonService;
    }

    public void setAssociationArticleBonService(AssociationArticleBonService associationArticleBonService) {
        this.associationArticleBonService = associationArticleBonService;
    }

}
