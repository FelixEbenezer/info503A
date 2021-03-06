/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.mediatheque1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author çpc
 */
public class TesteMediatheque1 {
    
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

        
        Auteur felix = new Auteur("Felix", "20/5/1980");
        Auteur nganga = new Auteur("Nganga", "20/10/2000");
        Livre livre1 = new Livre("Le parfum", felix);
        Livre livre2 = new Livre("La France", nganga);
        Livre livre3 = new Livre("Je t avais prévenu", felix);
        Livre livre4 = new Livre("LOMPART", felix);
        
        //Mediatheque
        Mediatheque media1 = new Mediatheque();
        media1.ajouterLivre(livre4);
        media1.ajouterLivre(livre1);
        media1.ajouterLivre(livre2);
        media1.ajouterLivre(livre3);
        
        
        // Génération du JSON depuis un tableau d'objets
        Livre p[] = { livre1, livre2, livre3, livre4 };
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
