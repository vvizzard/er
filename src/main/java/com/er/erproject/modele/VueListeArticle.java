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
public class VueListeArticle extends BaseModele{
    private int idFamille;
    private String famille;
    private String code;
    private String designation;
    private String unite;
    private int idUnite;
    private double limite;
    private String emplacement;        

    public VueListeArticle() {
    }

    public VueListeArticle(int id) {
        super(id);
    }

    public VueListeArticle(int idFamille, String famille, String code, String designation, String unite, int idUnite, double limite, String emplacement, int id) {
        super(id);
        this.idFamille = idFamille;
        this.famille = famille;
        this.code = code;
        this.designation = designation;
        this.unite = unite;
        this.idUnite = idUnite;
        this.limite = limite;
        this.emplacement = emplacement;
    }

    public int getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
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

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
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

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    
}
