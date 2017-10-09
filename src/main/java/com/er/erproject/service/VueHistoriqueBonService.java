/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.VueHistoriqueBon;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vvizard
 */
public class VueHistoriqueBonService extends BaseService {

    public List<VueHistoriqueBon> findAll() throws Exception {
        return (List<VueHistoriqueBon>) (List<?>) hbdao.findAll(new VueHistoriqueBon());
    }

    public void save(VueHistoriqueBon toSave) throws Exception {
        hbdao.save(toSave);
    }

    public void find(VueHistoriqueBon toFind) throws Exception {
        hbdao.findById(toFind);
    }

    public List<VueHistoriqueBon> find(Map criteres) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(VueHistoriqueBon.class, "employe");
            
            try {
                String temp = (String)criteres.get("refBon");
                Integer critere = Integer.parseInt(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.idEq(critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }
            
            try {
                String critere = (String) criteres.get("demandeur");
                if (critere.compareTo("") != 0) {
                    String[] demandeur = critere.split(" ");
                    if (demandeur.length == 2) {
                        criteria.add(Restrictions.ilike("nom", "%" + demandeur[0] + "%"));
                        criteria.add(Restrictions.ilike("prenom", "%" + demandeur[1] + "%"));
                    } else {
                        criteria.add(Restrictions.or(Restrictions.ilike("nom", "%" + demandeur[0] + "%"), Restrictions.ilike("prenom", "%" + demandeur[0] + "%")));
                    }
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("projet");
                if (critere.compareTo("") != 0) {
                    criteria.add(Restrictions.ilike("projet", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("type");
                if (critere.compareTo("") != 0 && critere.compareTo("Tout") != 0) {
                    criteria.add(Restrictions.ilike("type", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("article");
                if (critere.compareTo("") != 0) {
                    criteria.add(Restrictions.ilike("article", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("facture");
                if (critere.compareTo("") != 0) {
                    criteria.add(Restrictions.ilike("facture", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("debut");
                if (critere.compareTo("") != 0) {
                    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                    Date minDate = formatter.parse(critere);
                    criteria.add(Restrictions.ge("date", minDate));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("fin");
                if (critere.compareTo("") != 0) {
                    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                    Date minDate = formatter.parse(critere);
                    criteria.add(Restrictions.le("date", minDate));
                }
            } catch (NullPointerException e) {
            }

            try {
                String temp = criteres.get("nbrMin").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.ge("nombre", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }

            try {
                String temp = criteres.get("nbrMax").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.le("nombre", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }

            try {
                String temp = criteres.get("valeurMin").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.ge("valeur", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }

            try {
                String temp = criteres.get("valeurMax").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.le("valeur", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }            

            criteria.addOrder(Order.desc("date"));
            criteria.setFirstResult((Integer.parseInt(criteres.get("page").toString())-1)*10);
            criteria.setMaxResults(10);            
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public long rowNumber(Map criteres) throws Exception {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(VueHistoriqueBon.class, "employe");
            
            try {
                String temp = (String)criteres.get("refBon");
                Integer critere = Integer.parseInt(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.idEq(critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }
            
            try {
                String critere = (String) criteres.get("demandeur");
                if (critere.compareTo("") != 0) {
                    String[] demandeur = critere.split(" ");
                    if (demandeur.length == 2) {
                        criteria.add(Restrictions.ilike("nom", "%" + demandeur[0] + "%"));
                        criteria.add(Restrictions.ilike("prenom", "%" + demandeur[1] + "%"));
                    } else {
                        criteria.add(Restrictions.or(Restrictions.ilike("nom", "%" + demandeur[0] + "%"), Restrictions.ilike("prenom", "%" + demandeur[0] + "%")));
                    }
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("projet");
                if (critere.compareTo("") != 0) {
                    criteria.add(Restrictions.ilike("projet", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("type");
                if (critere.compareTo("") != 0 && critere.compareTo("Tout") != 0) {
                    criteria.add(Restrictions.ilike("type", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("article");
                if (critere.compareTo("") != 0) {
                    criteria.add(Restrictions.ilike("article", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("facture");
                if (critere.compareTo("") != 0) {
                    criteria.add(Restrictions.ilike("facture", "%" + critere + "%"));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("debut");
                if (critere.compareTo("") != 0) {
                    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                    Date minDate = formatter.parse(critere);
                    criteria.add(Restrictions.ge("date", minDate));
                }
            } catch (NullPointerException e) {
            }

            try {
                String critere = (String) criteres.get("fin");
                if (critere.compareTo("") != 0) {
                    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
                    Date minDate = formatter.parse(critere);
                    criteria.add(Restrictions.le("date", minDate));
                }
            } catch (NullPointerException e) {
            }

            try {
                String temp = criteres.get("nbrMin").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.ge("nombre", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }

            try {
                String temp = criteres.get("nbrMax").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.le("nombre", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }

            try {
                String temp = criteres.get("valeurMin").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.ge("valeur", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }

            try {
                String temp = criteres.get("valeurMax").toString();
                Double critere = Double.parseDouble(temp);
                if (critere != 0) {
                    criteria.add(Restrictions.le("valeur", critere));
                }
            } catch (NullPointerException | NumberFormatException e) {
            }            
            
            return (long)criteria.setProjection(Projections.rowCount()).uniqueResult();            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
