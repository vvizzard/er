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
public class HistoriqueArticleBonAction extends BaseAction {

    private List<HistoriqueArticle> listeHistorique;        
    private String article;
    private int idBon;

    public String load() {
        try {
            if(!sessionCheck()) return "tolog";
            listeHistorique = UtilService.listeHistoriqueArticle(idBon, hbdao);
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

    public int getIdBon() {
        return idBon;
    }

    public void setIdBon(int idBon) {
        this.idBon = idBon;
    }           
}
