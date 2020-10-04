/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructionautomobile;

import com.univreims.l3info.construction_automobile.domain.model.Carburation;
import com.univreims.l3info.construction_automobile.domain.model.Catalogue;
import com.univreims.l3info.construction_automobile.domain.model.Client;
import com.univreims.l3info.construction_automobile.domain.model.Commande;
import com.univreims.l3info.construction_automobile.domain.model.Modele;
import com.univreims.l3info.construction_automobile.domain.model.Moteur;
import com.univreims.l3info.construction_automobile.domain.model.PlaceParking;
import com.univreims.l3info.construction_automobile.domain.model.Voiture;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author çpc
 */
public class ConstructionAutomobile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         //Modele
        Modele modele1 = new Modele();
        Modele modele2 = new Modele();
        
        modele1.setIdModele(1);
        modele1.setDescription("Twingo");
        
        modele2.setIdModele(2);
        modele2.setDescription("Peugeot");
        
        //client
        Client client1 = new Client();
        client1.setIdClient(1);
        client1.setNomeClient("Felix");
        
        //PlaceParking
        PlaceParking placeParking1 = new PlaceParking();
        placeParking1.setNumRange(1);
        placeParking1.setRange("A");
        
        PlaceParking placeParking2 = new PlaceParking();
        placeParking2.setNumRange(2);
        placeParking2.setRange("B");
        
        //MOteur
        Moteur moteur1 = new Moteur();
        Moteur moteur2 = new Moteur();
        
        moteur1.setNumMoteur(1);
        moteur1.setPuissanceMoteur(120.50);
        
        moteur2.setNumMoteur(2);
        moteur2.setPuissanceMoteur(250.0);
        moteur2.setCarburant(Carburation.HYBRIDE);
        
        
        //Voiture
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        
        voiture1.setIdVoiture(1);
        voiture1.setCouleurVoiture("Bleu");
        voiture1.setDateFabricationVoiture("12/12/2019");
        voiture1.setModeleVoiture(modele2);
        voiture1.setNiuVoiture("11100AA");
        voiture1.setNumeroMoteur(moteur2);
        
        voiture2.setIdVoiture(2);
        voiture2.setCouleurVoiture("Rouge");
        voiture2.setDateFabricationVoiture("12/12/2019");
        voiture2.setModeleVoiture(modele1);
        voiture2.setNiuVoiture("11100BB");
        voiture2.setNumeroMoteur(moteur1);
        voiture2.setGps(Boolean.TRUE);
        voiture2.setRadar(Boolean.TRUE);
        voiture2.setVitreElectrique(Boolean.TRUE);
        
        
        //Catalogue
        Catalogue catalogue1 = new Catalogue();
        //Catalogue catalogue2 = new Catalogue();
        
        catalogue1.setIdCatalogue(1);
        catalogue1.setDatePublication("04/10/2020");
        List<Voiture> voituresList = new ArrayList<>();
        voituresList.add(voiture2);
        voituresList.add(voiture1);
        catalogue1.setVoitures(voituresList);
        
        //Commande
        Commande commande1 = new Commande();
        commande1.setIdCommande(1);
        commande1.setClient(client1);
        commande1.setQteVoiture(2);
        List<Catalogue> cataloguesList = new ArrayList<>();
        cataloguesList.add(catalogue1);
        commande1.setVoitures(cataloguesList);
        
        //Impression des voitures
        for (Voiture voiture : voituresList) {
        System. out.println(voiture);
        }
        
        
    }
    
}
