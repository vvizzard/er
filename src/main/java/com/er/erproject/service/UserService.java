/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author vvizard
 */
public class UserService {

    private HibernateDao hbdao;

    public List<User> findAll() throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new User().getClass());
            List<User> valiny = criteria.list();
            for (User ba : valiny) {                
                if(ba.getDepartement()!=null) Hibernate.initialize(ba.getDepartement());                
            }
            return valiny;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }        

    public void find(User obj) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            session.load(obj, obj.getId());
            Hibernate.initialize(obj.getDepartement());
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void save(User obj) throws Exception {        
        hbdao.save(obj);        
    }
    
    public void update(User obj) throws Exception {
        hbdao.update(obj);
    }
    
    public void delete(User obj) throws Exception {
        hbdao.delete(obj);
    }

    public HibernateDao getHbdao() {
        return hbdao;
    }

    public void setHbdao(HibernateDao hbdao) {
        this.hbdao = hbdao;
    }        
}
