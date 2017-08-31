/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

/**
 *
 * @author vvizard
 */
public class Fournisseur extends BaseModele {
    private String nom;
    private String emplacement;
    private String contacte;

    public Fournisseur() {
    }

    public Fournisseur(int id) {
        super(id);
    }

    public Fournisseur(String nom, String emplacement, int id) {
        super(id);
        this.nom = nom;
        this.emplacement = emplacement;
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

    public String getContacte() {
        return contacte;
    }

    public void setContacte(String contacte) {
        this.contacte = contacte;
    }
    
    
}
