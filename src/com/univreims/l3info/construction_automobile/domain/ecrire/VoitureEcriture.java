/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.ecrire;

import com.univreims.l3info.construction_automobile.domain.model.Carburation;
import com.univreims.l3info.construction_automobile.domain.model.Client;
import com.univreims.l3info.construction_automobile.domain.model.Modele;
import com.univreims.l3info.construction_automobile.domain.model.Moteur;
import com.univreims.l3info.construction_automobile.domain.model.Parking;
import com.univreims.l3info.construction_automobile.domain.model.PlaceParking;
import com.univreims.l3info.construction_automobile.domain.model.Voiture;
import com.univreims.l3info.mediatheque1.Auteur;
import com.univreims.l3info.mediatheque1.Livre;
import com.univreims.l3info.mediatheque1.Mediatheque;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author çpc
 */
public class VoitureEcriture {
    
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

        
                 //Modele
        Modele modele1 = new Modele();
        Modele modele2 = new Modele();
        
        modele1.setIdModele(1);
        modele1.setDescription("Twingo");
        
        modele2.setIdModele(2);
        modele2.setDescription("Peugeot");
        
        //MOteur
        Moteur moteur1 = new Moteur();
        Moteur moteur2 = new Moteur();
        
        moteur1.setNumMoteur(1);
        moteur1.setPuissanceMoteur(120.50);
        
        moteur2.setNumMoteur(2);
        moteur2.setPuissanceMoteur(250.0);
        moteur2.setCarburant(Carburation.HYBRIDE);
        
        
        //Voiture
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        
        voiture1.setIdVoiture(1);
        voiture1.setCouleurVoiture("Bleu");
        voiture1.setDateFabricationVoiture("12/12/2019");
        voiture1.setModeleVoiture(modele2);
        voiture1.setNiuVoiture("11100AA");
        voiture1.setNumeroMoteur(moteur2);
        
        voiture2.setIdVoiture(2);
        voiture2.setCouleurVoiture("Rouge");
        voiture2.setDateFabricationVoiture("12/12/2019");
        voiture2.setModeleVoiture(modele1);
        voiture2.setNiuVoiture("11100BB");
        voiture2.setNumeroMoteur(moteur1);
        voiture2.setGps(Boolean.TRUE);
        voiture2.setRadar(Boolean.TRUE);
        voiture2.setVitreElectrique(Boolean.TRUE);
        
        //Parking
            Parking parking = new Parking();
            List<Voiture> voitures = new ArrayList<>();
            voitures.add(voiture2);
            voitures.add(voiture1);
            parking.setVoitures(voitures);
        
        // Génération du JSON depuis un tableau d'objets
        Voiture p[] = { voiture1, voiture2 };
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
        
        
        }        

    
}
