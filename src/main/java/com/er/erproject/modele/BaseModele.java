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
public class BaseModele implements Cloneable {
    protected int id;

    public BaseModele() {
    }

    public BaseModele(int id) {
        this.id = id;
    }
    
    public Object clone() throws CloneNotSupportedException {
        Object o = null;
        o = super.clone();
        return o;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
