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
public class AssociationArticleFournisseur extends BaseAssociation {        
    private Article article;
    private Fournisseur fournisseur;
    
    public AssociationArticleFournisseur() {
    }

    public AssociationArticleFournisseur(int id) {
        super(id);
    }

    public AssociationArticleFournisseur(int id, int id1, int id2, String commentaire, double montant, Article article, Fournisseur fournisseur) {
        super(id, id1, id2, commentaire, montant);
        this.article = article;
        this.fournisseur = fournisseur;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    
}
