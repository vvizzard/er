/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Fournisseur;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import java.util.List;

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
            if(!sessionCheck()) return "tolog";
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
            if(!sessionCheck()) return "tolog";     
            if (!checkLevel(3)) {
                return "access";
            }
            Fournisseur fournisseur = new Fournisseur();            
            fournisseur.setNom(nom);
            fournisseur.setEmplacement(emplacement);
            fournisseur.setContacte(contacte);
            if(idFournisseur!=0) {
                fournisseur.setId(idFournisseur);                                                
                hbdao.update(fournisseur);
            } else {
                if(UtilService.checkDoublonFournisseur(fournisseur, hbdao))
                hbdao.save(fournisseur);
            }
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
            if(!sessionCheck()) return "tolog";
            if (!checkLevel(3)) {
                return "access";
            }
            Fournisseur fournisseurToDelete = new Fournisseur(idFournisseur);            
            hbdao.delete(fournisseurToDelete);
            listeFournisseur = (List<Fournisseur>)(List<?>)hbdao.findAll(new Fournisseur());
            this.idFournisseur = 0;
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
