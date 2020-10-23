/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.factory.voiture;

import com.univreims.l3info.construction_automobile.domain.model.Carburation;
import com.univreims.l3info.construction_automobile.domain.model.Modele;
import com.univreims.l3info.construction_automobile.domain.model.Moteur;
import com.univreims.l3info.construction_automobile.domain.model.Voiture;

/**
 *
 * @author çpc
 */
public class Voiture2 extends Voiture{
    
    
    final Modele modele2 = new Modele(2, "Peugeot");
    final Moteur moteur2 = new Moteur(2, 120.50, Carburation.DIESELE);
    final Voiture voiture2 = new Voiture (2, "hhdg333", "Jaune", "10/2/2020",  moteur2, modele2,
    true, false, true);
    
    @Override
    public Voiture ajouterVoiture() {
        
        return voiture2;     
    }    
         
}
