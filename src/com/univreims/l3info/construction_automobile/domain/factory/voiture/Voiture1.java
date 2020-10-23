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
public class Voiture1 extends Voiture{
    
    
    final Modele modele1 = new Modele(1, "Twingo");
    final Moteur moteur1 = new Moteur(1, 120.50, Carburation.ESSENCE);
    final Voiture voiture1 = new Voiture (1, "hhdg34", "Bleu", "10/2/2020", moteur1, modele1,
    false, false, false);
    
    @Override
    public Voiture ajouterVoiture() {
        
        return voiture1;     
    }    
         
}
