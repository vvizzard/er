/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.AssociationArticleBon;
import com.er.erproject.modele.Unite;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vvizard
 */
public class AssociationArticleBonService extends AssociationService {

    private HibernateDao hbdao;

    public List<AssociationArticleBon> findAll(AssociationArticleBon b) throws Exception {
        List<AssociationArticleBon> valiny = (List<AssociationArticleBon>) (List<?>) super.findAll(b);
        for (AssociationArticleBon ba : valiny) {
            completeAssociationArticleBon(ba);
        }
        return valiny;
    }

    public void find(AssociationArticleBon b) throws Exception {
        super.find(b);
        completeAssociationArticleBon(b);
    }

    private void completeAssociationArticleBon(AssociationArticleBon ba) throws Exception {
        Unite b1 = new Unite();
        b1.setId(ba.getIdUnite());
        hbdao.findById(b1);
    }

    public List<AssociationArticleBon> getListAABDateDesc(int idBon) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select artb.* from bon b "
                    + "join associationarticlebon artb "
                    + "on b.id = artb.id_bon "
                    + "where id_article = :idBon "
                    + "and nbrdisponible != 0 "
                    + "and montant > 0 "
                    + "order by b.date desc ";
            Query query = session.createSQLQuery(qry).addEntity(AssociationArticleBon.class);
            query.setParameter("idBon", idBon);
            List<AssociationArticleBon> val = query.list();
            return val;
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(session != null) session.close();
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
