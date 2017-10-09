/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.VueHistoriqueBon;
import com.er.erproject.modele.VueHistoriqueProjet;
import com.er.erproject.service.VueHistoriqueBonService;
import com.opensymphony.xwork2.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvizard
 */
public class ListeHistoriqueAction extends BaseAction {

    private List<VueHistoriqueProjet> listeProjet;
    private VueHistoriqueBonService vueHistoriqueBonService;
//  list    
    private List<VueHistoriqueBon> listeHistorique;
    
//  recherche    
    private String refBon;
    private String demandeur;
    private String projet;
    private String type = "";
    private String article;
    private String facture;    
    private String debut;
    private String fin;
    private double nbrMin;
    private double nbrMax;
    private double valeurMin;
    private double valeurMax;
    private String page = "1";
    private List<String> nbrPage;

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
    
    public String recherche() {
        try {
            if(!sessionCheck()) return "tolog";            
            Map critere = new HashMap<>();
            if(refBon.compareTo("")==0) critere.putIfAbsent("refBon", null);
            if(refBon.compareTo("")!=0) critere.putIfAbsent("refBon", refBon);
            critere.putIfAbsent("demandeur", demandeur);
            critere.putIfAbsent("projet", projet);
            critere.putIfAbsent("type", type);
            critere.putIfAbsent("article", article);
            critere.putIfAbsent("facture", facture);
            critere.putIfAbsent("debut", debut);
            critere.putIfAbsent("fin", fin);
            critere.putIfAbsent("nbrMin", nbrMin);
            critere.putIfAbsent("nbrMax", nbrMax);
            critere.putIfAbsent("valeurMin", valeurMin);
            critere.putIfAbsent("valeurMax", valeurMax);
            critere.putIfAbsent("page", Integer.parseInt(page));
            listeHistorique = vueHistoriqueBonService.find(critere);
            fillPagination(critere);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }
    
    private void fillPagination(Map critere) throws Exception {
        long total = vueHistoriqueBonService.rowNumber(critere);
        List<Integer> val = new ArrayList<>();
        int i;
        long finPas = total/10;
        for(i = 1; i <= finPas; i++) {
            val.add(i);
        }
        if(total - (i - 1) > 0)val.add(i);  
        nbrPage = new ArrayList<>();
        for(Integer temp : val) nbrPage.add(temp.toString());        
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

    public VueHistoriqueBonService getVueHistoriqueBonService() {
        return vueHistoriqueBonService;
    }

    public void setVueHistoriqueBonService(VueHistoriqueBonService vueHistoriqueBonService) {
        this.vueHistoriqueBonService = vueHistoriqueBonService;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<String> getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(List<String> nbrPage) {
        this.nbrPage = nbrPage;
    }
    
}
