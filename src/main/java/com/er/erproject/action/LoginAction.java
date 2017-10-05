/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.service.UserService;
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
    private UserService userService;
    private HibernateDao hbdao;
    private String id;
    private String pw;
    

    @Override
    public String execute() {
        try {
            findUser(id, pw);
            if (!checkUser()) {
                return Action.ERROR;
            }
            session = ActionContext.getContext().getSession();
            session.put("user", user);
        } catch (Exception exc) {
            exc.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String load() {
        try {
            if (sessionCheck()) {
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

    public String logout() {
        try {
            if (sessionCheck()) {
                session = ActionContext.getContext().getSession();
                session.clear();
            }
            return Action.SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    private void findUser(String id, String pw) {
        try {
            this.setUser(userService.login(id, pw));
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

    

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }
    
    
}
