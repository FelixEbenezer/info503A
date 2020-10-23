package com.univreims.l3info.serveur;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpPrincipal;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLDecoder;
import javax.xml.ws.Response;

/**
 * Classe correspondant au handler sur le contexte 'index.html'.
 * @author Cyril Rabat
 */
class LoginHandler implements HttpHandler {

    public void handle(HttpExchange t) {
        String reponse = "<!DOCTYPE html>" +
                         "<html lang=\"fr\">" +
                         "<head>" +
                         "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>" +
                         "</head>" +
                         "<body>" +
                         "<h1>Bienvenue sur la page d'accueil du TP - LOGIN</h1>" +                
                "<form method=\"post\" action=\"http://localhost:8087/login\">" +
      "<label>Remplissez le formulaie ci dessous pour se connecter</label>" + "</br>" +
       "<label>IdUser</label><input type=\"text\" name=\"idUser\"/>" + "</br>" +
       "<label>UserName</label><input type=\"text\" name=\"username\"/>" + "</br>" +
       "<label>UserPassword</label><input type=\"password\" name=\"passwordUser\"/>" + "</br>" + 
      "<button>Se connecter</button>"+ "</br>" +
      "</form>" + "</br>" +
      "<form method=\"get\" action=\"http://localhost:8087/index\">" +
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
        
        
        
        // Affichage des données
        reponse += "<p>Données en POST : ";
        

        
        if(query == null)
            reponse += "<b>Aucune</b></p>";
        else {
            try {
                query = URLDecoder.decode(query, "UTF-8");
            } catch(UnsupportedEncodingException e) {
                query = "";
            }            
            reponse += "<b>" + query + "</b></p>";
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
    }

}