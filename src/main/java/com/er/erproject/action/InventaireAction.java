/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Inventaire;
import com.er.erproject.modele.Unite;
import com.er.erproject.modele.User;
import com.er.erproject.service.InventaireService;
import com.er.erproject.service.UniteService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class InventaireAction extends BaseAction {

    private List<Inventaire> listeInventaire;
    private InventaireService inventaireService;
    private UniteService uniteService;

    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            listeInventaire = inventaireService.findAll();
            List<Unite> test = uniteService.getEquivalent(listeInventaire.get(2).getUnite());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<Inventaire> getListeInventaire() {
        return listeInventaire;
    }

    public void setListeInventaire(List<Inventaire> listeInventaire) {
        this.listeInventaire = listeInventaire;
    }

    public InventaireService getInventaireService() {
        return inventaireService;
    }

    public void setInventaireService(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }        

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }
    
    
}
