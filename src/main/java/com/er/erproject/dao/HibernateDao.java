package com.er.erproject.dao;

import com.er.erproject.modele.BaseModele;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Created by wizard.
 */
public class HibernateDao {

    private SessionFactory sessionFactory;

    public void save(BaseModele obj) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(obj);
            tr.commit();
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(BaseModele obj) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(obj);
            tr.commit();
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(BaseModele obj) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(obj);
            tr.commit();
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void findById(BaseModele obj) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.load(obj, obj.getId());
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public long count(BaseModele obj) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<BaseModele> findAll(BaseModele obj) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            List<BaseModele> valiny = criteria.list();
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

    public List<BaseModele> findAllStringCriteria(BaseModele obj, List<String[]> critere) throws Exception {
        Session session = null;
        List<BaseModele> list = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            for (String[] s : critere) {
                criteria.add(Restrictions.ilike(s[0], s[1]));
            }
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
    
    public List<BaseModele> findAllEqCriteria(BaseModele obj, List<String[]> critere) throws Exception {
        Session session = null;
        List<BaseModele> list = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            for (String[] s : critere) {
                criteria.add(Restrictions.eqOrIsNull(s[0], s[1]));
            }
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

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
