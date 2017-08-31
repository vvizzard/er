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
public class Conversion extends BaseAssociation {
    private Unite unite;
    private Unite valeur;    

    public Conversion() {
    }

    public Conversion(int id) {
        super(id);
    }

    public Conversion(Unite unite, Unite valeur, double montant, String commentaire, int id) {
        super(id);
        this.unite = unite;
        this.valeur = valeur;
        this.montant = montant;
        this.commentaire = commentaire;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Unite getValeur() {
        return valeur;
    }

    public void setValeur(Unite valeur) {
        this.valeur = valeur;
    }

       
}
