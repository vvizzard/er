/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Article;
import com.er.erproject.modele.ArticleBon;
import com.er.erproject.modele.Inventaire;
import com.er.erproject.modele.Unite;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vvizard
 */
public class InventaireService extends AssociationService {            
    private UniteService uniteService;

    public InventaireService() {
        super.setTable("inventaire"); 
    }
    
    public String findValeurTotal() {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select sum(valeur) as total from vueinventaire";
            Query query = session.createSQLQuery(qry);
            List<Object> val = query.list();            
            return val.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public String findSM() {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select count(*) as total from vueinventaire where nombre < sm and nombre > sa";
            Query query = session.createSQLQuery(qry);
            List<Object> val = query.list();            
            return val.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public String findSA() {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select count(*) as total from vueinventaire where nombre < sa and nombre > ss";
            Query query = session.createSQLQuery(qry);
            List<Object> val = query.list();            
            return val.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public String findSS() {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select count(*) as total from vueinventaire where nombre < ss";
            Query query = session.createSQLQuery(qry);
            List<Object> val = query.list();            
            return val.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public String findTotal() {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select count(*) as total from vueinventaire";
            Query query = session.createSQLQuery(qry);
            List<Object> val = query.list();            
            return val.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
        
    public Inventaire findByArticle(Article a) throws Exception {        
        Inventaire valiny = (Inventaire) super.findAll(new Inventaire(), "article", a.getId()).get(0); 
        super.completeBaseAssociation(valiny);
        return valiny;
    }
    
    public List<Inventaire> findAll(Article a) throws Exception {
        List<Inventaire> valiny = (List<Inventaire>)(List<?>) super.findAll(new Inventaire(), "article", a.getId());    
        for(Inventaire i : valiny) super.completeBaseAssociation(i);
        return valiny;
    }
    
    public void save(Inventaire a) throws Exception {
        hbdao.save(a);
    }
    
    public void update(Inventaire a) throws Exception {
        hbdao.update(a);
    }       
    
    public void updateInventaireForArticle(ArticleBon a) throws Exception {
        Inventaire temp = findByArticle(a);
        double nombreDansLaBase = temp.getMontant();
        double aAjouter = a.getNombre();
        int idR = 0;
        Unite uniteTemp = new Unite();
        uniteTemp.setDifference(null);        
        try {
            idR = a.getUnite().getIdReference();
            if(idR==0)a.getUnite().setReference(null);
            uniteTemp = a.getUnite().getReference();
        } catch(NullPointerException npe) {
            a.getUnite().setIdReference(0);
        }
        if(a.getUnite().getIdReference()!=0) {
            Unite ute = new Unite(a.getUnite().getIdReference());
            hbdao.findById(ute);
            a.getUnite().setReference(ute);
        } else {
            a.getUnite().setReference(null);
        }
        aAjouter = UtilService.conversion(a.getUnite(), aAjouter, uniteTemp);
        nombreDansLaBase += aAjouter;
        temp.setMontant(nombreDansLaBase);
        if(a.getPt()>0 || a.getPt()<0) temp.setValeur(a.getPt()+temp.getValeur());
        else temp.setValeur(a.getPrixTotal()+temp.getValeur());
        update(temp);
    }

    public List<Inventaire> findAll() throws Exception {
        List<Inventaire> valiny = (List<Inventaire>)(List<?>)super.findAll(new Inventaire());        
        return valiny;
    }
    
    public List<Inventaire> findAll(Inventaire b) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Inventaire.class);
            List<Inventaire> valiny = criteria.list();
            for (Inventaire ba : valiny) {
                Hibernate.initialize(ba.getBm1());
                ba.setArticle((Article)ba.getBm1());
                Hibernate.initialize(ba.getBm2());
                ba.setUnite((Unite)ba.getBm2());
            }
            
            return valiny;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public UniteService getUniteService() {
        return uniteService;
    }

    public void setUniteService(UniteService uniteService) {
        this.uniteService = uniteService;
    }
    
}
