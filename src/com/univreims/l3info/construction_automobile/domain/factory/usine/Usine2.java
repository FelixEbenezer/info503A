/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.factory.usine;

import com.univreims.l3info.construction_automobile.domain.factory.voiture.*;
import com.univreims.l3info.construction_automobile.domain.model.Parking;
import com.univreims.l3info.construction_automobile.domain.model.PlaceParking;
import com.univreims.l3info.construction_automobile.domain.model.Usine;
import com.univreims.l3info.construction_automobile.domain.model.Voiture;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author çpc
 */
public class Usine2 extends Usine{
    
              
    
    @Override
    public Usine creerUsine() {
       
       VoitureFactory voitureFactory = new VoitureFactory();
       Voiture voiture1 = voitureFactory.getVoiture(1); 
     //  Voiture voiture2 = voitureFactory.getVoiture(2);
       
       
       final PlaceParking place1 = new PlaceParking(1, "A", voiture1.ajouterVoiture());
     //  final PlaceParking place2 = new PlaceParking(2, "B", voiture2);
       
       final List<PlaceParking> placesParking = new ArrayList<>();
       
       placesParking.add(place1);
     //  placesParking.add(place2);
       
       
       final Parking parking1 = new Parking(1, placesParking);
    //   final Parking parking2 = new Parking(2, placesParking);
       
       final List<Parking> parkings = new ArrayList<>();
       parkings.add(parking1);
     //  parkings.add(parking2);
       
       final Usine usine2 = new Usine(1,parkings );

        return usine2;     
    }    
         
}
