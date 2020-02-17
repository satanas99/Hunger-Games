import Fonctions.Item;
import Fonctions.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static Fonctions.MesFonctions.*;

public class HungerGame {
    public static void main(String[] args) {
        //Initialise les variables
        ArrayList<Item> listeItems = initListeItems();
        int jour = 1;

        //Demande le nombre et les joueurs de la partie
        ArrayList<Joueur> listJoueurs = initJoueurs();
















    }

    private static void afficheListeJoueurs() {
    }

    private static ArrayList<Joueur> initJoueurs() {
        //Demande le nombre de joueurs et appelle la fonction qui demande le nom des joueurs
        //Retourne la liste des joueurs
        int choix = 0;
        ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>();
        while (choix < 1 || choix > 3) {
            System.out.println("------ HUNGER GAMES ------");
            System.out.println("Choix du nombre de joueurs :\n ");
            String[] menu = {"24 Tributs", "36 Tributs", "48 Tributs"};
            choix(menu, false);
            choix = saisirInt("Votre choix");

            if (choix == 1) {
                listJoueurs = demandeJoueurs(24);
            } else if (choix == 2) {
                listJoueurs = demandeJoueurs(36);
            } else if (choix == 3) {
                listJoueurs = demandeJoueurs(48);
            } else {
                System.out.println("Erreur de saisie");
            }
        }
        return listJoueurs;
    }

    private static ArrayList<Joueur> demandeJoueurs(int nbr) {
        //Demande le nom et le sexe du joueur
        ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>();
        for (int i = 0; i < nbr; i++){
            String nom = saisirStr("\nNom du joueur");
            String sexe = "";
            while (!sexe.equals("M") && !sexe.equals("F")) {
                sexe = saisirStr("Sexe du joueur (M / F)").toUpperCase();
            }
            listJoueurs.add(new Joueur(nom, sexe));
        }
        return listJoueurs;
    }


    public static ArrayList<Item> initListeItems(){
        ArrayList<Item> listeItems= new ArrayList<Item>();

        listeItems.add(new Item("Arc",2,0));
        listeItems.add(new Item("Epée",5,0));
        listeItems.add(new Item("Bouclier",0,5));
        listeItems.add(new Item("Trident",3,0));

        return listeItems;
    }
}
