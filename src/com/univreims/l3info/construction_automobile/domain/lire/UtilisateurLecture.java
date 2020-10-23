/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.lire;

import com.univreims.l3info.construction_automobile.domain.model.Client;
import com.univreims.l3info.construction_automobile.domain.model.Modele;
import com.univreims.l3info.construction_automobile.domain.model.Moteur;
import com.univreims.l3info.construction_automobile.domain.model.Parking;
import com.univreims.l3info.construction_automobile.domain.model.PlaceParking;
import com.univreims.l3info.construction_automobile.domain.model.Usine;
import com.univreims.l3info.construction_automobile.domain.model.Utilisateur;
import com.univreims.l3info.construction_automobile.domain.model.Voiture;
import com.univreims.l3info.mediatheque1.Auteur;
import com.univreims.l3info.mediatheque1.Livre;
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
public class UtilisateurLecture {

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
       
       Utilisateur[] p=new Utilisateur[tableau.length()];
       for(int i = 0; i < tableau.length(); i++) {
            JSONObject element = tableau.getJSONObject(i);
            
            int idUtilisateur = element.getInt("idUtilisateur");
            String login = element.getString("login");
            String password = element.getString("password");
            
            Utilisateur uti = new Utilisateur();
            uti.setIdUtilisateur(idUtilisateur);
            uti.setLogin(login);
            uti.setPassword(password);
            
            p[i]=uti;
        }
       
    
    }
    
}
