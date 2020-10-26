/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.lire;

import com.univreims.l3info.construction_automobile.domain.model.Utilisateur;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author çpc
 */
public class UtilisateurLecture1 {

   public static void main(String[] args ) {
      
        

        // Récupération de la chaîne JSON depuis le fichier
        String json = "";
        try {
            byte[] contenu = Files.readAllBytes(Paths.get("user.json"));
          //byte[] contenu = Files.readAllBytes(Paths.get(args[0]));
          json = new String(contenu);        
        } catch(IOException e) {
            System.err.println("Erreur lors de la lecture du fichier '");
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
