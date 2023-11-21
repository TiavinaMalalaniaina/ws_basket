package com.example.ws.Model;

public class Equipe {
    String id;
    String nom;

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

    public Equipe(String id, String nom) {
        this.setId(id);
        this.setNom(nom);
    }
}
