/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.BaseAssociation;
import com.er.erproject.modele.BaseModele;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vvizard
 */
public class AssociationService extends BaseAssociation {

    protected HibernateDao hbdao;

    public void save(BaseAssociation b) throws Exception {
        hbdao.save(b);
    }

    public void update(BaseAssociation b) throws Exception {
        hbdao.update(b);
    }

    public void delete(BaseAssociation b) throws Exception {
        hbdao.delete(b);
    }

    public List<BaseAssociation> findAll(BaseAssociation b) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(b.getClass());
            List<BaseAssociation> valiny = criteria.list();
            for (BaseAssociation ba : valiny) {
                Hibernate.initialize(ba.getBm1());
                Hibernate.initialize(ba.getBm2());
            }
//            for (BaseAssociation ba : valiny) {
//                completeBaseAssociation(ba);
//            }
            return valiny;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void find(BaseAssociation b) throws Exception {
        hbdao.findById(b);
        completeBaseAssociation(b);
    }

    protected void completeBaseAssociation(BaseAssociation ba) throws Exception {
        BaseModele b1 = (BaseModele) ba.getBm1().clone();
        BaseModele b2 = (BaseModele) ba.getBm2().clone();
        b1.setId(ba.getId1());
        hbdao.findById(b1);
        b2.setId(ba.getId2());
        hbdao.findById(b2);
        ba.setBm1(b1);
        ba.setBm2(b2);
    }

    public List<BaseModele> findBm(BaseAssociation ass, int idCondition, String attributCondition, String attributGoal) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String sql = "select but from " + ass.getClass().getSimpleName() + " a join a." + attributCondition + " but join a." + attributGoal + " condition where condition.id = :id";
            Query query = session.createQuery(sql);
            query.setParameter("id", idCondition);
            List<BaseModele> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<BaseAssociation> findAll(BaseAssociation ass, String condition, int idCondition) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String sql = "select a from " + ass.getClass().getSimpleName() + " a join a." + condition + " condition where condition.id = :id";
            Query query = session.createQuery(sql);
            query.setParameter("id", idCondition);
            List<BaseAssociation> list = query.list();
            for (BaseAssociation ba : list) {
                Hibernate.initialize(ba.getBm1());
                Hibernate.initialize(ba.getBm2());
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public HibernateDao getHbdao() {
        return hbdao;
    }

    public void setHbdao(HibernateDao hbdao) {
        this.hbdao = hbdao;
    }
}

//    public List<Employe> rechercher(String n, String pn, String d1, String d2, int page, int taille, int order) throws Exception {
//        Session session = null;
//        List<Employe> list = null;
//        try {
//            session = hbdao.getSessionFactory().openSession();
//            Criteria criteria = session.createCriteria(Employe.class, "employe");
//
//            if (n.compareTo("") != 0) {
//                criteria.add(Restrictions.ilike("nom", "%" + n + "%"));
//            }
//            if (pn.compareTo("") != 0) {
//                criteria.add(Restrictions.ilike("prenom", "%" + pn + "%"));
//            }
//            if (d1.compareTo("") != 0) {
//                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
//                Date minDate = formatter.parse(d1);
//                criteria.add(Restrictions.lt("dateNaissance", minDate));
//            }
//            if (d2.compareTo("") != 0) {
//                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
//                Date minDate = formatter.parse(d2);
//                criteria.add(Restrictions.ge("dateNaissance", minDate));
//            }
//            if(order == 1) {
//                criteria.addOrder(Order.asc("nom"));
//            }
//            if(order == 2) {
//                criteria.addOrder(Order.asc("prenom"));
//            }
//            if(order == 3) {
//                criteria.addOrder(Order.asc("dateNaissance"));
//            }
//            if(page!=0) {
//                criteria.setFirstResult((page-1)*taille);
//                criteria.setMaxResults(taille);
//            }
//            
//            list = criteria.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return list;
//    }
