/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.service.UniteService;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;

/**
 *
 * @author vvizard
 */
public class ConversionJsonAction extends BaseAction {
    private UniteService uniteService;

    private String uniteSelectionnee;
    private double existant;
    private String valeur;
    private String valeurActuel;

    public String load() {        
        try {            
            valeur = UtilService.convertir(valeurActuel, uniteSelectionnee, existant, uniteService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }

    public String getUniteSelectionnee() {
        return uniteSelectionnee;
    }

    public void setUniteSelectionnee(String uniteSelectionnee) {
        this.uniteSelectionnee = uniteSelectionnee;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }      

    public double getExistant() {
        return existant;
    }

    public void setExistant(double existant) {
        this.existant = existant;
    }

    public String getValeurActuel() {
        return valeurActuel;
    }

    public void setValeurActuel(String valeurActuel) {
        this.valeurActuel = valeurActuel;
    }
    
    
}
