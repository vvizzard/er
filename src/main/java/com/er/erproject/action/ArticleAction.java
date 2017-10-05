/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Article;
import com.er.erproject.modele.AssociationArticleFournisseur;
import com.er.erproject.modele.AssociationArticleUnite;
import com.er.erproject.modele.Famille;
import com.er.erproject.modele.Fournisseur;
import com.er.erproject.modele.Unite;
import com.er.erproject.modele.VueArticleFournisseur;
import com.er.erproject.modele.VueListeArticle;
import com.er.erproject.service.ArticleService;
import com.er.erproject.service.AssociationService;
import com.er.erproject.service.UtilService;
import com.er.erproject.service.VueArticleFournisseurService;
import com.opensymphony.xwork2.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvizard
 */
public class ArticleAction extends BaseAction {    

    private ArticleService articleService;
    private VueArticleFournisseurService vueArticleFournisseurService;
    private int type = 0;

    private List<VueListeArticle> listeArticle;

    private String codeArticle = "";
    private String designation;
    private int idFamille;
    private Famille famille;
    private String designationFamille;
    private List<Unite> unites;
    private List<AssociationArticleUnite> associationArticleUnite;
    private String designationUnite;
    private String emplacement;
    private List<AssociationArticleFournisseur> associationArticleFournisseur;
    private String designationFournisseur;
    private int idArticle = 0;

    private List<Fournisseur> fournisseurs;
    private List<Famille> familles;
    private double prix;

    private Article article;
    private List<VueArticleFournisseur> listeFournisseursPrix;
    private String fournisseurT;
    private double prixT;
    private AssociationService associationService;
    private int idFournisseurArticle;
    private double limite;
    private int idDemandeur;
    private String critere;
    private String searchFamille;
    private String searchEmplacement;

    private List<String> listeFamille;
    private List<String> listeEmplacement;
    
    private double sm;
    private double sa;

    public String load() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            listeArticle = (List<VueListeArticle>) (List<?>) hbdao.findAll(new VueListeArticle());
            listeFamille = UtilService.listeString("vueinventaire", "famille", hbdao);
            listeEmplacement = UtilService.listeString("vueinventaire", "emplacement", hbdao);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String recherche() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            listeArticle = articleService.filtreArticle(critere, searchFamille, searchEmplacement);
            listeFamille = UtilService.listeString("vueinventaire", "famille", hbdao);
            listeEmplacement = UtilService.listeString("vueinventaire", "emplacement", hbdao);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String ficheArticle() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(3)) {
                return "access";
            }
            article = new Article(idArticle);
            articleService.find(article);
            listeFournisseursPrix = vueArticleFournisseurService.findAll(article);
            fournisseurs = (List<Fournisseur>) (List<?>) hbdao.findAll(new Fournisseur());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String deleteFournisseur() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(3)) {
                return "acces";
            }
            article = new Article(idArticle);
            articleService.find(article);
            fournisseurs = (List<Fournisseur>) (List<?>) hbdao.findAll(new Fournisseur());
            AssociationArticleFournisseur aaf = new AssociationArticleFournisseur(idFournisseurArticle);
            associationService.delete(aaf);
            listeFournisseursPrix = vueArticleFournisseurService.findAll(article);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String addFournisseur() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(3)) {
                return "acces";
            }
            fournisseurs = (List<Fournisseur>) (List<?>) hbdao.findAll(new Fournisseur());
            article = new Article(idArticle);
            articleService.find(article);
            AssociationArticleFournisseur aaf = new AssociationArticleFournisseur();
            aaf.setBm1(article);
            aaf.setMontant(prixT);
            aaf.setId1(idArticle);
            for (Fournisseur fr : fournisseurs) {
                if (fr.getNom().compareToIgnoreCase(fournisseurT) == 0) {
                    aaf.setBm2(fr);
                    aaf.setId2(fr.getId());
                }
            }
            associationService.save(aaf);
            listeFournisseursPrix = vueArticleFournisseurService.findAll(article);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String newArticle() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(3)) {
                return "access";
            }
                 
            if (idArticle != 0) {
                Article art = new Article(idArticle);
                articleService.find(art);
                codeArticle = art.getCode();
                designation = art.getDesignation();
                designationFamille = art.getFamille().getDesignation();
                designationUnite = art.getUnite().getDesignation();
                emplacement = art.getEmplacement();
                limite = art.getLimite();
                sa = art.getSa();
                sm = art.getSm();
            }

            fournisseurs = (List<Fournisseur>) (List<?>) hbdao.findAll(new Fournisseur());
            familles = (List<Famille>) (List<?>) hbdao.findAll(new Famille());
            unites = (List<Unite>) (List<?>) hbdao.findAll(new Unite());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String addArticle() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(3)) {
                return "access";
            }
            //  Instance of the Article
            Article toSave = new Article();
            //  Complete Article
            setIdFamille(toSave);
            toSave.setCode(codeArticle);
            toSave.setDesignation(designation);
            toSave.setEmplacement(emplacement);
            toSave.setLimite(limite);
            toSave.setSm(sm);
            toSave.setSa(sa);
            unites = (List<Unite>) (List<?>) hbdao.findAll(new Unite());
            for (Unite u : unites) {
                if (u.getDesignation().compareToIgnoreCase(designationUnite) == 0) {
                    toSave.setIdUnite(u.getId());
                }
            }
//            setAssociationArticleFournisseur(toSave);
//            setAssociationArticleUnite(toSave);
            if (idArticle != 0) {
                toSave.setId(idArticle);
                articleService.update(toSave, "inventaire");
            } else {
                articleService.save(toSave, "inventaire");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String deleteArticle() {
        Article toSave = new Article();
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(3)) {
                return "access";
            }
            //  Instance of the Unite            
            toSave.setId(idArticle);
            articleService.delete(toSave);
            //  load List Article
            listeArticle = (List<VueListeArticle>) (List<?>) hbdao.findAll(new VueListeArticle());
//            for(Article u : listeArticle) if(u.getDesignation().compareToIgnoreCase("none")==0) listeArticle.remove(u);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            try {
                hbdao.delete(toSave);
            } catch (Exception ex1) {
                Logger.getLogger(ArticleAction.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    //  UTILS
    private void setIdFamille(Article toSave) {
        try {
            familles = (List<Famille>) (List<?>) hbdao.findAll(new Famille());
            for (Famille f : familles) {
                if (f.getDesignation().compareTo(designationFamille) == 0) {
                    toSave.setIdFamille(f.getId());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAssociationArticleFournisseur(Article toSave) {
        try {
            fournisseurs = (List<Fournisseur>) (List<?>) hbdao.findAll(new Fournisseur());
            AssociationArticleFournisseur temporaire = new AssociationArticleFournisseur();
            for (Fournisseur f : fournisseurs) {
                if (f.getNom().compareTo(designationFournisseur) == 0) {
                    temporaire.setId1(toSave.getId());
                    temporaire.setId2(f.getId());
                    temporaire.setMontant(prix);
                }
            }
            List<AssociationArticleFournisseur> tp = new ArrayList<>();
            tp.add(temporaire);
            toSave.setAssociationArticleFournisseur(tp);
        } catch (Exception ex) {
            Logger.getLogger(ArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAssociationArticleUnite(Article toSave) {
        try {
            unites = (List<Unite>) (List<?>) hbdao.findAll(new Unite());
            AssociationArticleUnite temporaire = new AssociationArticleUnite();
            for (Unite f : unites) {
                if (f.getDesignation().compareTo(designationUnite) == 0) {
                    temporaire.setId1(toSave.getId());
                    temporaire.setId2(f.getId());
                }
            }
            List<AssociationArticleUnite> tp = new ArrayList<>();
            tp.add(temporaire);
            toSave.setAssociationArticleUnite(tp);
        } catch (Exception ex) {
            Logger.getLogger(ArticleAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//  GETTERS AND SETTERS
    public List<VueListeArticle> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(List<VueListeArticle> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public int getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Unite> getUnites() {
        return unites;
    }

    public void setUnites(List<Unite> unites) {
        this.unites = unites;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public List<AssociationArticleUnite> getAssociationArticleUnite() {
        return associationArticleUnite;
    }

    public void setAssociationArticleUnite(List<AssociationArticleUnite> associationArticleUnite) {
        this.associationArticleUnite = associationArticleUnite;
    }

    public List<AssociationArticleFournisseur> getAssociationArticleFournisseur() {
        return associationArticleFournisseur;
    }

    public void setAssociationArticleFournisseur(List<AssociationArticleFournisseur> associationArticleFournisseur) {
        this.associationArticleFournisseur = associationArticleFournisseur;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignationFamille() {
        return designationFamille;
    }

    public void setDesignationFamille(String designationFamille) {
        this.designationFamille = designationFamille;
    }

    public String getDesignationUnite() {
        return designationUnite;
    }

    public void setDesignationUnite(String designationUnite) {
        this.designationUnite = designationUnite;
    }

    public String getDesignationFournisseur() {
        return designationFournisseur;
    }

    public void setDesignationFournisseur(String designationFournisseur) {
        this.designationFournisseur = designationFournisseur;
    }

    public List<Famille> getFamilles() {
        return familles;
    }

    public void setFamilles(List<Famille> familles) {
        this.familles = familles;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<VueArticleFournisseur> getListeFournisseursPrix() {
        return listeFournisseursPrix;
    }

    public void setListeFournisseursPrix(List<VueArticleFournisseur> listeFournisseursPrix) {
        this.listeFournisseursPrix = listeFournisseursPrix;
    }

    public String getFournisseurT() {
        return fournisseurT;
    }

    public void setFournisseurT(String fournisseurT) {
        this.fournisseurT = fournisseurT;
    }

    public double getPrixT() {
        return prixT;
    }

    public void setPrixT(double prixT) {
        this.prixT = prixT;
    }

    public VueArticleFournisseurService getVueArticleFournisseurService() {
        return vueArticleFournisseurService;
    }

    public void setVueArticleFournisseurService(VueArticleFournisseurService vueArticleFournisseurService) {
        this.vueArticleFournisseurService = vueArticleFournisseurService;
    }

    public AssociationService getAssociationService() {
        return associationService;
    }

    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
    }

    public int getIdFournisseurArticle() {
        return idFournisseurArticle;
    }

    public void setIdFournisseurArticle(int idFournisseurArticle) {
        this.idFournisseurArticle = idFournisseurArticle;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(int idDemandeur) {
        this.idDemandeur = idDemandeur;
    }

    public String getCritere() {
        return critere;
    }

    public void setCritere(String critere) {
        this.critere = critere;
    }

    public String getSearchFamille() {
        return searchFamille;
    }

    public void setSearchFamille(String searchFamille) {
        this.searchFamille = searchFamille;
    }

    public String getSearchEmplacement() {
        return searchEmplacement;
    }

    public void setSearchEmplacement(String searchEmplacement) {
        this.searchEmplacement = searchEmplacement;
    }

    public List<String> getListeFamille() {
        return listeFamille;
    }

    public void setListeFamille(List<String> listeFamille) {
        this.listeFamille = listeFamille;
    }

    public List<String> getListeEmplacement() {
        return listeEmplacement;
    }

    public void setListeEmplacement(List<String> listeEmplacement) {
        this.listeEmplacement = listeEmplacement;
    }

    public double getSm() {
        return sm;
    }

    public void setSm(double sm) {
        this.sm = sm;
    }

    public double getSa() {
        return sa;
    }

    public void setSa(double sa) {
        this.sa = sa;
    }
    
    
}
