/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.lire;

import com.univreims.l3info.construction_automobile.domain.model.Modele;
import com.univreims.l3info.construction_automobile.domain.model.Moteur;
import com.univreims.l3info.construction_automobile.domain.model.Voiture;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author çpc
 */
public class VoitureLecture {

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
       Modele mo = new Modele();
       Moteur mot = new Moteur();
       
       Voiture[] p=new Voiture[tableau.length()];
       for(int i = 0; i < tableau.length(); i++) {
            JSONObject element = tableau.getJSONObject(i);
            int idVoiture = element.getInt("idVoiture");
            String niuVoiture = element.getString("niuVoiture");
            String couleurVoiture = element.getString("couleurVoiture");
            String dateFabricationVoiture = element.getString("dateFabricationVoiture");
            Boolean vitreElectrique = element.getBoolean("vitreElectrique");
            Boolean radar = element.getBoolean("radar");
            Boolean gps = element.getBoolean("gps");
            
            Voiture voiture = new Voiture();
            voiture.setIdVoiture(idVoiture);
            voiture.setCouleurVoiture(couleurVoiture);
            voiture.setNiuVoiture(niuVoiture);
            voiture.setDateFabricationVoiture(dateFabricationVoiture);
            voiture.setModeleVoiture(mo);
            voiture.setNumeroMoteur(mot);
            
            p[i]=voiture;
        }
       
    
    }
    
}
