/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.model;

import java.util.Date;

/**
 *
 * @author çpc
 */
public class Voiture {
    
    private int idVoiture; 
    private String niuVoiture; 
    private String couleurVoiture;
    //j utilise momentanement String pour les dates
    private String dateFabricationVoiture;
    private Moteur numeroMoteur;
    private Modele modeleVoiture;
    private Boolean vitreElectrique = false;
    private Boolean radar = false;
    private Boolean gps = false;

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getNiuVoiture() {
        return niuVoiture;
    }

    public void setNiuVoiture(String niuVoiture) {
        this.niuVoiture = niuVoiture;
    }

    public String getCouleurVoiture() {
        return couleurVoiture;
    }

    public void setCouleurVoiture(String couleurVoiture) {
        this.couleurVoiture = couleurVoiture;
    }

    public String getDateFabricationVoiture() {
        return dateFabricationVoiture;
    }

    public void setDateFabricationVoiture(String dateFabricationVoiture) {
        this.dateFabricationVoiture = dateFabricationVoiture;
    }

    public Moteur getNumeroMoteur() {
        return numeroMoteur;
    }

    public void setNumeroMoteur(Moteur numeroMoteur) {
        this.numeroMoteur = numeroMoteur;
    }

    public Modele getModeleVoiture() {
        return modeleVoiture;
    }

    public void setModeleVoiture(Modele modeleVoiture) {
        this.modeleVoiture = modeleVoiture;
    }

    public Boolean getVitreElectrique() {
        return vitreElectrique;
    }

    public void setVitreElectrique(Boolean vitreElectrique) {
        this.vitreElectrique = vitreElectrique;
    }

    public Boolean getRadar() {
        return radar;
    }

    public void setRadar(Boolean radar) {
        this.radar = radar;
    }

    public Boolean getGps() {
        return gps;
    }

    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "La voiture de id " + idVoiture + "de " + niuVoiture + "de couleur "+ couleurVoiture + "fabriqué le " + dateFabricationVoiture + "numero Moteur " + numeroMoteur.getNumMoteur() + "de modele "+modeleVoiture.getDescription() + "avec les options suivantes :" + 
                vitreElectrique + radar + gps + "";        
    }
    
  
    
    
}
