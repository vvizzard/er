/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Unite;
import com.er.erproject.modele.User;
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
public class UniteAction extends BaseAction {
    private Map session;
        
    private UniteService uniteService;
    private int idUnite = -1;    
    private String designation;
    private String reference = "Defaut";      
    private Double difference;
    private List<Unite> listeUnite;
    private List<Unite> defauts;
    private List<List<String>> listeUniteString;
    
    public String load() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
        //  load List Unite
            listeUnite = uniteService.findAll();
//            listeUniteString = uniteService.findAllAffichage();
//            for(Unite u : listeUnite) if(u.getDesignation().compareToIgnoreCase("none")==0) listeUnite.remove(u);
            defauts = uniteService.findDefauts();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String addUnite() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
            if (!checkLevel(3)) {
                return "access";
            }
        //  load List Unite            
            defauts = uniteService.findDefauts();
        //  Instance of the Unite
            Unite toSave = new Unite();
            toSave.setId(idUnite);            
            toSave.setDesignation(designation);
            for(Unite u : defauts) if(u.getDesignation().compareTo(reference)==0) toSave.setIdReference(u.getId());
            if(reference.compareTo("Defaut")==0) toSave.setDefaut(0);
            toSave.setDifference(difference);
            if(idUnite == -1) uniteService.save(toSave);
            else hbdao.update(toSave);       
            listeUnite = (List<Unite>)(List<?>)hbdao.findAll(new Unite());
//            for(Unite u : listeUnite) if(u.getDesignation().compareToIgnoreCase("none")==0) listeUnite.remove(u);
            clean();
        } catch(Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String deleteUnite() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
            if (!checkLevel(3)) {
                return "access";
            }
        //  Instance of the Unite
            Unite toSave = new Unite();
            toSave.setId(idUnite);                        
            hbdao.delete(toSave);
        //  load List Unite
            listeUnite = (List<Unite>)(List<?>)hbdao.findAll(new Unite());
//            for(Unite u : listeUnite) if(u.getDesignation().compareToIgnoreCase("none")==0) listeUnite.remove(u);
            defauts = uniteService.findDefauts();
            this.idUnite = 0;
        } catch(Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    //  UTILS
    
    
    private void clean() {
        idUnite = -1;
        designation = "";
        reference = "";
        difference = 0.0;
    }
    
//  GETTERS AND SETTERS    

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return reference;
    }

    public void setDescription(String reference) {
        this.reference = reference;
    }

    public List<Unite> getListeUnite() {
        return listeUnite;
    }

    public void setListeUnite(List<Unite> listeUnite) {
        this.listeUnite = listeUnite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Unite> getDefauts() {
        return defauts;
    }

    public void setDefauts(List<Unite> defauts) {
        this.defauts = defauts;
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }

    public List<List<String>> getListeUniteString() {
        return listeUniteString;
    }

    public void setListeUniteString(List<List<String>> listeUniteString) {
        this.listeUniteString = listeUniteString;
    }
    
    
}
