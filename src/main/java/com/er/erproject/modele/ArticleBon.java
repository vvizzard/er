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
public class ArticleBon extends Article {
    private double nombre;
    private Unite unite;
    private Fournisseur fournisseur;
    private double prixUnitaire;

    public ArticleBon() {
    }

    public ArticleBon(double nombre, Unite unite, Fournisseur fournisseur, double prixUnitaire) {
        this.nombre = nombre;
        this.unite = unite;
        this.fournisseur = fournisseur;
        this.prixUnitaire = prixUnitaire;
    }
    
    public ArticleBon(Article article) {
        super.setCode(article.getCode());
        super.setDesignation(article.getDesignation());
        super.setIdFamille(article.getIdFamille());
        super.setFamille(article.getFamille());
        super.setId(article.getId());
        super.setUnites(article.getUnites());
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public double getPrixTotal() {
        return prixUnitaire*nombre;
    }
}
