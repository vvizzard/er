/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Unite;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vvizard
 */
public class UniteService {

    private HibernateDao hbdao;

    public List<Unite> findAll() throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new Unite().getClass());
            List<Unite> valiny = criteria.list();
            for (Unite ba : valiny) {
                if (ba.getReference() != null) {
                    Hibernate.initialize(ba.getReference());
                }
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
            criteria.add(Restrictions.ilike("designation", "%" + name + "%"));
            list = criteria.list();
            Unite valiny = (Unite) list.get(0);
            Hibernate.initialize(valiny.getReference());
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

    public List<Unite> getEquivalent(Unite uniteDefaut) {
        Session session = null;
        List<Unite> list = null;
        if (uniteDefaut.getDesignation().compareTo("none") == 0) {
            return new ArrayList<>();
        }
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(new Unite().getClass());
            criteria.add(Restrictions.sqlRestriction("this_.reference = " + uniteDefaut.getId()));
            list = criteria.list();
            for (Unite u : list) {
                u.setReference(uniteDefaut);
            }
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

    public List<Unite> getEquivalent(String uniteDefaut) {
        Session session = null;
        List<Unite> list = null;
        if (uniteDefaut.compareTo("none") == 0) {
            return new ArrayList<>();
        }
        try {
            session = hbdao.getSessionFactory().openSession();
//            Query query = session.createSQLQuery("select id from unite u where u.designation = :des").addEntity(Unite.class);
//            query.setParameter("des", uniteDefaut);
            Criteria tempC = session.createCriteria(new Unite().getClass());
            tempC.add(Restrictions.ilike("designation", uniteDefaut));
            List<Unite> tempU = tempC.list();
            Criteria criteria = session.createCriteria(new Unite().getClass());
            criteria.add(Restrictions.sqlRestriction("this_.reference = " + tempU.get(0).getId()));
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

    public void findCompletLent(Unite obj) throws Exception {
        Session session = null;
        try {
            hbdao.findById(obj);
//            session.load(obj, obj.getId());
            if (obj.getIdReference() != 0) {
                Unite ref = new Unite(obj.getIdReference());
                hbdao.findById(ref);
                obj.setReference(ref);
            }
        } catch (NullPointerException npe) {
            obj.setIdReference(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void save(Unite obj) throws Exception {
        Unite db = null;
        try {
            db = findByName(obj.getDesignation());
        } catch (IndexOutOfBoundsException i) {
            try {
                double temp = obj.getDifference();
                hbdao.save(obj);
            } catch (NullPointerException npe) {
                obj.setDifference(0.0);
                if (db == null) {
                    hbdao.save(obj);
                }
            }
        }

    }

    public List<String> findUniteStringByIdArticle(int idArticle) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select unite.designation from unite "
                    + "where unite.id = ("
                    + "	select u.id as idunite from unite u "
                    + "	left join article a "
                    + "	on a.id_unite = u.id "
                    + "	where a.id = :idArticle"
                    + "	) "
                    + "or unite.reference = ("
                    + "	select u.id as idunite from unite u "
                    + "	left join article a "
                    + "	on a.id_unite = u.id "
                    + "	where a.id = :idArticle)";
            Query query = session.createSQLQuery(qry);
            query.setParameter("idArticle", idArticle);
            List<Object> val = query.list();
            List<String> farany = new ArrayList<>();
            for (Object o : val) {
                farany.add(o.toString());
            }
            return farany;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<List<String>> findAllAffichage() {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select u.id, u.designation, u.defaut, e.designation as reference, u.difference from unite u "
                    + "join unite e on e.id = u.reference";
            Query query = session.createSQLQuery(qry);
            List<Object> val = query.list();
            List<List<String>> farany = new ArrayList<>();
            for (Object o : val) {
                List<String> temp = new ArrayList<>();
                for (int i = 0; i < ((List) o).size(); i++) {
                    temp.add(o.toString());
                }
                farany.add(temp);
            }
            return farany;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
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
