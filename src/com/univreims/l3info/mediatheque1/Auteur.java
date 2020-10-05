package com.univreims.l3info.mediatheque1;

/**
 * Classe représentant un auteur de livre.
 * @author Cyril Rabat
 */
public class Auteur {

    private String nom;
    private String dateNaissance;

    public Auteur() {
    }
   
    /**
     * Crée un auteur avec un nom et une date de naissance.
     * @param nom le nom
     * @param dateNaissance la date de naissance
     */
    
    
    
    public Auteur(String nom, String dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }
    
    /**
     * Retourne le nom.
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Retourne la date de naissance.
     * @return la date de naissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    
    
    /**
     * Convertit l'auteur en chaîne de caractères.
     * @return une chaîne de caractères
     */
    @Override
    public String toString() {
        return nom + ", " + dateNaissance;
    }

}