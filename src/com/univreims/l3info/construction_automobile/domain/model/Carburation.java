/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.model;

/**
 *
 * @author çpc
 */
public enum Carburation {
   
    
    ESSENCE("Essence"),
    DIESELE("Diesel"),
    GPL("Gpl"),
    HYBRIDE("hybride");
    
    final String description; 
    
    Carburation(String description) {
    this.description = description;
    }

    public String getDescription() {
        return description;
    }

    
    
   




}