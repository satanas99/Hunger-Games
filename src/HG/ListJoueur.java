package HG;

import java.util.ArrayList;
import java.util.Collections;

public class ListJoueur extends ArrayList{
    //Attributs
    private ArrayList<Joueur> listJoueurs;

    public ListJoueur() {
        this.listJoueurs = new ArrayList<>();
    }

    public Joueur getJoueur(int i){
        //retourne le joueur a l'index i
        return listJoueurs.get(i);
    }

    public void shuffle(){
        //Melange la liste des joueurs
        Collections.shuffle(listJoueurs);
    }

    public void afficheJoueurs() {
        for (Joueur joueur:listJoueurs) {
            System.out.println("Nom : " + joueur.getNom() + "  Sexe : " + joueur.getSexe() + "  District : " + joueur.getDistrict());
        }
    }

    public void addJoueur(Joueur joueur) {
        listJoueurs.add(joueur);
    }
}
