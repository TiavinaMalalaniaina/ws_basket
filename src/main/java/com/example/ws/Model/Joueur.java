package com.example.ws.Model;

import java.sql.Date;

public class Joueur {
    String id;
    String nom;
    String prenom;
    Date dtn;
    double taille;
    double poids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public Joueur(String id, String nom, String prenom, Date dtn, double taille, double poids) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDtn(dtn);
        this.setTaille(taille);
        this.setPoids(poids);
    }
}
