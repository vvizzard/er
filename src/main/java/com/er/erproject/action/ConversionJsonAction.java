/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.service.ArticleService;
import com.er.erproject.service.UniteService;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vvizard
 */
public class ConversionJsonAction extends BaseAction {
    private UniteService uniteService;
    private ArticleService articleService;

    private String uniteSelectionnee;
    private double existant;
    private String valeur;
    private String valeurActuel;
    
    private List<String> listeArticle;
    private String debutArticle;
    
    private List<String> listeFournisseur;
    private int idDernierArticle;
    private int idFournisseur;
    
    private String designationArticle;
    
    private List<List<String>> listeFournisseursComplet;

    public String load() {        
        try {            
            valeur = UtilService.convertir(valeurActuel, uniteSelectionnee, existant, uniteService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }
    
    public String getListeArticleJson() {
        try {            
            listeArticle = articleService.find(debutArticle);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }
    
    public String getListeFournisseurJson() {
        try {            
            listeFournisseur = UtilService.find(debutArticle, idDernierArticle, hbdao);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }
    
    public String getIdArticleJson() {
        try {            
            idDernierArticle = hbdao.find("article", designationArticle);
            List<String> test = new ArrayList<>();
            test.add(Integer.toString(idDernierArticle));
            listeFournisseur = uniteService.findUniteStringByIdArticle(idDernierArticle);   
            List<String> temp3 = new ArrayList<>();
            temp3.add(articleService.findNombreDisponible(idDernierArticle));
            listeFournisseursComplet = new ArrayList<>();
            listeFournisseursComplet.add(test);            
            listeFournisseursComplet.add(listeFournisseur);            
            listeFournisseursComplet.add(temp3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }        
    
    public String getIdFournisseurJson() {
        try {            
            idFournisseur = hbdao.find("id", "fournisseur", "nom", designationArticle);
            List<String> test = new ArrayList<>();
            test.add(Integer.toString(idFournisseur));
            listeFournisseur = new ArrayList<>();
            String test2 = UtilService.findMontantByArticleFournisseur(idFournisseur, idDernierArticle, hbdao);
            listeFournisseur.add(test2);
            listeFournisseursComplet = new ArrayList<>();
            listeFournisseursComplet.add(test);            
            listeFournisseursComplet.add(listeFournisseur);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }

    public String getUniteSelectionnee() {
        return uniteSelectionnee;
    }

    public void setUniteSelectionnee(String uniteSelectionnee) {
        this.uniteSelectionnee = uniteSelectionnee;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }      

    public double getExistant() {
        return existant;
    }

    public void setExistant(double existant) {
        this.existant = existant;
    }

    public String getValeurActuel() {
        return valeurActuel;
    }

    public void setValeurActuel(String valeurActuel) {
        this.valeurActuel = valeurActuel;
    }    

    public List<String> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(List<String> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public String getDebutArticle() {
        return debutArticle;
    }

    public void setDebutArticle(String debutArticle) {
        this.debutArticle = debutArticle;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public int getIdDernierArticle() {
        return idDernierArticle;
    }

    public void setIdDernierArticle(int idDernierArticle) {
        this.idDernierArticle = idDernierArticle;
    }

    public List<String> getListeFournisseur() {
        return listeFournisseur;
    }

    public void setListeFournisseur(List<String> listeFournisseur) {
        this.listeFournisseur = listeFournisseur;
    }

    public String getDesignationArticle() {
        return designationArticle;
    }

    public void setDesignationArticle(String designationArticle) {
        this.designationArticle = designationArticle;
    }

    public List<List<String>> getListeFournisseursComplet() {
        return listeFournisseursComplet;
    }

    public void setListeFournisseursComplet(List<List<String>> listeFournisseursComplet) {
        this.listeFournisseursComplet = listeFournisseursComplet;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }
    
    
}
