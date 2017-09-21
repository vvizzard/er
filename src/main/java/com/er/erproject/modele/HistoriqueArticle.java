/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vvizard
 */
public class HistoriqueArticle extends BaseModele {
    private String nom;
    private String prenom;
    private String projet;
    private Date date;
    private String facture;
    private String photo;
    private int idArticle;
    private String unite;
    private Double montant;
    private Double prixU;

    public HistoriqueArticle() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public Date getDate() {
        return date;
    }
    
    public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        return sdf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFacture() {
        return facture;
    }

    public void setFacture(String facture) {
        this.facture = facture;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getMontant() {
        return montant;
    }

    
    
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public double getPrixU() {
        return prixU;
    }

    
    
    public void setPrixU(Double prixU) {
        this.prixU = prixU;
    }
}
