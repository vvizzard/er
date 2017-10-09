/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.User;
import com.er.erproject.modele.VueInventaire;
import com.er.erproject.service.InventaireService;
import com.er.erproject.service.PdfService;
import com.er.erproject.service.UniteService;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class InventaireAction extends BaseAction {
//    private Map session;

    private List<VueInventaire> listeInventaire;
    private InventaireService inventaireService;
    private UniteService uniteService;
    private String famille;
    private String emplacement;
    private String critere = "";
    private List<String> listeFamille;
    private List<String> listeEmplacement;
    private String totalValeur;
    private String nbrSM = "0", nbrSA = "0", nbrSS = "0", typeFiltreS = "0", totalArticle = "0";
    private FileInputStream fileInputStream;

    public String load() {
        try {
            if (!sessionCheck()) {
                return "tolog";
            }
            listeInventaire = UtilService.listeVueInventaire(hbdao);
            listeFamille = UtilService.listeString("vueinventaire", "famille", hbdao);
            listeEmplacement = UtilService.listeString("vueinventaire", "emplacement", hbdao);
            PdfService pdf = new PdfService();
            pdf.getInventairePdf(listeInventaire);
            totalValeur = inventaireService.findValeurTotal();
            nbrSM = inventaireService.findSM();
            nbrSA = inventaireService.findSA();
            nbrSS = inventaireService.findSS();
            totalArticle = inventaireService.findTotal();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String download() {
        try {
            if (!sessionCheck()) {
                return "tolog";
            }
            File fileToDownload = new File("E:/vvizard/Projet en cours/ERproject/src/main/webapp/preuveEntree/Inventaire.pdf");
            String fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String recherche() {
        try {
            if (!sessionCheck()) {
                return "tolog";
            }
            listeInventaire = (List<VueInventaire>) (List<?>) UtilService.filtreInventaire(critere, famille, emplacement, typeFiltreS, hbdao);
            listeFamille = UtilService.listeString("vueinventaire", "famille", hbdao);
            listeEmplacement = UtilService.listeString("vueinventaire", "emplacement", hbdao);
            totalValeur = inventaireService.findValeurTotal();
            nbrSM = inventaireService.findSM();
            nbrSA = inventaireService.findSA();
            nbrSS = inventaireService.findSS();
            totalArticle = inventaireService.findTotal();
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public List<VueInventaire> getListeInventaire() {
        return listeInventaire;
    }

    public void setListeInventaire(List<VueInventaire> listeInventaire) {
        this.listeInventaire = listeInventaire;
    }

    public InventaireService getInventaireService() {
        return inventaireService;
    }

    public void setInventaireService(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getCritere() {
        return critere;
    }

    public void setCritere(String critere) {
        this.critere = critere;
    }

    public List<String> getListeFamille() {
        return listeFamille;
    }

    public void setListeFamille(List<String> listeFamille) {
        this.listeFamille = listeFamille;
    }

    public List<String> getListeEmplacement() {
        return listeEmplacement;
    }

    public void setListeEmplacement(List<String> listeEmplacement) {
        this.listeEmplacement = listeEmplacement;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String getTotalValeur() {
        return totalValeur;
    }

    public void setTotalValeur(String totalValeur) {
        this.totalValeur = totalValeur;
    }

    public String getNbrSM() {
        return nbrSM;
    }

    public void setNbrSM(String nbrSM) {
        this.nbrSM = nbrSM;
    }

    public String getNbrSA() {
        return nbrSA;
    }

    public void setNbrSA(String nbrSA) {
        this.nbrSA = nbrSA;
    }

    public String getNbrSS() {
        return nbrSS;
    }

    public void setNbrSS(String nbrSS) {
        this.nbrSS = nbrSS;
    }

    public String getTypeFiltreS() {
        return typeFiltreS;
    }

    public void setTypeFiltreS(String typeFiltreS) {
        this.typeFiltreS = typeFiltreS;
    }

    public String getTotalArticle() {
        return totalArticle;
    }

    public void setTotalArticle(String totalArticle) {
        this.totalArticle = totalArticle;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
    
    
}
