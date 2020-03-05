import HG.*;

import java.util.ArrayList;
import java.util.List;

import static Fonctions.MesFonctions.*;

public class HungerGame {
    public static void main(String[] args) {
        //Initialise les variables
        ListItems listeItems = initListeItems();
        int jour = 1;

        //Demande le nombre et les joueurs de la partie
         ListJoueur listJoueurs = initJoueurs();
         listJoueurs.afficheJoueurs();









    }

    private static void afficheListeJoueurs() {
    }

    private static ListJoueur initJoueurs() {
        //Demande le nombre de joueurs et appelle la fonction qui demande le nom des joueurs
        //Et initilise les districts aléatoirement
        //Retourne la liste des joueurs
        int choix = 0;
        int nbPersonnesDistrict = 0;
        ListJoueur listJoueurs = new ListJoueur();
        while (choix < 1 || choix > 4) {
            System.out.println("------ HUNGER GAMES ------");
            System.out.println("Choix du nombre de joueurs :\n ");
            String[] menu = {"24 Tributs", "36 Tributs", "48 Tributs"};
            choix(menu, false);
            choix = saisirInt("Votre choix");

            if (choix == 1) {
                nbPersonnesDistrict = 24/12;
                listJoueurs = demandeJoueurs(24);
            } else if (choix == 2) {
                nbPersonnesDistrict = 36/12;
                listJoueurs = demandeJoueurs(36);
            } else if (choix == 3) {
                nbPersonnesDistrict = 48/12;
                listJoueurs = demandeJoueurs(48);
            } else if (choix == 4) {
                nbPersonnesDistrict = 2;
                listJoueurs = demandeJoueurs(4);
            } else {
                System.out.println("Erreur de saisie");
            }
        }
        listJoueurs = setDistrict(nbPersonnesDistrict, listJoueurs);
        return listJoueurs;
    }

    private static ListJoueur setDistrict(int nbPersonnesDistrict, ListJoueur listJoueurs) {
        ListJoueur res = new ListJoueur();
        listJoueurs.shuffle();
        int district = 1;

        while (listJoueurs.size()>0){
            for (int i = 0; i<nbPersonnesDistrict;i++){
                res.addJoueur(listJoueurs.getJoueur(i));
                Joueur j1 = res.getJoueur(i);
                res.getJoueur(i).addDistrict(district);
            }
            district += 1;
        }
        return res;
    }

    private static ListJoueur demandeJoueurs(int nbr) {
        //Demande le nom et le sexe du joueur
        ListJoueur listJoueurs = new ListJoueur();
        for (int i = 0; i < nbr; i++){
            String nom = saisirStr("\nNom du joueur");
            String sexe = "";
            while (!sexe.equals("M") && !sexe.equals("F")) {
                sexe = saisirStr("Sexe du joueur (M / F)").toUpperCase();
            }
            listJoueurs.addJoueur(new Joueur(nom, sexe));
        }
        return listJoueurs;
    }


    private static ListItems initListeItems(){
        ListItems listItems = new ListItems();
        listItems.addItem(new Item("Arc",2,0));
        listItems.addItem(new Item("Epée",5,0));
        listItems.addItem(new Item("Bouclier",0,5));
        listItems.addItem(new Item("Trident",3,0));

        return listItems;
    }
}
