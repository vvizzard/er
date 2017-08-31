/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.Article;
import com.er.erproject.modele.AssociationArticleFournisseur;
import com.er.erproject.modele.AssociationArticleUnite;
import com.er.erproject.modele.Famille;
import com.er.erproject.modele.Fournisseur;
import com.er.erproject.modele.Unite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vvizard
 */
public class ArticleService extends BaseService {    
    private AssociationService associationService;
    
    public void find(Article a) throws Exception {
        hbdao.findById(a);
        completeLoad(a);
    }
    
    public List<Article> findAll() throws Exception {
        List<Article> valiny = (List<Article>)(List<?>) hbdao.findAll(new Article());
        for(Article at : valiny) {
            completeLoad(at);
        }
        return valiny;
    }        
    
    public void save(Article a) throws Exception {
        hbdao.save(a);
        for(AssociationArticleFournisseur aaf : a.getAssociationArticleFournisseur()) {
            aaf.setId1(a.getId());
            hbdao.save(aaf);
        }
        for(AssociationArticleUnite aau : a.getAssociationArticleUnite()) {
            aau.setId1(a.getId());
            hbdao.save(aau);
        }
    }
    
    public void delete(Article a) throws Exception {
        find(a);
        List<AssociationArticleFournisseur> aaf = a.getAssociationArticleFournisseur();
        for(AssociationArticleFournisseur aafT : aaf) hbdao.delete(aafT);    
        
        List<Unite> listeU = a.getUnites();
        
        
        List<AssociationArticleUnite> aau = a.getAssociationArticleUnite();
        for(AssociationArticleUnite aafT : aau) hbdao.delete(aafT);                
        hbdao.delete(a);
    }
    
    public void update(Article a) throws Exception {
        hbdao.update(a);
    }

    public AssociationService getAssociationService() {
        return associationService;
    }

    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
    }        
    
    public void completeLoad(Article a) throws Exception {
        Famille f = new Famille();
        f.setId(a.getIdFamille());
        hbdao.findById(f);
        a.setFamille(f);
        Unite u = new Unite();
        u.setId(a.getIdUnite());
        hbdao.findById(u);
        a.setUnite(u);
//        AssociationArticleUnite aau = new AssociationArticleUnite();
//        aau.setTable("AssociationArticleUnite");
//        a.setUnites((List<Unite>)(List<?>)associationService.findBm(aau, a.getId(), "unite", "article"));
        
//        List<AssociationArticleFournisseur> lT = (List<AssociationArticleFournisseur>)(List<?>)hbdao.findAll(new AssociationArticleFournisseur());
//        List<AssociationArticleFournisseur> lf = new ArrayList<>();
//        for(AssociationArticleFournisseur aaf : lT) {
//            Fournisseur ff = new Fournisseur(aaf.getId2());
//            hbdao.findById(ff);
//            aaf.setFournisseur(ff);
//            if(aaf.getArticle().getId()==a.getId())lf.add(aaf);
//        }                
//        a.setAssociationArticleFournisseur(lf);
//        
//        List<AssociationArticleUnite> uT = (List<AssociationArticleUnite>)(List<?>)hbdao.findAll(new AssociationArticleUnite());
//        List<AssociationArticleUnite> uf = new ArrayList<>();
//        for(AssociationArticleUnite aaf : uT) {
//            if(aaf.getArticle().getId()==a.getId())uf.add(aaf);
//            hbdao.findById(new Unite(aaf.getId2()));
//        }                
//        
//        a.setAssociationArticleUnite(uf);
//        
//        int t = 0;
    }
}
