/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Bon;
import com.er.erproject.modele.Projet;
import com.er.erproject.modele.User;
import com.er.erproject.service.BonService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class JournalAction extends BaseAction {

    private List<Bon> listeBon;
    private BonService bonService;
    private int idProjet;

    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            listeBon = bonService.findAll();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String listeBon() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            Projet projetTemp = new Projet(idProjet);
            listeBon = bonService.rechercher(projetTemp);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<Bon> getListeBon() {
        return listeBon;
    }

    public void setListeBon(List<Bon> listeBon) {
        this.listeBon = listeBon;
    }

    public BonService getBonService() {
        return bonService;
    }

    public void setBonService(BonService bonService) {
        this.bonService = bonService;
    }        

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
    
    
}
