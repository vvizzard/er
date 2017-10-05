/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Bon;
import com.er.erproject.modele.Projet;
import com.er.erproject.service.BonService;
import com.opensymphony.xwork2.Action;
import java.util.List;

/**
 *
 * @author vvizard
 */
public class JournalAction extends BaseAction {

    private List<Bon> listeBon;
    private BonService bonService;
    private int idProjet;
    private int valueId;
    private String valueDemandeur;
    private String valueDate;    

    public String load() {
        try {
            if(!sessionCheck()) return "tolog";
            listeBon = bonService.findAll();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String recherche() {
        try {
            if(!sessionCheck()) return "tolog";
            listeBon = bonService.rechercher(valueId, valueDemandeur, valueDate);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String listeBon() {
        try {
            if(!sessionCheck()) return "tolog";
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

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public String getValueDemandeur() {
        return valueDemandeur;
    }

    public void setValueDemandeur(String valueDemandeur) {
        this.valueDemandeur = valueDemandeur;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }
    
    
}
