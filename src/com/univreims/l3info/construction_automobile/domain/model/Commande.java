/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univreims.l3info.construction_automobile.domain.model;

import java.util.List;

/**
 *
 * @author çpc
 */
public class Commande {
    
    private int idCommande;
    private int qteVoiture;
    private Client client;
    private List<Catalogue> voitures;

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getQteVoiture() {
        return qteVoiture;
    }

    public void setQteVoiture(int qteVoiture) {
        this.qteVoiture = qteVoiture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Catalogue> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Catalogue> voitures) {
        this.voitures = voitures;
    }

    
    
    
    
    
    
}
