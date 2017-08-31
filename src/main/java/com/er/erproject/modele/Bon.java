/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vvizard
 */
public class Bon extends BaseModele {
    private User demandeur;//
    private int idDemandeur;//
    private Projet projet;
    private int idProjet;
    private String type;//
    private Date valide;
    private Date confirme;
    private Date date;//
    private List<ArticleBon> listeArticle;//
    private String photo;//
    private File filePhoto;

    public Bon() {
    }

    public Bon(int id) {
        super(id);
    }

    public Bon(User demandeur, Projet projet, String type, Date valide, Date confirme, Date date, int id) {
        super(id);
        this.demandeur = demandeur;
        this.projet = projet;
        this.type = type;
        this.valide = valide;
        this.confirme = confirme;
        this.date = date;
    }

    public User getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(User demandeur) {
        this.demandeur = demandeur;
        setIdDemandeur(demandeur.getId());
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
        setIdProjet(projet.getId());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValide() {
        return valide;
    }
    
    public String getValideString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(valide);
    }

    public void setValide(Date valide) {
        this.valide = valide;
    }

    public Date getConfirme() {
        return confirme;
    }

    public void setConfirme(Date confirme) {
        this.confirme = confirme;
    }
    
    public String getConfirmeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(confirme);
    }

    public Date getDate() {
        return date;
    }
    
    public String getDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.date = formatter.parse(date);
    }

    public List<ArticleBon> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(List<ArticleBon> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public int getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(int idDemandeur) {
        this.idDemandeur = idDemandeur;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public File getFilePhoto() {
        return filePhoto;
    }

    public void setFilePhoto(File filePhoto) {
        this.filePhoto = filePhoto;
    }   
}
