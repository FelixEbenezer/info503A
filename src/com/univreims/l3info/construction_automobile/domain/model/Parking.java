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
public class Parking {
    
    private int idParking;
    private List<PlaceParking> placesParking;
    private List<Voiture> voitures; 

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public List<PlaceParking> getPlacesParking() {
        return placesParking;
    }

    public void setPlacesParking(List<PlaceParking> placesParking) {
        this.placesParking = placesParking;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    
    
    
}
