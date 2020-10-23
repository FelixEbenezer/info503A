/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.lire;

import com.univreims.l3info.construction_automobile.domain.model.Parking;
import com.univreims.l3info.construction_automobile.domain.model.Usine;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author çpc
 */
public class UsineLecture {

   public static void main(String[] args ) {
      
        
        // Vérification des arguments
        if(args.length != 1) {
            System.err.println("Erreur : vous devez spécifier le nom du fichier JSON.");
            System.err.println();            
            System.err.println("Usage : java LecteurJSON fichier.json");
            System.err.println("\toù 'fichier.json' est le nom du fichier à ouvrir");
            System.exit(0);
        }
        
        // Récupération de la chaîne JSON depuis le fichier
        String json = "";
        try {
          byte[] contenu = Files.readAllBytes(Paths.get(args[0]));
          json = new String(contenu);        
        } catch(IOException e) {
            System.err.println("Erreur lors de la lecture du fichier '" + args[0] + "'");
            System.exit(0);
        } 
        
        // Création d'un objet JSON
        JSONObject objet = new JSONObject(json);
        System.out.println("Contenu JSON : ");
        System.out.println(json);

        // Affichage à l'écran
       
       JSONArray tableau = objet.getJSONArray("contacts");
       List<Parking> parkings = new ArrayList<>();
   
    //   List<PlaceParking> places = new ArrayList<>(); 
       
       /*    parkings.stream()
               .map(c -> c.getPlacesParking().stream()
                                             .map(s -> s.getVoitures())
                                            // .collect(collectors.toList())
                                            // .findAny())
               .collect(Collectors.toList());
       */
       
    //   parkings.forEach(setParkings::places);
       
       
       Usine[] p=new Usine[tableau.length()];
       for(int i = 0; i < tableau.length(); i++) {
            JSONObject element = tableau.getJSONObject(i);
            int idUsine = element.getInt("idUsine");
            
            Usine usine = new Usine();
            usine.setIdUsine(idUsine);
            usine.setParkings(parkings);
            
            p[i]=usine;
        }
       
    
    }
    
}
