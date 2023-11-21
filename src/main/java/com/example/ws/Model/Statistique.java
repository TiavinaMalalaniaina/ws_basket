package com.example.ws.Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Statistique {

    String joueurNom;
    String equipeNom;
    int matchJoueJoueur;
    int nbMatchJoueEquipe;
    double rebond;
    double passeDecisif;
    double tempsDeJeu;
    double efficacite;
    double pourcentageTire;
    double pourcentageTroisPoint;
    double pourcentageLancee;

    public String getJoueurNom() {
        return joueurNom;
    }

    public void setJoueurNom(String joueurNom) {
        this.joueurNom = joueurNom;
    }

    public String getEquipeNom() {
        return equipeNom;
    }

    public void setEquipeNom(String equipeNom) {
        this.equipeNom = equipeNom;
    }

    public int getNbMatchJoueEquipe() {
        return nbMatchJoueEquipe;
    }

    public void setNbMatchJoueEquipe(int nbMatchJoueEquipe) {
        this.nbMatchJoueEquipe = nbMatchJoueEquipe;
    }


    public double getRebond() {
        return rebond;
    }

    public void setRebond(double rebond) {
        this.rebond = rebond;
    }

    public double getPasseDecisif() {
        return passeDecisif;
    }

    public void setPasseDecisif(double passeDecisif) {
        this.passeDecisif = passeDecisif;
    }

    public double getTempsDeJeu() {
        return tempsDeJeu;
    }

    public void setTempsDeJeu(double tempsDeJeu) {
        this.tempsDeJeu = tempsDeJeu;
    }

    public double getEfficacite() {
        return efficacite;
    }

    public void setEfficacite(double efficacite) {
        this.efficacite = efficacite;
    }

    public double getPourcentageTire() {
        return pourcentageTire;
    }

    public void setPourcentageTire(double pourcentageTire) {
        this.pourcentageTire = pourcentageTire;
    }

    public double getPourcentageTroisPoint() {
        return pourcentageTroisPoint;
    }

    public void setPourcentageTroisPoint(double pourcentageTroisPoint) {
        this.pourcentageTroisPoint = pourcentageTroisPoint;
    }

    public double getPourcentageLancee() {
        return pourcentageLancee;
    }

    public void setPourcentageLancee(double pourcentageLancee) {
        this.pourcentageLancee = pourcentageLancee;
    }

    public Statistique(String joueurName, String equipeName, int nbMatchJoueEquipe, int matchJoueJoueur, double rebond, double passeDecisif, double tempsDeJeu, double efficacite, double pourcentageTire, double pourcentageTroisPoint, double pourcentageLancee) {
        this.joueurNom = joueurName;
        this.equipeNom = equipeName;
        this.nbMatchJoueEquipe = nbMatchJoueEquipe;
        this.matchJoueJoueur = matchJoueJoueur;
        this.rebond = rebond;
        this.passeDecisif = passeDecisif;
        this.tempsDeJeu = tempsDeJeu;
        this.efficacite = efficacite;
        this.pourcentageTire = pourcentageTire;
        this.pourcentageTroisPoint = pourcentageTroisPoint;
        this.pourcentageLancee = pourcentageLancee;
    }

    public Statistique() {

    }

    public Statistique[] getStatitstiques(Connection connection) {
        Statistique[] statistiqueList = {
                new Statistique("Turner", " Les Faucons", 1, 1, 12, 10, 20, 45, 60, 68, 90),
                new Statistique("Thomas", " Les Faucons", 1, 1, 11, 11, 25, 11, 59, 88, 67),
                new Statistique("Rodriguez", " Les Faucons", 1, 1, 9, 9, 15, 12, 78, 88, 89),
                new Statistique("Williams", " Les Faucons", 1, 1, 6, 7, 17, 60, 90, 89, 80),
                new Statistique("Chang", " Les Faucons", 1, 1, 17, 11, 25, 50, 55, 60, 50),
                new Statistique("Martinez", " Les Faucons", 1, 1, 8, 3, 25, 70, 20, 56, 30),
                new Statistique("Jasmine", " Les Faucons", 1, 1, 12, 4, 30, 30, 89, 90, 80),
                new Statistique("Anderson", " Les Loups", 1, 1, 3, 11, 29, 45, 65, 68, 40),
                new Statistique("Smith", " Les Loups", 1, 1, 8, 13, 34, 41, 77, 78, 77),
                new Statistique("Hernandez", " Les Loups", 1, 1, 9, 9, 25, 82, 68, 88, 89),
                new Statistique("Thompson", " Les Loups", 1, 1, 6, 9, 19, 60, 88, 69, 80),
                new Statistique("Taylor", " Les Loups", 1, 1, 11, 12, 26, 50, 65, 60, 60),
                new Statistique("Davis", " Les Loups", 1, 1, 14, 3, 21, 60, 30, 60, 40),
                new Statistique("Foster", " Les Loups", 1, 1, 12, 4, 30, 60, 49, 80, 70)

        };
        //statistiqueList.add(statistique);
        return statistiqueList;
    }

}
