/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.Article;
import com.er.erproject.modele.Fournisseur;
import com.er.erproject.modele.VueArticleFournisseur;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author vvizard
 */
public class VueArticleFournisseurService extends BaseService {     
    
    public List<VueArticleFournisseur> findAll(Article a) {        
        Session session = null;
        List<VueArticleFournisseur> list = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(VueArticleFournisseur.class);            
            criteria.add(Restrictions.eq("idArticle", a.getId()));                                    
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
    
    public List<VueArticleFournisseur> findAll(Fournisseur a) {        
        Session session = null;
        List<VueArticleFournisseur> list = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(VueArticleFournisseur.class);            
            criteria.add(Restrictions.eq("id_fournisseur", a.getId()));                                    
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
}
