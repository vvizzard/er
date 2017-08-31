/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vvizard
 */
public class User extends BaseModele {
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateEmbauche;
    private String matricule;
    private String identifiant;
    private String pw;
    private Departement departement;
    private int idDepartement;
    private String cin;

    public User() {
    }

    public User(int identifiant) {
        super(identifiant);
    }

    public User(String nom, String prenom, Date dateNaissance, Date dateEmbauche, String matricule, int identifiant, Departement departement) {
        super(identifiant);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.matricule = matricule;
        this.departement = departement;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    public String getDateNaissanceString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(dateNaissance);
    }
    
    public String getDateNaissanceString(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(dateNaissance);
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public void setDateNaissance(String dateNaissance) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.dateNaissance = formatter.parse(dateNaissance);         
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }
    
    public String getDateEmbaucheString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(dateEmbauche);
    }
    
    public String getDateEmbaucheString(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(dateEmbauche);
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
    public void setDateEmbauche(String dateEmbauche) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.dateEmbauche = formatter.parse(dateEmbauche);        
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }    

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }    

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiant() {
        return identifiant;
    }        

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    
}
