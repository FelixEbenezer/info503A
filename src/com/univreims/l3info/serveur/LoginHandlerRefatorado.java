package com.univreims.l3info.serveur;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Headers;
import com.univreims.l3info.construction_automobile.domain.model.Utilisateur;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Classe correspondant au handler sur le contexte 'index.html'.
 * @author Cyril Rabat
 */
class LoginHandlerRefatorado implements HttpHandler {
    
   public static final Logger logger = Logger.getLogger("");
    

    public void handle(HttpExchange t) {
        String reponse = "<!DOCTYPE html>" +
                         "<html lang=\"fr\">" +
                         "<head>" +
                         "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>" +
                         "</head>" +
                         "<body>" +
                         "<h1>Bienvenue sur la page d'accueil du TP - LOGIN</h1>" +                
                "<form method=\"post\" action=\"http://localhost:8083/login\">" +
      "<label>Remplissez le formulaie ci dessous pour se connecter</label>" + "</br>" +
       "<label>IdUser</label><input type=\"text\" required name=\"idUser\"/>" + "</br>" +
       "<label>UserName</label><input type=\"text\" required name=\"username\"/>" + "</br>" +
       "<label>UserPassword</label><input type=\"password\" required name=\"passwordUser\"/>" + "</br>" + 
      "<button>Se connecter</button>"+ "</br>" +
      "</form>" + "</br>" +
      "<form method=\"post\" action=\"http://localhost:8083/index\">" +
      "<button>Annuler</button>"+
      "</form>";
        

        // Récupération des données
        URI requestedUri = t.getRequestURI();
        String query = requestedUri.getRawQuery();

        // Utilisation d'un flux pour lire les données du message Http
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(t.getRequestBody(),"utf-8"));
        } catch(UnsupportedEncodingException e) {
            System.err.println("Erreur lors de la récupération du flux " + e);
            System.exit(0);
        }
    
        // Récupération des données en POST
        try {
            query = br.readLine();
        } catch(IOException e) {
            System.err.println("Erreur lors de la lecture d'une ligne " + e);
            System.exit(0);
        }
        
        
        //Recuperation des utilisateurs de fichier user.json
        
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
       
        
       int idUtilisateur=1;
       String login = null; 
       String password = null;
       
       JSONArray tableau = objet.getJSONArray("contacts");
             
       Utilisateur[] p=new Utilisateur[tableau.length()];
       for(int i = 0; i < tableau.length(); i++) {
            JSONObject element = tableau.getJSONObject(i);
            
            idUtilisateur = element.getInt("idUtilisateur");
            login = element.getString("login");
            password = element.getString("password");
            
            Utilisateur uti = new Utilisateur();
              
            p[i]=uti;
        }
             
                
        // Affichage des données
        reponse += "<p>Données en POST : ";
        
        if(query == null)
            reponse += "<b>Aucune</b></p>";
        else {
            try {
                query = URLDecoder.decode(query, "UTF-8");
                
                String utilisateurId = null; 
                String utilisateurName = null;
                String utilisateurPassword = null;
                
                Scanner scanner = new Scanner(query);
                scanner.useDelimiter("&");
              //  Pattern pattern = Pattern.compile("=\\w+&");
             //   scanner.useDelimiter(pattern);
                while (scanner.hasNext())
                {
                
                         String userId = scanner.next();
                         String username = scanner.next();
                         String passwordUser = scanner.next();
                         
                         Scanner scanner1 = new Scanner(userId);
                         scanner1.useDelimiter("=");
                         String us = scanner1.next();
                         utilisateurId = scanner1.next();
                         System.out.println("UserID: "+utilisateurId);
                         
                         Scanner scannerusername = new Scanner(username);
                         scannerusername.useDelimiter("=");
                         String userna1 = scannerusername.next();
                         utilisateurName = scannerusername.next();
                         
                        System.out.println("UserName: "+utilisateurName);
                         
                         Scanner scannerpassword = new Scanner(passwordUser);
                         scannerpassword.useDelimiter("=");
                         String pass1 = scannerpassword.next();
                         utilisateurPassword = scannerpassword.next();
                         
                        System.out.println("Password: "+utilisateurPassword);
                        
                }
                //if(utilisateurId.equals(idUtilisateur) && utilisateurName.equals(login) && utilisateurPassword.equals(password) ) 
                if(utilisateurId.equals("1") ||utilisateurId.equals("2") && utilisateurName.equals(login) && utilisateurPassword.equals(password) ) 
                
                {
                   reponse += "<b>" + query + "</b></p>";          
                }
                else
                {
                    reponse += "<b>" + "IdUtilisateur introuvalbe ou inexistant, ressaie" + "</b></p>";
        
                }
               } 
                catch(UnsupportedEncodingException e) {
                query = "";
            }            
        }             


        // Envoi de l'en-tête Http
        try {
            Headers h = t.getResponseHeaders();
            h.set("Content-Type", "text/html; charset=utf-8");
            t.sendResponseHeaders(200, reponse.getBytes().length);
        } catch(IOException e) {
            System.err.println("Erreur lors de l'envoi de l'en-tête : " + e);
            System.exit(0);
        }

        // Envoi du corps (données HTML)
        try {
            OutputStream os = t.getResponseBody();
            os.write(reponse.getBytes());
            os.close();
        } catch(IOException e) {
            System.err.println("Erreur lors de l'envoi du corps : " + e);
        }
        
            System.err.println(query);
        
    }
   

}
