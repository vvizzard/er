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
public class Barcode extends BaseModele {
    private int idBon;
    private int idArticle;

    public Barcode() {
    }

    public Barcode(int id) {
        super(id);
    }

    public Barcode(int idBon, int idArticle) {
        this.idBon = idBon;
        this.idArticle = idArticle;
    }

    public int getIdBon() {
        return idBon;
    }

    public void setIdBon(int idBon) {
        this.idBon = idBon;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    
}
