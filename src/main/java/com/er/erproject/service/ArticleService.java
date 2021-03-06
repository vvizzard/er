/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.Article;
import com.er.erproject.modele.AssociationArticleFournisseur;
import com.er.erproject.modele.AssociationArticleUnite;
import com.er.erproject.modele.Famille;
import com.er.erproject.modele.Inventaire;
import com.er.erproject.modele.Unite;
import com.er.erproject.modele.VueListeArticle;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vvizard
 */
public class ArticleService extends BaseService {

    private AssociationService associationService;
    private UniteService uniteService;
    private InventaireService inventaireService;

    public void find(Article a) throws Exception {
        hbdao.findById(a);
        completeLoad(a);
    }

    public List<Article> findAll() throws Exception {
        List<Article> valiny = (List<Article>) (List<?>) hbdao.findAll(new Article());
        for (Article at : valiny) {
            completeLoad(at);
        }
        return valiny;
    }

    public void save(Article a) throws Exception {
        Article verif = new Article();
        try {
            verif = this.findByName(a.getDesignation());
            if (verif.getIdUnite() != 0 && verif.getIdFamille() != 0 && verif.getLimite() != 0) {
                throw new Exception("Redondance d'article");
            }
        } catch (IndexOutOfBoundsException i) {
            hbdao.save(a);
            for (AssociationArticleFournisseur aaf : a.getAssociationArticleFournisseur()) {
                aaf.setId1(a.getId());
                hbdao.save(aaf);
            }
            for (AssociationArticleUnite aau : a.getAssociationArticleUnite()) {
                aau.setId1(a.getId());
                hbdao.save(aau);
            }
        }
    }

    public void save(Article a, String inventaire) throws Exception {
        Article verif = new Article();
        try {
            verif = this.findByName(a.getDesignation());
            if (verif.getIdUnite() != 0 && verif.getIdFamille() != 0 && verif.getLimite() != 0) {
                throw new Exception("Redondance d'article");
            }
        } catch (IndexOutOfBoundsException i) {
            hbdao.save(a);
            Inventaire iTemp = new Inventaire();
            iTemp.setArticle(a);
            iTemp.setId1(a.getId());
            iTemp.setId2(a.getIdUnite());
            iTemp.setValeur(0);
            iTemp.setMontant(0);
            inventaireService.save(iTemp);
        }
    }

    public Inventaire findInventaire(int idArticle) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from inventaire "
                    + "where id_article = :idArticle ";
            Query query = session.createSQLQuery(qry).addEntity(Inventaire.class);
            query.setParameter("idArticle", idArticle);
            List<Inventaire> val = query.list();
            return val.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Article a) throws Exception {
        find(a);

        try {
            List<AssociationArticleFournisseur> aaf = a.getAssociationArticleFournisseur();
            for (AssociationArticleFournisseur aafT : aaf) {
                hbdao.delete(aafT);
            }
        } catch (NullPointerException npe) {
        }
        try {
            List<Unite> listeU = a.getUnites();

            List<AssociationArticleUnite> aau = a.getAssociationArticleUnite();
            for (AssociationArticleUnite aafT : aau) {
                hbdao.delete(aafT);
            }
        } catch (NullPointerException npe) {
        }

        Inventaire i = findInventaire(a.getId());
        hbdao.delete(i);
        hbdao.delete(a);
    }

    public void update(Article a) throws Exception {
        hbdao.update(a);
    }

    public void update(Article a, String invenataire) throws Exception {
        hbdao.update(a);
        try {
            Inventaire iTemp = inventaireService.findByArticle(a);
//            Unite uTemp = new Unite(a.getIdUnite());
//            hbdao.findById(uTemp);
            iTemp.setId2(a.getIdUnite());
            inventaireService.update(iTemp);
        } catch (IndexOutOfBoundsException ioobe) {
            Inventaire iTemp = new Inventaire();
            iTemp.setArticle(a);
            iTemp.setId1(a.getId());
            iTemp.setId2(a.getIdUnite());
            iTemp.setValeur(0);
            iTemp.setMontant(0);
            inventaireService.save(iTemp);
        }
    }

    public void completeLoad(Article a) throws Exception {
        Famille f = new Famille();
        f.setId(a.getIdFamille());
        hbdao.findById(f);
        a.setFamille(f);
        Unite u = new Unite();
        u.setId(a.getIdUnite());
        uniteService.find(u);
        a.setUnite(u);
        int t = 0;
//        AssociationArticleUnite aau = new AssociationArticleUnite();
//        aau.setTable("AssociationArticleUnite");
//        a.setUnites((List<Unite>)(List<?>)associationService.findBm(aau, a.getId(), "unite", "article"));

//        List<AssociationArticleFournisseur> lT = (List<AssociationArticleFournisseur>)(List<?>)hbdao.findAll(new AssociationArticleFournisseur());
//        List<AssociationArticleFournisseur> lf = new ArrayList<>();
//        for(AssociationArticleFournisseur aaf : lT) {
//            Fournisseur ff = new Fournisseur(aaf.getId2());
//            hbdao.findById(ff);
//            aaf.setFournisseur(ff);
//            if(aaf.getArticle().getId()==a.getId())lf.add(aaf);
//        }                
//        a.setAssociationArticleFournisseur(lf);
//        
//        List<AssociationArticleUnite> uT = (List<AssociationArticleUnite>)(List<?>)hbdao.findAll(new AssociationArticleUnite());
//        List<AssociationArticleUnite> uf = new ArrayList<>();
//        for(AssociationArticleUnite aaf : uT) {
//            if(aaf.getArticle().getId()==a.getId())uf.add(aaf);
//            hbdao.findById(new Unite(aaf.getId2()));
//        }                
//        
//        a.setAssociationArticleUnite(uf);
//        
//        int t = 0;
    }

    public List<String> find(String nom) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select designation from article where designation ilike :aa order by designation asc";
            Query query = session.createSQLQuery(qry);
            query.setParameter("aa", nom);
            List<Object> val = query.list();
            List<String> farany = new ArrayList<>();
            for (Object o : val) {
                farany.add(o.toString());
            }
            return farany;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Article findByName(String nom) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from article where designation = :aa";
            Query query = session.createSQLQuery(qry).addEntity(Article.class);
            query.setParameter("aa", nom);
            List<Article> val = query.list();
            return val.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public String findNombreDisponible(int idArticle) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select nombre from inventaire where id_article = :aa";
            Query query = session.createSQLQuery(qry);
            query.setParameter("aa", idArticle);
            List<Object> val = query.list();
            return val.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<VueListeArticle> filtreArticle(String critere, String famille, String emplacement) {
        Session session = null;
        int check = 0;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qryP1 = "select * from vuelistearticle "
                    + " where designation ilike :critere ";
            String qryP2 = " or code ilike :critere ";
            if (famille.compareTo("Tout") != 0) {
                qryP1 += " and famille = :fm";
                qryP2 += " and famille = :fm";
                check += 1;
            }
            if (emplacement.compareTo("Tout") != 0) {
                qryP1 += " and emplacement = :ep";
                qryP2 += " and emplacement = :ep";
                check += 2;
            }
            String qry = qryP1 + qryP2;
            Query query = session.createSQLQuery(qry).addEntity(VueListeArticle.class);
            query.setParameter("critere", "%" + critere + "%");
            if (check == 1 || check == 3) {
                query.setParameter("fm", famille);
            }
            if (check == 2 || check == 3) {
                query.setParameter("ep", emplacement);
            }
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public AssociationService getAssociationService() {
        return associationService;
    }

    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }

    public InventaireService getInventaireService() {
        return inventaireService;
    }

    public void setInventaireService(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

}
