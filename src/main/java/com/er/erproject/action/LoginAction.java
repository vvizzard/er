/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Departement;
import com.er.erproject.modele.User;
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
        return Action.SUCCESS;
    }
    
    private void findUser(String id, String pw) {        
        try {
            Departement temp = new Departement();
            temp =(Departement)hbdao.findAll(temp).get(0);
            User tempUser = new User();
            tempUser.setDepartement(temp);
            this.setUser(tempUser);
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
}
