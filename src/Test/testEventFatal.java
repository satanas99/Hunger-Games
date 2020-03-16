package Test;

import Events.EventFatal;
import HG.Item;
import HG.Joueur;
import HG.ListItems;
import HG.ListJoueur;

import java.util.List;

public class testEventFatal {
    public static void main(String[] args) {
        ListJoueur ljoueurs = new ListJoueur();
        ljoueurs.addJoueur( new Joueur("Toto","M"));
        ljoueurs.addJoueur( new Joueur("Tata","F"));
        ljoueurs.addJoueur( new Joueur("Titi","M"));
        boolean[] mort = {false,true,true};
        int[] tuer = {2,0,0};

        EventFatal event = new EventFatal("[Joueur1] combat [Joueur2] et [Joueur3]. [il/elle1] les tue.", 2, mort , tuer);

        String phrase = event.traduirePhrase(ljoueurs);
        addKills(ljoueurs, tuer);

        System.out.println(event.getPhrase());
        System.out.println(phrase);
        ljoueurs.afficheJoueurs();
    }

    public static void addKills(ListJoueur ljoueurs,int[] tuer){
        int compt = 0;
        for (int kill:tuer){
            ljoueurs.getJoueur(compt).ajouteKill(kill);
            compt+=1;
        }
    }
}
