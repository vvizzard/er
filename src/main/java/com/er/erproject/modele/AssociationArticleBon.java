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
public class AssociationArticleBon extends BaseAssociation {        
    private Article article;
    private Bon bon;
    private int idUnite;
    private Unite unite;
    private double prixu;
    private double prixt;
    private double nbrDisponible;
    
    public AssociationArticleBon() {
    }

    public AssociationArticleBon(int id) {
        super(id);
    }

    public AssociationArticleBon(int id, int id1, int id2, String commentaire, double montant, Article article, Bon bon) {
        super(id, id1, id2, commentaire, montant);
        this.article = article;
        this.bon = bon;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Bon getBon() {
        return bon;
    }

    public void setBon(Bon bon) {
        this.bon = bon;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public double getPrixu() {
        return prixu;
    }

    public void setPrixu(double prixu) {
        this.prixu = prixu;
    }

    public double getNbrDisponible() {
        return nbrDisponible;
    }

    public void setNbrDisponible(double nbrDisponible) {
        this.nbrDisponible = nbrDisponible;
    }

    public double getPrixt() {
        return prixt;
    }

    public void setPrixt(double prixt) {
        this.prixt = prixt;
    }

    
}
