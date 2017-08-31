/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

import java.util.List;

/**
 *
 * @author vvizard
 */
public class Article extends BaseModele {
    private int idFamille;
    private Famille famille;
    private String code;
    private String designation;
    private Unite unite;
    private int idUnite;
    private double limite;
    private String emplacement;
    private List<Unite> unites;    
    private List<AssociationArticleFournisseur> associationArticleFournisseur;
    private List<AssociationArticleUnite> associationArticleUnite;        

    public Article() {
    }

    public Article(int id) {
        super(id);
    }

    public Article(int id, int idFamille, Famille famille, String code, String designation) {
        super(id);
        this.idFamille = idFamille;
        this.famille = famille;
        this.code = code;
        this.designation = designation;
    }  

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
    }

    public List<Unite> getUnites() {
        return unites;
    }

    public void setUnites(List<Unite> unites) {
        this.unites = unites;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public List<AssociationArticleFournisseur> getAssociationArticleFournisseur() {
        return associationArticleFournisseur;
    }

    public void setAssociationArticleFournisseur(List<AssociationArticleFournisseur> associationArticleFournisseur) {
        this.associationArticleFournisseur = associationArticleFournisseur;
    }

    public List<AssociationArticleUnite> getAssociationArticleUnite() {
        return associationArticleUnite;
    }

    public void setAssociationArticleUnite(List<AssociationArticleUnite> associationArticleUnite) {
        this.associationArticleUnite = associationArticleUnite;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
}
