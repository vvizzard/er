/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Departement;
import com.er.erproject.modele.User;
import com.er.erproject.service.UtilService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvizard
 */
public class LoginAction extends BaseAction {
    private HibernateDao hbdao;
    private String id;
    private String pw;
    private Map session;
    
    @Override
    public String execute() {
        try {                      
            findUser(id, pw);
            if(!checkUser()) return Action.ERROR;               
            Map session = ActionContext.getContext().getSession();
            session.put("user", user);
//            List<Inventaire> alerte = UtilService.listeAlerte();
//            session.put("alerte", alerte);
        } catch(Exception exc) {
            exc.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String load() {
        try {               
            if(sessionCheck()) {
                return "noLog";
            } else {
                return Action.SUCCESS;
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return Action.ERROR;
        }        
    }
    
    private void findUser(String id, String pw) {        
        try {
            User tempUser = new User(1);
            hbdao.findById(tempUser);
            Departement temp = new Departement(tempUser.getIdDepartement());
            hbdao.findById(temp);
            tempUser.setDepartement(temp);
            this.setUser(tempUser);
//            hbdao.Soustraction();
//            Departement t = new Departement(1);
//            hbdao.findById(t);
//            User tempUser = new User(1);
//            tempUser.setNom("test");
//            tempUser.setDepartement(t);
        } catch (Exception ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HibernateDao getHbdao() {
        return hbdao;
    }

    @Override
    public void setHbdao(HibernateDao hbdao) {
        this.hbdao = hbdao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }      

    private boolean sessionCheck() throws Exception {
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
}
