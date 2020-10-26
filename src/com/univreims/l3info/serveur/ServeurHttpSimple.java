package com.univreims.l3info.serveur;


import java.io.IOException;
import com.sun.net.httpserver.HttpServer;
import static com.univreims.l3info.serveur.LoginHandler1.logger;
import java.net.InetSocketAddress;

/**
 * Classe correspondant à un serveur Http simple.
 * Le serveur écoute sur le port 8080 sur le contexte 'index'.
 * Le résultat est une simple page qui affiche les données envoyées en POST et en GET
 * @author Cyril Rabat
 */
public class ServeurHttpSimple {

    public static void main(String[] args) {    
        HttpServer serveur = null;
        try {
            serveur = HttpServer.create(new InetSocketAddress(8083), 0);
        } catch(IOException e) {
            System.err.println("Erreur lors de la création du serveur " + e);
            System.exit(0);
        }

     //   serveur.createContext("/index", new AccueilSimpleHandler());
       serveur.createContext("/index", new IndexHandler());
       serveur.createContext("/login", new LoginHandler());
       serveur.createContext("/inscription", new InscriptionHandler());
      // serveur.createContext("/index", new AcueilHandler());
       
        serveur.setExecutor(null);
        serveur.start();

        System.out.println("Serveur démarré. Pressez CRTL+C pour arrêter.");
        
     //    logger.info("Recuperation des donnees en Post avec query");
    }

}