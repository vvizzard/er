/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

/**
 *
 * @author vvizard
 */
public class Departement extends BaseModele {
    private String designation;
    private int niveau;

    public Departement() {
    }
        
    public Departement(int id) {
        super(id);
    }

    public Departement(String designation) {
        this.designation = designation;
    }    

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }    

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
       
}
