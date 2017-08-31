/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.AssociationArticleFournisseur;
import com.er.erproject.modele.Fournisseur;
import com.er.erproject.modele.User;
import com.er.erproject.service.AssociationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class FournisseurAction extends BaseAction {
    private AssociationService associationService;
    private List<Fournisseur> listeFournisseur;
    private int idDernierArticle;
    private double prix;
    private int type;

    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            if(idDernierArticle != 0) {
                listeFournisseur = (List<Fournisseur>)(List<?>) associationService.findBm(new AssociationArticleFournisseur(), idDernierArticle, "fournisseur", "article");
                List<AssociationArticleFournisseur> listeTemp = (List<AssociationArticleFournisseur>)(List<?>) associationService.findAll(new AssociationArticleFournisseur(), "article", idDernierArticle);
                prix = listeTemp.get(0).getMontant();
            }
            else listeFournisseur = (List<Fournisseur>)(List<?>) hbdao.findAll(new Fournisseur());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<Fournisseur> getListeFournisseur() {
        return listeFournisseur;
    }

    public void setListeFournisseur(List<Fournisseur> listeFournisseur) {
        this.listeFournisseur = listeFournisseur;
    }

    public int getIdDernierArticle() {
        return idDernierArticle;
    }

    public void setIdDernierArticle(int idDernierArticle) {
        this.idDernierArticle = idDernierArticle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }        

    public AssociationService getAssociationService() {
        return associationService;
    }

    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
    }        

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
