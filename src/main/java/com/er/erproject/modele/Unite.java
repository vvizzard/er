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
public class Unite extends BaseModele {
    private String designation;
    private int defaut;
    private Integer idReference = 0;
    private Unite reference;
    private Double difference = 0.0;

    public Unite() {
    }
    
    public Unite(int id) {
        super(id);
    }
    
    public Unite(int id, String designation) {
        super(id);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getDefaut() {
        return defaut;
    }

    public void setDefaut(int defaut) {
        this.defaut = defaut;
    }

    public int getIdReference() {
        return idReference;
    }

    public void setIdReference(Integer idReference) {
        this.idReference = idReference;
    }        

    public Unite getReference() {
        return reference;
    }

    public void setReference(Unite reference) {
        this.reference = reference;
    }            

    public double getDifference() {
        return difference;
    }
    
    public Double getDifferenceD() {
        return difference;
    }

    public void setDifference(Double difference) {
        if(difference!=null)this.difference = difference;
    }
    
    
}
