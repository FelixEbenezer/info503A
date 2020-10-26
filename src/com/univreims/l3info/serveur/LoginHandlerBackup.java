package com.univreims.l3info.serveur;

import java.io.InputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Headers;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Classe correspondant au handler sur le contexte 'index.html'.
 * @author Cyril Rabat
 */
class LoginHandlerBackup implements HttpHandler {

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
       "<label>IdUser</label><input type=\"text\" name=\"idUser\"/>" + "</br>" +
       "<label>UserName</label><input type=\"text\" name=\"username\"/>" + "</br>" +
       "<label>UserPassword</label><input type=\"password\" name=\"passwordUser\"/>" + "</br>" + 
      "<button>Se connecter</button>"+ "</br>" +
      "</form>" + "</br>" +
      "<form method=\"get\" action=\"http://localhost:8083/index\">" +
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
            System.err.println("2-LoginHandler1: sa query"+query);
            logger.info("2.1- LoginHandler1: Recuperation des donnees en Post avec query");
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
               // analysisParms(t);
               System.err.println("2.2-LoginHandler1: sa query"+query);
               logger.info("2.3-LoginHandler1: Affichage de données en Post avec query");
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
    
    private Map<String, Object> analysisParms(HttpExchange httpExchange)
		throws UnsupportedEncodingException {
	Map<String, Object> map = new HashMap<String, Object>();

	URI requestedUri = httpExchange.getRequestURI();
	String queryGet = requestedUri.getRawQuery();
//	String queryPost = IOUtil.getRequestContent(httpExchange.getRequestBody());

        InputStream inputStream = httpExchange.getRequestBody();
        String queryPost = inputStream.toString();
        
        String query = "";
	if (!StringUtil.isEmpty(queryGet)) {
		query = queryGet;
	}
	if (!StringUtil.isEmpty(queryPost)) {
		query = StringUtil.isEmpty(query) ? queryPost : (query + "&" + queryPost);
	}
	if (StringUtil.isEmpty(query)) {
		return map;
	}

	for (String kv : query.split("&")) {
		String[] temp = kv.split("=");
		map.put(temp[0], URLDecoder.decode(temp[1], "utf-8"));
	}
	return map;
}
    
    

}