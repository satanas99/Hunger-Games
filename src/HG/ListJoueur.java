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
            listJoueurs.add(new Joueur("HabbibSay", "M"));
            listJoueurs.add(new Joueur("Catatomik", "M"));
            listJoueurs.add(new Joueur("Rayoub", "M"));
            listJoueurs.add(new Joueur("Poasson Sama", "M"));
            listJoueurs.add(new Joueur("Arc20", "M"));
            listJoueurs.add(new Joueur("Joker", "M"));
            listJoueurs.add(new Joueur("Nash", "M"));
            listJoueurs.add(new Joueur("Corentin", "M"));
            listJoueurs.add(new Joueur("Keylogz", "M"));
            listJoueurs.add(new Joueur("ZeProf", "M"));
            listJoueurs.add(new Joueur("Satsuki Hyphen", "F"));
            listJoueurs.add(new Joueur("Gui Jim", "M"));
            listJoueurs.add(new Joueur("Dalou58", "M"));
            listJoueurs.add(new Joueur("Satanas", "M"));
            listJoueurs.add(new Joueur("Flens", "M"));
            listJoueurs.add(new Joueur("Zeymah Zun", "M"));
            listJoueurs.add(new Joueur("Arya Zblaaah", "M"));
            listJoueurs.add(new Joueur("Margaux", "F"));
            listJoueurs.add(new Joueur("Poné", "M"));
            listJoueurs.add(new Joueur("Arash", "M"));
            listJoueurs.add(new Joueur("TakeTheBolt", "M"));
            listJoueurs.add(new Joueur("Feitan", "M"));
            listJoueurs.add(new Joueur("Sivagabond", "M"));
            listJoueurs.add(new Joueur("Samuelbella", "M"));
            listJoueurs.add(new Joueur("VirusTm", "M"));
            listJoueurs.add(new Joueur("Spirolad", "M"));
            listJoueurs.add(new Joueur("Terre-clair", "M"));
            listJoueurs.add(new Joueur("Walid", "M"));
            listJoueurs.add(new Joueur("Mythos", "M"));
            listJoueurs.add(new Joueur("Withan", "M"));
            listJoueurs.add(new Joueur("Lucif", "M"));
            listJoueurs.add(new Joueur("OceanSp", "M"));
            listJoueurs.add(new Joueur("Kilyane", "M"));
            listJoueurs.add(new Joueur("Etoile de Glace", "M"));
            listJoueurs.add(new Joueur("Louxus", "M"));
            listJoueurs.add(new Joueur("Shin", "M"));
            listJoueurs.add(new Joueur("Crow", "M"));
            listJoueurs.add(new Joueur("Max23874", "M"));
            listJoueurs.add(new Joueur("SixthAlien", "M"));
            listJoueurs.add(new Joueur("Basdk", "M"));
            listJoueurs.add(new Joueur("Swnopy", "M"));
            listJoueurs.add(new Joueur("Mama", "M"));
            listJoueurs.add(new Joueur("Enderspirit", "M"));
            listJoueurs.add(new Joueur("Aurelle", "F"));
            listJoueurs.add(new Joueur("Kamashi", "M"));
            listJoueurs.add(new Joueur("lmons", "M"));
            listJoueurs.add(new Joueur("Chuck Norris", "M"));
            listJoueurs.add(new Joueur("Quelqu'un", "M"));
        }else{
            this.listJoueurs = new ArrayList<>();
            listJoueurs.add(new Joueur("Toto", "M"));
            listJoueurs.add(new Joueur("Titi", "M"));
            listJoueurs.add(new Joueur("Tata", "F"));
            listJoueurs.add(new Joueur("Tutu", "F"));
        }

    }

    public ArrayList<Joueur> getListJoueurs() {
        return listJoueurs;
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
            System.out.println("Nom : " + joueur.getNom() + " | " + "Sexe : " + joueur.getSexe() + " | " + " District : " + joueur.getDistrict() + " | " + "Kills : " + joueur.getKills() + " | " + "EstMort : " + joueur.isMort());
        }
    }

    public void afficheItems(){
        //Affiche la liste des Items de chaque Joueurs
        for (Joueur joueur : listJoueurs) {
            System.out.print("Items de " + joueur.getNom() + " : ");
            for (Item item: joueur.getSac().getListItems()) {
                System.out.print(item.getNom() + " | ");
            }
            System.out.print("\n");
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

    public void removeJoueur(int i) {//Enleve le joueur a l'indice donner
        listJoueurs.remove(i);
    }
}
