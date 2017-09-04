/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.User;
import com.er.erproject.modele.VueHistoriqueProjet;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
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
    private String debut;
    private String fin;

    public String load() {
        try {
            Map session = ActionContext.getContext().getSession();
            user = (User)session.get("user");
            if (!checkUser()) {
                return "tolog";
            }            
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
    
    
}
