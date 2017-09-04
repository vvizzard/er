/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vvizard
 */
public class VueHistoriqueProjet extends BaseModele{
    private String designation;
    private Date date;

    public VueHistoriqueProjet() {
    }

    public VueHistoriqueProjet(int id) {
        super(id);
    }
    
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDate() {
        return date;
    }
    
    public String getDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.date = formatter.parse(date);
    }
    
    
}
