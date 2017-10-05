/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Departement;
import com.opensymphony.xwork2.Action;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class DepartementAction extends BaseAction {

    private Map session;

    private int idDepartement = -1, niveau = -1;
    private String designation;

    private List<Departement> listeDepartement;

    public String load() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            //  load List Departement
            listeDepartement = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String addDepartement() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(4)) {
                return "access";
            }
            //  Instance of the Departement
            Departement toSave = new Departement();
            toSave.setId(idDepartement);
            toSave.setDesignation(designation);
            toSave.setNiveau(niveau);
            if (idDepartement == -1) {
                hbdao.save(toSave);
            } else {
                hbdao.update(toSave);
            }
            listeDepartement = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            clean();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String deleteDepartement() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            if (!checkLevel(4)) {
                return "access";
            }
            //  Instance of the Departement
            Departement toSave = new Departement();
            toSave.setId(idDepartement);
            hbdao.delete(toSave);
            //  load List Departement
            listeDepartement = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            this.idDepartement = 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String annuler() {
        try {
            //  check session
            if (!sessionCheck()) {
                return "tolog";
            }
            idDepartement = -1;
            niveau = -1;
            designation = null;
            listeDepartement = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    //  UTILS
    private void clean() {
        idDepartement = -1;
        designation = "";
        niveau = 0;
    }

//  GETTERS AND SETTERS    
    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Departement> getListeDepartement() {
        return listeDepartement;
    }

    public void setListeDepartement(List<Departement> listeDepartement) {
        this.listeDepartement = listeDepartement;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
