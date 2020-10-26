/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.ecrire;

import com.univreims.l3info.construction_automobile.domain.model.Utilisateur;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 *
 * @author çpc
 */
public class GenerateurUtilisateur1 {
    
       public void genererUser(String id, String login, String pass ) {

        //Utilisateur
        Utilisateur user1 = new Utilisateur();
        user1.setIdUtilisateur(Integer.parseInt(id));
        user1.setLogin(login);
        user1.setPassword(pass);
        
        // Génération du JSON depuis un tableau d'objets
        Utilisateur p[] = { user1 };
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
           fs = new FileWriter("user.json");
        } catch(IOException e) {
            System.err.println("Erreur lors de l'ouverture du fichier '" + "user.json" + "'.");
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
        
        System.out.println("Le fichier '" + "user.json" + "' a été généré.");
        System.out.println(user1);
        
        
        }        

    
}
