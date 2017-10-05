/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.HistoriqueArticle;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import java.util.List;

/**
 *
 * @author vvizard
 */
public class HistoriqueArticleAction extends BaseAction {

    private List<HistoriqueArticle> listeHistorique;        
    private String article;
    private int idArticle;
    private String debut = "";
    private String fin = "";

    public String load() {
        try {
            if(!sessionCheck()) return "tolog";
//            List<String[]> critere = new ArrayList<>();
//            String[] ss = new String[2];
//            ss[0] = "idArticle";
//            ss[1] = article;
//            critere.add(ss);
            listeHistorique = (List<HistoriqueArticle>)(List<?>)hbdao.findAllByIdCriteria(new HistoriqueArticle(), "idArticle", idArticle);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }  
    
    public String recherche() {
        try {
            if(!sessionCheck()) return "tolog";
            listeHistorique = UtilService.filtreHistoriqueArticle(debut, fin, hbdao);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }  

    public List<HistoriqueArticle> getListeHistorique() {
        return listeHistorique;
    }

    public void setListeHistorique(List<HistoriqueArticle> listeHistorique) {
        this.listeHistorique = listeHistorique;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    
    
}
