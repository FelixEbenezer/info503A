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
class LoginHandler implements HttpHandler {

    public static final Logger logger = Logger.getLogger("");
   
    public void handle(HttpExchange t) {
        
        String reponse = contenuFormulaire1();
        
        String query = recupererDonneesHttp(t);
                
        JSONObject objet = recuperarUtilisateur();

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
                if(utilisateurId.equals(utilisateurId) && utilisateurName.equals(login) && utilisateurPassword.equals(password) ) 
                
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
        
//            System.err.println(query);
        
    }

    private String recupererDonneesHttp(HttpExchange t) {
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
        return query;
    }

    private String contenuFormulaire() {
        String reponse = "<!DOCTYPE html>" +
                "<html lang=\"fr\">" +
                "<head>" +
                "<meta http-equiv=\"content-type\" content=\"text/html; href=\"estilo.css\" charset=utf-8\"/>" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">" +
                "</head>" +
                "<body>" +
                "<div width:420px id=\"area\">" +
                "<h1 width=\"48\" height=\"48\">Bienvenue sur la page d'accueil du TP - LOGIN</h1>" +
                        "<form width:320px id=\"formulario\" method=\"post\" action=\"http://localhost:8083/login\">" +
                        "<label>Remplissez le formulaie ci dessous pour se connecter</label>" + "</br>" +
                        "<label>IdUser</label><input type=\"text\" required name=\"idUser\"/>" + "</br>" +
                        "<label>UserName</label><input width=\"48\" height=\"48\" type=\"text\" required name=\"username\"/>" + "</br>" +
                        "<label>UserPassword</label><input type=\"password\" required name=\"passwordUser\"/>" + "</br>" +
                        "<button>Se connecter</button>"+ "</br>" +
                        "</form>" + "</br>" +
                        "<form method=\"post\" action=\"http://localhost:8083/index\">" +
                        "<button>Annuler</button>"+
                        "</form>" +
                 "</div>" +
                 "</body>";
        return reponse;
    }
    
    private String contenuFormulaire1() {
        String reponse = "<!DOCTYPE html>" +
                "<html lang=\"fr\">" +
                "<head>" +
                  "<title>Meu Formulário Personalizado</title>" +
                  "<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">" +
                  "<link rel=\"stylesheet\" type=\"text/css\" href=\"estiloie.css\">" +
                "</head>" + 
              "<body>" +
                "<div id=\"area\">" +
                "<h1 id=\"a\">Bienvenue sur la page d'accueil du TP - LOGIN</h1>" +
                  "<form id=\"formulario\" autocomplete=\"off\" method=\"post\" action=\"http://localhost:8083/login\">" + "</br>"+
                    "<label>Remplissez le formulaie ci dessous pour se connecter</label>" + "</br>" +
                    "<fieldset>" +
                      "<legend>Formulaire de LOGIN</legend>" +
                      "<label>IdUser     :</label><input class=\"campo_nome\" type=\"text\" required name=\"idUser\"><br>" +
                      "<label>Email/Login:</label><input class=\"campo_email\" type=\"text\" required name=\"username\"><br>" +
                      "<label>Password   :</label><input class=\"campo_email\" type=\"password\" required name=\"username\"><br>" +
                      "<input class=\"btn_submit\" type=\"submit\" value=\"Se connecter\">" +
                    "</fieldset>" +
                  "</form>" +
                        "<form method=\"post\" action=\"http://localhost:8083/index\">" +
                        "<button>Annuler</button>"+
                        "</form>" +
                "</div>" +
              "</body>" +
              "</html>";
        return reponse;
    }

    private JSONObject recuperarUtilisateur() throws JSONException {
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
        return objet;
    }
   

}








