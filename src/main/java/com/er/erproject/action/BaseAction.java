/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.User;
import com.er.erproject.modele.VueInventaire;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class BaseAction extends ActionSupport {

    protected User user;
    protected HibernateDao hbdao;
    protected List<VueInventaire> alertes;
    protected List<String> trace;
    protected int refTrace;
    protected Map session;
//    protected int refSit

    public BaseAction() {
//        trace = new ArrayList<>();
//        trace.add("etatInventaire");
//        trace.add("entree");
//        trace.add("loadSortie");
//        trace.add("historiqueProjet");
//        trace.add("newArticle");
//        trace.add("listeArticle");
//        trace.add("etatFournisseur");
//        trace.add("etatUnite");
//        trace.add("etatFamille");
//        trace.add("loadUser");
//        trace.add("listeUser");
//        trace.add("loadDepartement");
    }
    
    protected boolean checkLevel(int lvl) {
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        if(user.getDepartement().getNiveau()<lvl)return false;
        return true;        
    }
    
    protected boolean sessionCheck() throws Exception {        
        session = ActionContext.getContext().getSession();
        if (session == null || session.isEmpty()) {
            return false;
        }
        user = (User) session.get("user");
        if (user == null) {
            return false;
        }
        boolean val = checkUser();
        alertes = UtilService.listeAlerte(hbdao);
        return val;
    }

    public boolean checkUser() throws Exception {        
        return user != null && user.getDepartement() != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HibernateDao getHbdao() {
        return hbdao;
    }

    public void setHbdao(HibernateDao hbdao) {
        this.hbdao = hbdao;
    }

    public List<VueInventaire> getAlertes() {
        return alertes;
    }

    public void setAlertes(List<VueInventaire> alertes) {
        this.alertes = alertes;
    }

}
