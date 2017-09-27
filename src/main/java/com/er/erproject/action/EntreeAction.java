/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Article;
import com.er.erproject.modele.ArticleBon;
import com.er.erproject.modele.Bon;
import com.er.erproject.modele.Fournisseur;
import com.er.erproject.modele.Unite;
import com.er.erproject.modele.User;
import com.er.erproject.modele.VueInventaire;
import com.er.erproject.service.ArticleService;
import com.er.erproject.service.BonService;
import com.er.erproject.service.UniteService;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author vvizard
 */
public class EntreeAction extends BaseAction {

    private Map session;
    private Bon bon;
    private int idDernierArticle;
    private String codeDernierArticle = "";
    private List<ArticleBon> listeArticle;
    private String checkList = "";
    private int idDemandeur;
    private String nomPrenomDemandeur = "";
    private int idDernierFournisseur;
    private String dernierFournisseur = "";
    private ArticleBon articleEnCours;
    private ArticleService articleService;
    private double prixSelonFournisseur;
    private String unite;
    private double nombre;
    private String coms;
    private BonService bonService;
    private File photos = null;
    private String myFileContentType;
    private String myFileFileName;
    private String dateToday = "";
    private String facture = "";
    private UniteService uniteService;
    private List<Unite> listeU;    
    private final String cheminPhoto = "E:/vvizard/Projet en cours/preuveEntree/";

    public String load() {
        try {
            //  check session
            if (!sessionCheck()) {
                return Action.ERROR;
            }
            //  envoyer bon dans la session
            bon = new Bon();
            bon.setType("entree");
            bon.setDate(Calendar.getInstance().getTime());
            bon.setDemandeur(user);
            //bon.setListeArticle(listeArticle);
            session.put("bon", bon);
            boolean tempo = getAlertes().isEmpty();
            int tester = getAlertes().size();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String annuler() {
        clean();
        return Action.SUCCESS;
    }

    public String ajoutDemandeur() {
        try {
            //  check session
            if (!sessionCheck()) {
                return Action.ERROR;
            }
            bon = (Bon) session.get("bon");
            //  load demandeur
            User demandeur = new User();
            demandeur.setId(idDemandeur);
            hbdao.findById(demandeur);
            nomPrenomDemandeur = demandeur.getNom() + " " + demandeur.getPrenom();  //  Afficher nom et prénom du demandeur
            //  add demandeur to session            
            bon.setDemandeur(demandeur);
            //  listeArticle
            listeArticle();
            //  Article en cours
            if (idDernierArticle != 0) {
                loadArticleEnCours();
            }
            //  loadFournisseur
            if (idDernierFournisseur != 0) {
                loadFournisseur();
            }
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String ajoutFournisseur() {
        try {
            //  check session
            if (!sessionCheck()) {
                return Action.ERROR;
            }
            bon = (Bon) session.get("bon");
            //  loadFournisseur
            loadFournisseur();
            //  load article en cours
            loadArticleEnCours();
            //  demandeur
            demandeur();
            //  listeArticle
            listeArticle();
            //  Article en cours
            if (idDernierArticle != 0) {
                loadArticleEnCours();
            }
            //  loadFournisseur
            if (idDernierFournisseur != 0) {
                loadFournisseur();
            }
            //  unite
            Unite tempp = new Unite(articleEnCours.getIdUnite());
            hbdao.findById(tempp);
            listeU = uniteService.getEquivalent(tempp);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

//    public String addNewArticle() {
//        //  add dernier article to session         
//        bon = (Bon)session.get("bon");
//        bon.getListeArticle().add(dernierArticle); codeDernierArticle =
//        dernierArticle.getCode();
//    }
    public String ajoutArticle() {
        try {
            //  check session
            if (!sessionCheck()) {
                return Action.ERROR;
            }
            bon = (Bon) session.get("bon");
            //  load article en cours
            loadArticleEnCours();
            //  listeArticle
            listeArticle();
            //  demandeur
            demandeur();
            //  loadFournisseur
            if (idDernierFournisseur != 0) {
                loadFournisseur();
            }
            //  unite
            Unite tempp = new Unite(articleEnCours.getIdUnite());
            hbdao.findById(tempp);
            listeU = uniteService.getEquivalent(tempp);
            listeU.add(tempp);
            unite = tempp.getDesignation();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String ajouter() {
        ArticleBon article = null;
        try {
            //  check session
            if (!sessionCheck()) {
                return Action.ERROR;
            }

            Article temp = new Article();
            temp.setId(idDernierArticle);
            articleService.find(temp);
            article = new ArticleBon(temp);
            //  fournisseur            
            setFournisseur(article);
            //  unité
            setUnites(article);
            //  nombre
            article.setNombre(nombre);
            //  prix unitaire
            article.setPrixUnitaire(prixSelonFournisseur);
            //  add to session
            bon = (Bon) session.get("bon");
            bon.getListeArticle().add(article);
        } catch (NullPointerException nEx) {
            List<ArticleBon> temporaire = new ArrayList<>();
            temporaire.add(article);
            //  prix unitaire
            article.setPrixUnitaire(prixSelonFournisseur);
            //  add to session
            //    bon = (Bon)session.get("bon");
            bon.setListeArticle(temporaire);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        //  listeArticle
        listeArticle();
        clean();
        return Action.SUCCESS;
    }

    public String enregistrer() {
        try {
            //  check session
            if (!sessionCheck()) {
                return Action.ERROR;
            }
            //  get bon
            bon = (Bon) session.get("bon");
            //  add demandeur to bon
            User demandeur = new User(idDemandeur);
            hbdao.findById(demandeur);
            bon.setDemandeur(demandeur);
            //  add date to bon
            if (dateToday.compareTo("") != 0) {
                bon.setDate(dateToday);
            }
            //  add photos to bon
            if (photos != null) {
                bon.setFilePhoto(photos);
                String extension = FilenameUtils.getExtension(photos.getName());
            }
            if (facture.compareTo("") == 0) {
                throw new Exception();
            }
            bon.setFacture(facture);
            //  save bon                        
            bonService.save(bon);
//            session = ActionContext.getContext().getSession();            
//            List<Inventaire> alerte = UtilService.listeAlerte();            
//            session.put("alerte", alerte);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        bon = new Bon();
        bon.setType("entree");
        bon.setDate(Calendar.getInstance().getTime());
        bon.setDemandeur(user);
        //bon.setListeArticle(listeArticle);
        session.put("bon", bon);
        return Action.SUCCESS;
    }

//  UTILS
    private boolean sessionCheck() throws Exception {
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        alertes = UtilService.listeAlerte(hbdao);
        return checkUser();
    }

    private void loadArticleEnCours() {
        articleEnCours = new ArticleBon();
        Article temporaire = new Article();
        temporaire.setId(idDernierArticle);
        //  articleEnCours.setId(idDernierArticle);
        try {
            articleService.find(temporaire);
            articleEnCours = new ArticleBon(temporaire);
            codeDernierArticle = articleEnCours.getDesignation();  //  Afficher code article en cours        
            //articleService.completeLoad(articleEnCours);
        } catch (org.hibernate.ObjectNotFoundException ex) {
            Logger.getLogger(EntreeAction.class.getName()).log(Level.SEVERE, null, ex);
            idDernierArticle = 0;
            codeDernierArticle = "";
        } catch (Exception ex) {
            Logger.getLogger(EntreeAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listeArticle() {
        try {
            listeArticle = bon.getListeArticle();
            if (!listeArticle.isEmpty()) {
                checkList = " ";    //  Afficher liste des articles
            }
        } catch (NullPointerException npe) {
            listeArticle = new ArrayList<>();
        }
    }

    private void loadFournisseur() throws Exception {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(idDernierFournisseur);
        hbdao.findById(fournisseur);
        dernierFournisseur = fournisseur.getNom();  //  Afficher le nom du fournisseur
    }

    private void demandeur() {
        try {
            User demandeur = bon.getDemandeur();
            nomPrenomDemandeur = demandeur.getNom() + " " + demandeur.getPrenom();  //  Afficher nom et prénom du demandeur            
        } catch (NullPointerException npe) {
            nomPrenomDemandeur = "";
        }
    }

    private void setFournisseur(ArticleBon ab) throws Exception {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(idDernierFournisseur);
        hbdao.findById(fournisseur);
        ab.setFournisseur(fournisseur);
    }

    private void setUnites(ArticleBon ab) throws Exception {
//        Unite tp = new Unite(ab.getIdUnite());
        List<Unite> temp = uniteService.getEquivalent(ab.getUnite());
        temp.add(ab.getUnite());
        for (Unite u : temp) {
            if (u.getDesignation().compareToIgnoreCase(unite) == 0) {
                ab.setUnite(u);
                break;
            }
        }
    }

    private void clean() {
        this.idDernierArticle = 0;
        this.idDernierFournisseur = 0;
        this.articleEnCours = null;
        this.codeDernierArticle = "";
        this.coms = "";
        this.dernierFournisseur = "";
        this.prixSelonFournisseur = 0;
    }

//  GETTERS AND SETTERS    
    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public Bon getBon() {
        return bon;
    }

    public void setBon(Bon bon) {
        this.bon = bon;
    }

    public int getIdDernierArticle() {
        return idDernierArticle;
    }

    public void setIdDernierArticle(int idDernierArticle) {
        this.idDernierArticle = idDernierArticle;
    }

    public String getCodeDernierArticle() {
        return codeDernierArticle;
    }

    public void setCodeDernierArticle(String codeDernierArticle) {
        this.codeDernierArticle = codeDernierArticle;
    }

    public List<ArticleBon> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(List<ArticleBon> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public String getCheckList() {
        return checkList;
    }

    public void setCheckList(String checkList) {
        this.checkList = checkList;
    }

    public int getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(int idDemandeur) {
        this.idDemandeur = idDemandeur;
    }

    public String getNomPrenomDemandeur() {
        return nomPrenomDemandeur;
    }

    public void setNomPrenomDemandeur(String nomPrenomDemandeur) {
        this.nomPrenomDemandeur = nomPrenomDemandeur;
    }

    public int getIdDernierFournisseur() {
        return idDernierFournisseur;
    }

    public void setIdDernierFournisseur(int idDernierFournisseur) {
        this.idDernierFournisseur = idDernierFournisseur;
    }

    public String getDernierFournisseur() {
        return dernierFournisseur;
    }

    public void setDernierFournisseur(String dernierFournisseur) {
        this.dernierFournisseur = dernierFournisseur;
    }

    public ArticleBon getArticleEnCours() {
        return articleEnCours;
    }

    public void setArticleEnCours(ArticleBon articleEnCours) {
        this.articleEnCours = articleEnCours;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public double getPrixSelonFournisseur() {
        return prixSelonFournisseur;
    }

    public void setPrixSelonFournisseur(double prixSelonFournisseur) {
        this.prixSelonFournisseur = prixSelonFournisseur;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

    public String getComs() {
        return coms;
    }

    public void setComs(String coms) {
        this.coms = coms;
    }

    public BonService getBonService() {
        return bonService;
    }

    public void setBonService(BonService bonService) {
        this.bonService = bonService;
    }

    public File getPhotos() {
        return photos;
    }

    public void setPhotos(File photos) {
        this.photos = photos;
    }

    public String getDateToday() {
        return dateToday;
    }

    public void setDateToday(String dateToday) {
        this.dateToday = dateToday;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getFacture() {
        return facture;
    }

    public void setFacture(String facture) {
        this.facture = facture;
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }

    public List<Unite> getListeU() {
        return listeU;
    }

    public void setListeU(List<Unite> listeU) {
        this.listeU = listeU;
    }

}
