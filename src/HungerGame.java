import HG.*;

import java.util.ArrayList;
import java.util.List;

import static Fonctions.MesFonctions.*;

/*
Basé sur le site : https://brantsteele.net/hungergames/

Partie custom pour essayer : http://brantsteele.net/hungergames/r.php?c=FMuMPYaE
 */






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
        int nbPersonnesParDistrict = 0;
        ListJoueur listJoueurs = new ListJoueur();
        while (choix < 1 || choix > 5) {
            System.out.println("------ HUNGER GAMES ------");
            System.out.println("Choix du nombre de joueurs :\n ");
            String[] menu = {"24 Tributs", "36 Tributs", "48 Tributs"};
            choix(menu, false);
            choix = saisirInt("Votre choix");

            if (choix == 1) {
                nbPersonnesParDistrict = 24/12;
                listJoueurs = demandeJoueurs(24);
            } else if (choix == 2) {
                nbPersonnesParDistrict = 36/12;
                listJoueurs = demandeJoueurs(36);
            } else if (choix == 3) {
                nbPersonnesParDistrict = 48/12;
                listJoueurs = demandeJoueurs(48);
            } else if (choix == 4) {
                nbPersonnesParDistrict = 2;
                listJoueurs = demandeJoueurs(4);
            } else if (choix == 5) {
                System.out.println("liste pré-defini a 24");
                nbPersonnesParDistrict = 24/12;
                listJoueurs = new ListJoueur(true);
            }else {
                System.out.println("Erreur de saisie");
            }
        }
        listJoueurs = setDistrict(nbPersonnesParDistrict, listJoueurs);
        return listJoueurs;
    }

    private static ListJoueur setDistrict(int nbPersonnesDistrict, ListJoueur listJoueurs) {
        ListJoueur res = new ListJoueur();
        listJoueurs.shuffle();
        int district = 1;
        while (listJoueurs.size()>0){
            for (int i = 0; i<nbPersonnesDistrict;i++){
                res.addJoueur(listJoueurs.getLastJoueur());
                Joueur j1 = res.getLastJoueur();
                res.getLastJoueur().addDistrict(district);
                listJoueurs.supprLastJoueur();
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
            //System.out.println("Nom : " + listJoueurs.getJoueur(i).getNom() + "  Sexe : " + listJoueurs.getJoueur(i).getSexe() + "  District : " + listJoueurs.getJoueur(i).getDistrict());
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
