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
public class AssociationArticleUnite extends BaseAssociation {        
    private Article article;
    private Unite unite;
    
    public AssociationArticleUnite() {
    }

    public AssociationArticleUnite(int id) {
        super(id);
    }

    public AssociationArticleUnite(int id, int id1, int id2, String commentaire, double montant, Article article, Unite unite) {
        super(id, id1, id2, commentaire, montant);
        this.article = article;
        this.unite = unite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
        super.setId1(article.getId());
    }

    public Unite getUnite() {
        return unite;        
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
        super.setId2(unite.getId());
    }

    
}
