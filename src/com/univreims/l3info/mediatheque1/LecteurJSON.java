package com.univreims.l3info.mediatheque1;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe illustrant la lecture de JSON depuis un fichier texte.
 * Le nom du fichier doit être passé en paramètre.
 * @author Cyril Rabat
 */
public class LecteurJSON {

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
       Auteur pp=new Auteur();
       Livre[] p=new Livre[tableau.length()];
       for(int i = 0; i < tableau.length(); i++) {
            JSONObject element = tableau.getJSONObject(i);
            String titre = element.getString("titre");
            
            Livre livre = new Livre(titre, pp);
            p[i]=livre;
        }
        for(int i=0;i<p.length;i++)
        {
        //    System.out.println(p[i]);
        }
    
    }
}