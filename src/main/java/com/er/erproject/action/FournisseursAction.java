/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.User;
import com.er.erproject.modele.Fournisseur;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class FournisseursAction extends BaseAction {        
    private String nom, emplacement, contacte;        
    private int idFournisseur = 0;    
    private List<Fournisseur> listeFournisseur;
    
    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            listeFournisseur = (List<Fournisseur>)(List<?>)hbdao.findAll(new Fournisseur());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    public void clean() {
        nom = null;
        emplacement = null;
        contacte = null;
        idFournisseur = 0;
    }
    
    public String save() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }            
            Fournisseur fournisseur = new Fournisseur();            
            fournisseur.setNom(nom);
            fournisseur.setEmplacement(emplacement);
            fournisseur.setContacte(contacte);
            if(idFournisseur!=0) {
                fournisseur.setId(idFournisseur);                                                
                hbdao.update(fournisseur);
            } else hbdao.save(fournisseur);
            listeFournisseur = (List<Fournisseur>)(List<?>)hbdao.findAll(new Fournisseur());
            clean();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }        
    
    public String delete() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }
            Fournisseur fournisseurToDelete = new Fournisseur(idFournisseur);            
            hbdao.delete(fournisseurToDelete);
            listeFournisseur = (List<Fournisseur>)(List<?>)hbdao.findAll(new Fournisseur());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public List<Fournisseur> getListeFournisseur() {
        return listeFournisseur;
    }

    public void setListeFournisseur(List<Fournisseur> listeFournisseur) {
        this.listeFournisseur = listeFournisseur;
    }    

    public String getContacte() {
        return contacte;
    }

    public void setContacte(String contacte) {
        this.contacte = contacte;
    }
    
    
}
