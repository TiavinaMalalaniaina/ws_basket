package com.example.ws.Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Statistique {

    String joueurName;
    String equipeName;
    int nbMatchJoueEquipe;
    int matchJoueJoueur;
    double rebond;
    double passeDecisif;
    double tempsDeJeu;
    double efficacite;
    double pourcentageTire;
    double pourcentageTroisPoint;
    double pourcentageLancee;

    public String getJoueurName() {
        return joueurName;
    }

    public void setJoueurName(String joueurName) {
        this.joueurName = joueurName;
    }

    public String getEquipeName() {
        return equipeName;
    }

    public void setEquipeName(String equipeName) {
        this.equipeName = equipeName;
    }

    public int getNbMatchJoueEquipe() {
        return nbMatchJoueEquipe;
    }

    public void setNbMatchJoueEquipe(int nbMatchJoueEquipe) {
        this.nbMatchJoueEquipe = nbMatchJoueEquipe;
    }

    public int getMatchJoueJoueur() {
        return matchJoueJoueur;
    }

    public void setMatchJoueJoueur(int matchJoueJoueur) {
        this.matchJoueJoueur = matchJoueJoueur;
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
        this.joueurName = joueurName;
        this.equipeName = equipeName;
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

    public List<Statistique> getStatitstiques(Connection connection) {
        List<Statistique> statistiqueList = new ArrayList<>();
        Statistique statistique = new Statistique("LEBROWN", "LAKERS", 10, 8, 12, 34, 178, 45, 60, 68, 90);
        statistiqueList.add(statistique);
        return statistiqueList;
    }
}
