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
public class BaseAssociation extends BaseModele {    
    protected int id1;
    protected int id2;
    protected BaseModele bm1;
    protected BaseModele bm2;
    protected String commentaire;
    protected double montant;
    protected String table;

    public BaseAssociation() {
    }

    public BaseAssociation(int id) {
        super(id);
    }

    public BaseAssociation(int id, int id1, int id2, String commentaire, double montant) {
        super(id);
        this.id1 = id1;
        this.id2 = id2;
        this.commentaire = commentaire;
        this.montant = montant;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public BaseModele getBm1() {
        return bm1;
    }

    public void setBm1(BaseModele bm1) {
        this.bm1 = bm1;
    }

    public BaseModele getBm2() {
        return bm2;
    }

    public void setBm2(BaseModele bm2) {
        this.bm2 = bm2;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    
}
