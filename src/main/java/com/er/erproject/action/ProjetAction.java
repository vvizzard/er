/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Projet;
import com.er.erproject.modele.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class ProjetAction extends BaseAction {    
    private List<Projet> listeProjet;
    private int idDernierArticle;
    private double prix;
    private int type;
    private int idDemandeur;

    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }            
            else listeProjet = (List<Projet>)(List<?>) hbdao.findAll(new Projet());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<Projet> getListeProjet() {
        return listeProjet;
    }

    public void setListeProjet(List<Projet> listeProjet) {
        this.listeProjet = listeProjet;
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
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(int idDemandeur) {
        this.idDemandeur = idDemandeur;
    }
    
    
}
