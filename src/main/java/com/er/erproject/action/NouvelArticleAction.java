/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Article;
import com.er.erproject.modele.AssociationArticleFournisseur;
import com.er.erproject.modele.AssociationArticleUnite;
import com.er.erproject.modele.Unite;
import com.er.erproject.modele.User;
import com.er.erproject.service.ArticleService;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class NouvelArticleAction extends BaseAction {
    private Map session;
    
    private ArticleService articleService;
    private int idFamille;
    private String codeArticle = "";
    private String designation;
    private List<Unite> unites;    
    private String emplacement;
    private List<AssociationArticleUnite> associationArticleUnite;
    private List<AssociationArticleFournisseur> associationArticleFournisseur;            
    
    public String load() {
        try {            
        //  check session
            if(!sessionCheck()) return Action.ERROR;
        //  envoyer associations dans la session
            associationArticleUnite = new ArrayList<>();
            associationArticleFournisseur = new ArrayList<>();            
        //  bon.setListeArticle(listeArticle);
            session.put("unite", associationArticleUnite);
            session.put("fournisseur", associationArticleFournisseur);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String addArticle() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
        //  Instance of the Article
            Article toSave = new Article();
            toSave.setIdFamille(idFamille);
            toSave.setCode(codeArticle);
            toSave.setDesignation(designation);
            toSave.setEmplacement(emplacement);
            toSave.setAssociationArticleFournisseur(associationArticleFournisseur);
            toSave.setAssociationArticleUnite(associationArticleUnite);
            articleService.save(toSave);
        } catch(Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    //  UTILS
    
    
//  GETTERS AND SETTERS    

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public int getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
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
}
