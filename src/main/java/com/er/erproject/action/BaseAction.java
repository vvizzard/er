/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Inventaire;
import com.er.erproject.modele.User;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author vvizard
 */
public class BaseAction extends ActionSupport {
    
    protected User user;
    protected HibernateDao hbdao;
    protected List<Inventaire> alertes;
    
    public boolean checkUser() throws Exception {
        alertes = UtilService.listeAlerte();
        return user != null && user.getDepartement()!=null;        
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

    public List<Inventaire> getAlertes() {
        return alertes;
    }

    public void setAlertes(List<Inventaire> alertes) {
        this.alertes = alertes;
    }
        
    
}
