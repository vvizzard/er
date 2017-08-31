/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Unite;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vvizard
 */
public class EmplacementService {

    private HibernateDao hbdao;

    public List<Unite> findAll() throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new Unite().getClass());
            List<Unite> valiny = criteria.list();
            for (Unite ba : valiny) {                
                if(ba.getReference()!=null) Hibernate.initialize(ba.getReference());                
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
    
    public Unite findByName(String name) {
        Session session = null;
        List<Unite> list = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new Unite().getClass());
            criteria.add(Restrictions.like("designation", name));
            list = criteria.list();
            return (Unite)list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public List<Unite> getEquivalent(Unite uniteDefaut) {
        Session session = null;
        List<Unite> list = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new Unite().getClass());            
            criteria.add(Restrictions.sqlRestriction("this_.reference = "+uniteDefaut.getId()));
            list = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
    
    public List<Unite> findDefauts() throws Exception {
        Session session = null;
        List<Unite> list = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new Unite().getClass());            
            criteria.add(Restrictions.sqlRestriction("this_.defaut != -1"));            
            list = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public void find(Unite obj) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            session.load(obj, obj.getId());
            Hibernate.initialize(obj.getReference());
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void save(Unite obj) throws Exception {
        try {
            double temp = obj.getDifference();
            hbdao.save(obj);
        } catch(NullPointerException npe) {
            obj.setDifference(0.0);
            hbdao.save(obj);
        }        
    }
    
    public void update(Unite obj) throws Exception {
        hbdao.update(obj);
    }
    
    public void delete(Unite obj) throws Exception {
        hbdao.delete(obj);
    }

    public HibernateDao getHbdao() {
        return hbdao;
    }

    public void setHbdao(HibernateDao hbdao) {
        this.hbdao = hbdao;
    }
    
    
}
