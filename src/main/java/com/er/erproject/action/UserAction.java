/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.action;

import com.er.erproject.modele.Departement;
import com.er.erproject.modele.User;
import com.er.erproject.service.UserService;
import com.opensymphony.xwork2.Action;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvizard
 */
public class UserAction extends BaseAction {

    private List<User> listeUser;
    private UserService userService;    

    private String nom, prenom, cin, matricule, identifiant, pw="", dateNaissance, dateEmbauche, departement = "", critere;
    private Date dateDeNaissance, dateDEmbauche;
    private List<Departement> departements;
    private int id = 0;
    private int type = 0;
    private int mine = 0;

    public String load() {
        try {
            if(!sessionCheck()) return "tolog";
            if (mine != 0 || id != 0) {
                nom = user.getNom();
                prenom = user.getPrenom();
                cin = user.getCin();
                matricule = user.getMatricule();
                identifiant = user.getIdentifiant();
                dateNaissance = user.getDateNaissanceString("yyyy-MM-dd");
                dateEmbauche = user.getDateEmbaucheString("yyyy-MM-dd");
                departement = user.getDepartement().getDesignation();                
            }
            departements = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String save() {
        try {
            if(!sessionCheck()) return "tolog";
            if(mine==0) {
                if (!checkLevel(4)) {
                return "access";
            }
            }
            departements = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            User users = new User();
            users.setNom(nom);
            users.setPrenom(prenom);
            users.setDateNaissance(dateNaissance);
            users.setDateEmbauche(dateEmbauche);
            users.setCin(cin);
            users.setMatricule(matricule);
            users.setIdentifiant(identifiant);
            users.setPw(pw);
            for (Departement d : departements) {
                if (d.getDesignation().compareToIgnoreCase(departement) == 0) {
                    users.setDepartement(d);
                    users.setIdDepartement(d.getId());
                    break;
                }
            }
            if (id != 0) {
                if(pw.compareTo("")==0) {
                    User userTemp = new User(id);
                    hbdao.findById(userTemp);
                    users.setPw(userTemp.getPw());
                    users.setIdentifiant(userTemp.getIdentifiant());
                }
                users.setId(id);
                userService.update(users);
            } else {
                userService.save(users);
            }
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String liste() {
        try {
            if(!sessionCheck()) return "tolog";
            listeUser = userService.findAll();
            departements = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String recherche() {
        try {
            if(!sessionCheck()) return "tolog";
            listeUser = userService.recherche(critere, departement);
            departements = (List<Departement>) (List<?>) hbdao.findAll(new Departement());
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    public String delete() {
        try {
            if(!sessionCheck()) return "tolog";
            if (!checkLevel(4)) {
                return "access";
            }
            User userToDelete = new User(id);
            userService.delete(userToDelete);
            this.id = 0;
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
    }

    //  UTILS
    

    public List<User> getListeUser() {
        return listeUser;
    }

    public void setListeUser(List<User> listeUser) {
        this.listeUser = listeUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Date getDateDEmbauche() {
        return dateDEmbauche;
    }

    public void setDateDEmbauche(Date dateDEmbauche) {
        this.dateDEmbauche = dateDEmbauche;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCritere() {
        return critere;
    }

    public void setCritere(String critere) {
        this.critere = critere;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public int getMine() {
        return mine;
    }

    public void setMine(int mine) {
        this.mine = mine;
    }

}
