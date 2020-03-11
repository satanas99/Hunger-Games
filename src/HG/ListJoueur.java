package HG;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class ListJoueur{
    //Attributs
    private ArrayList<Joueur> listJoueurs;

    public ListJoueur() {
        this.listJoueurs = new ArrayList<>();
    }

    public ListJoueur(boolean vide) {
        //Crée une liste pour pas avoir a demander les noms
        if (vide){
            this.listJoueurs = new ArrayList<>();
            listJoueurs.add(new Joueur("1", "M"));
            listJoueurs.add(new Joueur("2", "M"));
            listJoueurs.add(new Joueur("3", "M"));
            listJoueurs.add(new Joueur("4", "F"));
            listJoueurs.add(new Joueur("5", "M"));
            listJoueurs.add(new Joueur("6", "M"));
            listJoueurs.add(new Joueur("7", "M"));
            listJoueurs.add(new Joueur("8", "M"));
            listJoueurs.add(new Joueur("9", "F"));
            listJoueurs.add(new Joueur("10", "M"));
            listJoueurs.add(new Joueur("11", "M"));
            listJoueurs.add(new Joueur("12", "M"));
            listJoueurs.add(new Joueur("13", "F"));
            listJoueurs.add(new Joueur("14", "M"));
            listJoueurs.add(new Joueur("15", "M"));
            listJoueurs.add(new Joueur("16", "M"));
            listJoueurs.add(new Joueur("17", "M"));
            listJoueurs.add(new Joueur("18", "M"));
            listJoueurs.add(new Joueur("19", "F"));
            listJoueurs.add(new Joueur("20", "M"));
            listJoueurs.add(new Joueur("21", "M"));
            listJoueurs.add(new Joueur("22", "M"));
            listJoueurs.add(new Joueur("23", "M"));
            listJoueurs.add(new Joueur("24", "M"));
            /*listJoueurs.add(new Joueur("25", "M"));
            listJoueurs.add(new Joueur("26", "M"));
            listJoueurs.add(new Joueur("27", "M"));
            listJoueurs.add(new Joueur("28", "M"));
            listJoueurs.add(new Joueur("29", "M"));
            listJoueurs.add(new Joueur("30", "F"));
            listJoueurs.add(new Joueur("31", "M"));
            listJoueurs.add(new Joueur("32", "M"));
            listJoueurs.add(new Joueur("33", "M"));
            listJoueurs.add(new Joueur("34", "M"));
            listJoueurs.add(new Joueur("35", "M"));
            listJoueurs.add(new Joueur("36", "M"));*/
        }
    }

    public Joueur getJoueur(int i){
        //retourne le joueur a l'index i
        return listJoueurs.get(i);
    }

    public Joueur getLastJoueur(){
        return listJoueurs.get(listJoueurs.size()-1);
    }

    public void shuffle(){
        //Melange la liste des joueurs
        Collections.shuffle(listJoueurs);
    }

    public void afficheJoueurs() {
        //Affiche la liste des joueurs
        for (Joueur joueur : listJoueurs) {
            System.out.println("Nom : " + joueur.getNom() + "  Sexe : " + joueur.getSexe() + "  District : " + joueur.getDistrict());
        }
    }

    public void addJoueur(Joueur joueur) {
        listJoueurs.add(joueur);
    }

    public int size() {
        return listJoueurs.size();
    }

    public void supprLastJoueur() {
        //Supprime le dernier joueur de la liste
        listJoueurs.remove(listJoueurs.size()-1);
    }
}
