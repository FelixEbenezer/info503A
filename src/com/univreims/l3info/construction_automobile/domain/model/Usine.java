/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.model;

import java.util.List;

/**
 *
 * @author çpc
 */
public class Usine {
    
    private int idUsine;
    private List<Parking> parkings; 

    public void setIdUsine(int idUsine) {
        this.idUsine = idUsine;
    }

    
    
    public int getIdUsine() {
        return idUsine;
    }

    public List<Parking> getParkings() {
        return parkings;
    }

    public void setParkings(List<Parking> parkings) {
        this.parkings = parkings;
    }

    
    
    
}
