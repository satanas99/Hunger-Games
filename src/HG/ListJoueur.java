package HG;

import java.util.ArrayList;
import java.util.Collections;

public class ListJoueur{
    //Attributs
    private ArrayList<Joueur> listJoueurs;

    public ListJoueur() {
        this.listJoueurs = new ArrayList<>();
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
