/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.User;
import com.er.erproject.modele.VueInventaire;
import com.er.erproject.service.InventaireService;
import com.er.erproject.service.UniteService;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class InventaireAction extends BaseAction {

    private List<VueInventaire> listeInventaire;
    private InventaireService inventaireService;
    private UniteService uniteService;
    private String famille;
    private String emplacement;
    private String critere = "";
    private List<String> listeFamille;
    private List<String> listeEmplacement;

    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            listeInventaire = (List<VueInventaire>)(List<?>)hbdao.findAll(new VueInventaire());            
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
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            listeInventaire = (List<VueInventaire>)(List<?>)UtilService.filtreInventaire(critere, famille, emplacement, hbdao);
            listeFamille = UtilService.listeString("vueinventaire", "famille", hbdao);
            listeEmplacement = UtilService.listeString("vueinventaire", "emplacement", hbdao);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<VueInventaire> getListeInventaire() {
        return listeInventaire;
    }

    public void setListeInventaire(List<VueInventaire> listeInventaire) {
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

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }        

    public String getCritere() {
        return critere;
    }

    public void setCritere(String critere) {
        this.critere = critere;
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
    
    
}
