/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.VueHistoriqueBon;
import com.er.erproject.modele.VueHistoriqueProjet;
import com.opensymphony.xwork2.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvizard
 */
public class ListeHistoriqueAction extends BaseAction {

    private List<VueHistoriqueProjet> listeProjet;
    
//  list    
    private List<VueHistoriqueBon> listeHistorique;
    
//  recherche    
    private String refBon;
    private String demandeur;
    private String projet;
    private String type;
    private String article;
    private String facture;    
    private String debut;
    private String fin;
    private double nbrMin;
    private double nbrMax;
    private double valeurMin;
    private double valeurMax;

    public String load() {
        try {
            if(!sessionCheck()) return "tolog";            
            completeListe();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    private void completeListe() {        
        try {
            List<VueHistoriqueProjet> listeProjetBrute = (List<VueHistoriqueProjet>)(List<?>) hbdao.findAll(new VueHistoriqueProjet());
            listeProjet = new ArrayList<>();
            for(VueHistoriqueProjet v : listeProjetBrute) {
                if(listeProjet.isEmpty()) listeProjet.add(v);
                else {
                    for(VueHistoriqueProjet vhp : listeProjet) if(v.getId()!= vhp.getId()) listeProjet.add(v);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListeHistoriqueAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String historique() {
        try {
            if(!sessionCheck()) return "tolog";            
            listeHistorique = (List<VueHistoriqueBon>)(List<?>) hbdao.findAll(new VueHistoriqueBon());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<VueHistoriqueProjet> getListeProjet() {
        return listeProjet;
    }

    public void setListeProjet(List<VueHistoriqueProjet> listeProjet) {
        this.listeProjet = listeProjet;
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

    public List<VueHistoriqueBon> getListeHistorique() {
        return listeHistorique;
    }

    public void setListeHistorique(List<VueHistoriqueBon> listeHistorique) {
        this.listeHistorique = listeHistorique;
    }

    public String getRefBon() {
        return refBon;
    }

    public void setRefBon(String refBon) {
        this.refBon = refBon;
    }

    public String getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(String demandeur) {
        this.demandeur = demandeur;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getFacture() {
        return facture;
    }

    public void setFacture(String facture) {
        this.facture = facture;
    }

    public double getNbrMin() {
        return nbrMin;
    }

    public void setNbrMin(double nbrMin) {
        this.nbrMin = nbrMin;
    }

    public double getNbrMax() {
        return nbrMax;
    }

    public void setNbrMax(double nbrMax) {
        this.nbrMax = nbrMax;
    }

    public double getValeurMin() {
        return valeurMin;
    }

    public void setValeurMin(double valeurMin) {
        this.valeurMin = valeurMin;
    }

    public double getValeurMax() {
        return valeurMax;
    }

    public void setValeurMax(double valeurMax) {
        this.valeurMax = valeurMax;
    }
    
    
}
