/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.Inventaire;
import com.er.erproject.modele.Unite;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author vvizard
 */
public class UtilService {
    public static InventaireService inventaireService;
    
    public static void saveImg(File image, String chemin, String nomFichier) throws IOException {
        File destination = new File(chemin, nomFichier);
        FileUtils.copyFile(image, destination);
    }
    
    public static List<Inventaire> listeAlerte() throws Exception {        
        List<Inventaire> listeTotale = inventaireService.findAll();        
        List<Inventaire> valiny = new ArrayList<>();
        for(Inventaire i : listeTotale) if(i.getMontant()<i.getArticle().getLimite()) valiny.add(i);
        return valiny;
    }
    
    public static String convertir(String valeurActuel, String uniteSelectionnee, double existant, UniteService uniteService) {
        String valeur = "";
        Unite actuel = null, temp = null;
        try {            
            actuel = uniteService.findByName(valeurActuel);
            temp = uniteService.findByName(uniteSelectionnee);
            valeur = Double.toString(temp.getDifference()*existant/actuel.getDifference());
        } catch (NullPointerException nex) {
            try {
                valeur = Double.toString(temp.getDifference()*existant);
            } catch(NullPointerException nullPoiterException) {
                valeur = Double.toString(existant/actuel.getDifference());
            } catch (Exception exe) {
                throw exe;
            }
            
        } catch (Exception e) {
            throw e;
        }     
        return valeur;
    }
    
    public static double conversion(Unite aConvertir, double montant, Unite convertirEn) {        
        try {
            return montant/aConvertir.getDifference()*convertirEn.getDifference();
        } catch(NullPointerException nullAConvertirDifference) {
            try {
                return montant*convertirEn.getDifference();
            } catch(NullPointerException nullConvertirEnDifference) {
                try {
                    return montant/aConvertir.getDifference();
                } catch(NullPointerException allNull) {
                    return montant;
                } catch(Exception e) {
                    throw e;
                }                
            } catch(Exception ex) {
                throw ex;
            }            
        } catch(Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public static InventaireService getInventaireService() {
        return inventaireService;
    }

    public static void setInventaireService(InventaireService inventaireService) {
        UtilService.inventaireService = inventaireService;
    }        
}
