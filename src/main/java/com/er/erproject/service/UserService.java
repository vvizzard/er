/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Departement;
import com.er.erproject.modele.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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
    
    public List<User> recherche(String critere, String departement) {
        Session session = null;
        int check = 0;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qryP1 = "select * from users u join departement d on u.id_departement = d.id"
                    + " where nomuser ilike :critere ";
            String qryP2 = " or prenomuser ilike :critere ";                                
            if (departement.compareTo("Departement") != 0) {
                qryP1 += " and d.nom = :ep";
                qryP2 += " and d.nom = :ep";
                check+=2;
            }
            String qry = qryP1+qryP2;
            Query query = session.createSQLQuery(qry).addEntity(User.class);
            query.setParameter("critere", "%" + critere + "%");            
            if(check == 2)query.setParameter("ep", departement);
            List<User> valiny = query.list();
            for (User ba : valiny) {                
                if(ba.getDepartement()!=null) Hibernate.initialize(ba.getDepartement());                
            }
            return valiny;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public User login(String id, String pw) throws Exception {
        Session session = null;        
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from users "
                    + " where identifiant = :id "
                    + " and pw = :pw";                        
            Query query = session.createSQLQuery(qry).addEntity(User.class);
            query.setParameter("id", id);
            query.setParameter("pw", UtilService.crypterHashage(pw));
            List<User> valiny = query.list();
            for (User ba : valiny) {                
                if(ba.getDepartement()!=null) {
                    Departement dt = new Departement(ba.getIdDepartement());
                    hbdao.findById(dt);
                    ba.setDepartement(dt);
                }                
            }
            return valiny.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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
        obj.setPw(UtilService.crypterHashage(obj.getPw()));
        hbdao.save(obj);        
    }
    
    public void update(User obj) throws Exception {
        obj.setPw(UtilService.crypterHashage(obj.getPw()));
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
