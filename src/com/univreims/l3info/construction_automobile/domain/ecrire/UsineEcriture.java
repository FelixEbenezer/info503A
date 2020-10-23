/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.ecrire;

import com.univreims.l3info.construction_automobile.domain.factory.usine.UsineFactory;
import com.univreims.l3info.construction_automobile.domain.model.Usine;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author çpc
 */
public class UsineEcriture {
    
        public static void main(String[] args) throws IOException {
       // args[0]="livre.json";
                // Vérification des arguments
        if(args.length != 1) {
            System.err.println("Erreur : vous devez spécifier le nom du fichier JSON.");
            System.err.println();
            System.err.println("Usage : java GenerateurJSON fichier.json");
            System.err.println("\toù 'fichier.json' est le nom du fichier dans lequel sauvegarder");
            System.exit(0);
        }
        
        UsineFactory usineFactory = new UsineFactory();
        Usine usine1 = usineFactory.getUsine(1);
        usine1 = usine1.creerUsine();
        Usine usine2 = usineFactory.getUsine(2);
        usine2 = usine2.creerUsine();
        
        
        Usine p[] = { usine1, usine2 };
        
        JSONObject objet = new JSONObject();
        
        // Ajout du tableau
        try {
            objet.put("contacts", new JSONArray(p));
        } catch(JSONException e) {
            System.err.println("Erreur lors de l'insertion du tableau.");
            System.err.println(e);
            System.exit(0);
        }
        
        // Création du fichier de sortie
        FileWriter fs = null;
        try {
           // fs = new FileWriter(new File("livre.json"));
           fs = new FileWriter(args[0]);
        } catch(IOException e) {
            System.err.println("Erreur lors de l'ouverture du fichier '" + args[0] + "'.");
            System.err.println(e);
            System.exit(0);
        }
        
        // Sauvegarde dans le fichier
        try {
            objet.write(fs, 3, 0);
            fs.flush();
        } catch(IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier.");
            System.err.println(e);
            System.exit(0);
        }
        
        // Fermeture du fichier
        try {
            fs.close();
        } catch(IOException e) {
            System.err.println("Erreur lors de la fermeture du fichier.");
            System.err.println(e);
            System.exit(0);
        }
        
        System.out.println("Le fichier '" + args[0] + "' a été généré.");
        System.out.println(usine1);
        System.out.println("=====================================");
        System.out.println(usine2.getParkings());
        
        }        

    
}


//ancien methode avant de creer usineFactory
/*


        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture(); 


          //PlaceParking
        PlaceParking placeParking1 = new PlaceParking();
        placeParking1.setNumRange(1);
        placeParking1.setRange("A");
        placeParking1.setVoiture(voiture1);
        
        PlaceParking placeParking2 = new PlaceParking();
        placeParking2.setNumRange(2);
        placeParking2.setRange("B");
        placeParking2.setVoiture(voiture2);
        
        List<PlaceParking> placesParking = new ArrayList<>();
        placesParking.add(placeParking2);
        placesParking.add(placeParking1);
    
        //List Parking
        Parking par1 = new Parking(); 
        Parking par2 = new Parking();
        par1.setIdParking(1);
        par2.setIdParking(2);
        par1.setPlacesParking(placesParking);
        
       
        
        //Usine
        Usine us1 = new Usine();
        us1.setIdUsine(1);
        
        List<Parking> parkings = new ArrayList<>();
        parkings.add(par1);
        parkings.add(par2);
        
        us1.setParkings(parkings);
        
   /*     parkings.stream()
               .map(c -> c.getVoitures())
               .collect(Collectors.toList());
        // Génération du JSON depuis un tableau d'objets
     */


