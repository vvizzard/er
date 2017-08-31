/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Famille;
import com.er.erproject.modele.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class FamilleAction extends BaseAction {
    private Map session;
        
    private int idFamille = -1;    
    private String designation;
    private String description;      
    private List<Famille> listeFamille;
    
    public String load() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
        //  load List Famille
            listeFamille = (List<Famille>)(List<?>)hbdao.findAll(new Famille());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public String addFamille() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
        //  Instance of the Famille
            Famille toSave = new Famille();
            toSave.setId(idFamille);            
            toSave.setDesignation(designation);
            toSave.setDescription(description);
            if(idFamille == -1) hbdao.save(toSave);
            else hbdao.update(toSave);
        //  load List Famille
            listeFamille = (List<Famille>)(List<?>)hbdao.findAll(new Famille());
            clean();
        } catch(Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String deleteFamille() {
        try {            
        //  check session
            if(!sessionCheck()) return "tolog";
        //  Instance of the Famille
            Famille toSave = new Famille();
            toSave.setId(idFamille);                        
            hbdao.delete(toSave);
        //  load List Famille
            listeFamille = (List<Famille>)(List<?>)hbdao.findAll(new Famille());
        } catch(Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    //  UTILS
    private boolean sessionCheck() throws Exception {        
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        return checkUser();
    }
    
    private void clean() {
        idFamille = -1;
        designation = "";
        description = "";
    }
    
//  GETTERS AND SETTERS    

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public int getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Famille> getListeFamille() {
        return listeFamille;
    }

    public void setListeFamille(List<Famille> listeFamille) {
        this.listeFamille = listeFamille;
    }
    
}
