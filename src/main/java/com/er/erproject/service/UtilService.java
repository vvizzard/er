/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.dao.HibernateDao;
import com.er.erproject.modele.Fournisseur;
import com.er.erproject.modele.HistoriqueArticle;
import com.er.erproject.modele.Inventaire;
import com.er.erproject.modele.Unite;
import com.er.erproject.modele.VueInventaire;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vvizard
 */
public class UtilService {

    public static InventaireService inventaireService;

    public static void saveImg(File image, String chemin, String nomFichier) throws IOException {
        File destination = new File(chemin, nomFichier);
        FileUtils.copyFile(image, destination);
    }

    public static List<Inventaire> listeAlerte() throws Exception {
//        List<VueListeArticle> listeTotale = (List<VueListeArticle>)(List<?>)inventaireService.getHbdao().findAll(new VueListeArticle());
        List<Inventaire> valiny = new ArrayList<>();
//        for(Inventaire i : listeTotale) if(i.getMontant()<i.getArticle().getLimite()) valiny.add(i);
        return valiny;
    }

    public static String convertir(String valeurActuel, String uniteSelectionnee, double existant, UniteService uniteService) {
        String valeur = "";
        Unite actuel = null, temp = null;
        try {
            actuel = uniteService.findByName(valeurActuel);
            temp = uniteService.findByName(uniteSelectionnee);
            if (temp.getDifference() == 0) {
                valeur = Double.toString(existant / actuel.getDifference());
            } else {
                valeur = Double.toString(temp.getDifference() * existant / actuel.getDifference());
            }
            if (valeur.contains("Infinity")) {
                valeur = Double.toString(temp.getDifference() * existant);
            }
        } catch (NullPointerException nex) {
            try {
                valeur = Double.toString(temp.getDifference() * existant);
            } catch (NullPointerException nullPoiterException) {
                valeur = Double.toString(existant / actuel.getDifference());
            } catch (Exception exe) {
                throw exe;
            }

        } catch (Exception e) {
            throw e;
        }
        return valeur;
    }

    public static double conversion(Unite aConvertir, double montant, Unite convertirEn) {
        try {
            if (aConvertir.getDifference() == 0) {
                aConvertir.setDifference(null);
            }
            if (convertirEn.getDifference() == 0) {
                convertirEn.setDifference(null);
            }
            if (aConvertir.getDifference() == 0) {
                if (convertirEn.getDifference() != 0) {
                    return montant * convertirEn.getDifferenceD();
                } else {
                    return montant;
                }

            } else if (convertirEn.getDifference() == 0) {
                return montant / aConvertir.getDifference();
            } else {
                return montant / aConvertir.getDifferenceD() * convertirEn.getDifferenceD();
            }
        } catch (NullPointerException nullAConvertirDifference) {
            try {
                return montant * convertirEn.getDifferenceD();
            } catch (NullPointerException nullConvertirEnDifference) {
                try {
                    double val = montant / aConvertir.getDifferenceD();
                    if (Double.isInfinite(val)) {
                        throw new NullPointerException();
                    }
                    return val;
                } catch (NullPointerException allNull) {
                    return montant;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception ex) {
                throw ex;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public static String crypterHashage(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static List<String> find(String nom, int idArticle, HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select f.nom as designation from fournisseur f join associationartf artf on f.id = artf.id_fournisseur where artf.id_article = :bb and f.nom ilike :aa";
            Query query = session.createSQLQuery(qry);
            query.setParameter("aa", nom);
            query.setParameter("bb", idArticle);
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

    public static String findMontantByArticleFournisseur(int idFournisseur, int idArticle, HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select montant from vueartf "
                    + "where id_article = :idArticle "
                    + "and id_fournisseur = :idFournisseur";
            Query query = session.createSQLQuery(qry);
            query.setParameter("idArticle", idArticle);
            query.setParameter("idFournisseur", idFournisseur);
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

    public static boolean checkDoublonFournisseur(Fournisseur f, HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from fournisseur where nom = :idFournisseur";
            Query query = session.createSQLQuery(qry).addEntity(new Fournisseur().getClass());
            query.setParameter("idFournisseur", f.getNom());
            List<Fournisseur> val = query.list();
            Fournisseur fv = val.get(0);
            if (f.getNom().compareTo(fv.getNom()) == 0) {
                return false;
            }
            return true;
        } catch (IndexOutOfBoundsException i) {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<VueInventaire> listeVueInventaire(HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from vueinventaire order by id asc";
            Query query = session.createSQLQuery(qry).addEntity(new VueInventaire().getClass());
            List<VueInventaire> val = query.list();
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<HistoriqueArticle> listeHistoriqueArticle(int idBon, HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from historiquearticle where id_bon = :idBon";
            Query query = session.createSQLQuery(qry).addEntity(new HistoriqueArticle().getClass());
            query.setParameter("idBon", idBon);
            List<HistoriqueArticle> val = query.list();
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<VueInventaire> filtreInventaire(String critere, String famille, String emplacement, String typeFiltreS, HibernateDao hbdao) {
        Session session = null;
        int check = 0;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qryP1 = "select * from vueinventaire "
                    + " where article ilike :critere ";
            String qryP2 = " or code ilike :critere ";
            if (famille.compareTo("Tout") != 0) {
                qryP1 += " and famille = :fm";
                qryP2 += " and famille = :fm";
                check += 1;
            }
            if (emplacement.compareTo("Tout") != 0) {
                qryP1 += " and emplacement = :ep";
                qryP2 += " and emplacement = :ep";
                check += 2;
            }
            if (typeFiltreS.compareTo("sm")==0) {
                qryP1 += " and nombre < sm and nombre > sa";
                qryP2 += " and nombre < sm and nombre > sa";
            }
            if (typeFiltreS.compareTo("sa")==0) {
                qryP1 += " and nombre < sa and nombre > ss";
                qryP2 += " and nombre < sa and nombre > ss";
            }
            if (typeFiltreS.compareTo("ss")==0) {
                qryP1 += " and nombre < ss";
                qryP2 += " and nombre < ss";
            }
            String qry = qryP1 + qryP2;
            Query query = session.createSQLQuery(qry).addEntity(VueInventaire.class);
            query.setParameter("critere", "%" + critere + "%");
            if (check == 1 || check == 3) {
                query.setParameter("fm", famille);
            }
            if (check == 2 || check == 3) {
                query.setParameter("ep", emplacement);
            }
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<HistoriqueArticle> filtreHistoriqueArticle(String debut, String fin, HibernateDao hbdao) throws Exception {
        Session session = null;
        Date dateDebut = null, dateFin = null;
        int check = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select * from historiquearticle "
                    + " where 1<2 ";
            if (debut.compareTo("") != 0) {
                qry += " and date >= :debut";
                check += 1;
                dateDebut = formatter.parse(debut);
            }
            if (fin.compareTo("") != 0) {
                qry += " and date <= :fin";
                check += 2;
                dateFin = formatter.parse(fin);
            }
            Query query = session.createSQLQuery(qry).addEntity(HistoriqueArticle.class);
            if (check == 1 || check == 3) {
                query.setParameter("debut", dateDebut);
            }
            if (check == 2 || check == 3) {
                query.setParameter("fin", dateFin);
            }
            List<HistoriqueArticle> valiny = query.list();
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

    public static List<VueInventaire> listeAlerte(HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = " SELECT i.id, "
                    + "    i.id_article, "
                    + "    a.code, "
                    + "    a.designation AS article, "
                    + "    f.designation AS famille, "
                    + "    a.emplacement, "
                    + "    i.nombre, "
                    + "    i.valeur, "
                    + "    i.id_unite, "
                    + "    u.designation AS unite, "
                    + "    a.limite AS ss, "
                    + "    a.sm, "
                    + "    a.sa "
                    + "   FROM inventaire i "
                    + "     JOIN article a ON a.id = i.id_article "
                    + "     JOIN unite u ON u.id = i.id_unite "
                    + "     JOIN famille f ON f.id = a.id_famille "
                    + "   WHERE a.limite >= i.nombre";
            Query query = session.createSQLQuery(qry).addEntity(VueInventaire.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<String> listeString(String table, String critere, HibernateDao hbdao) {
        Session session = null;
        try {
            session = hbdao.getSessionFactory().openSession();
            String qry = "select distinct " + critere + " from " + table;
            Query query = session.createSQLQuery(qry);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static InventaireService getInventaireService() {
        return inventaireService;
    }

    public static void setInventaireService(InventaireService inventaireService) {
        UtilService.inventaireService = inventaireService;
    }
}
