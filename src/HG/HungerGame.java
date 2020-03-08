package HG;

import Events.*;

import static Fonctions.MesFonctions.*;

/*
Basé sur le site : https://brantsteele.net/hungergames/

Partie custom pour essayer : http://brantsteele.net/hungergames/r.php?c=FMuMPYaE
 */






public class HungerGame {

    //Attibuts
        private ListItems listItems;
        private BloodBath bloodBath;
        private BloodBathFatal bloodBathFatal;
        private Day day;
        private DayFatal dayFatal;
        private Night night;
        private NightFatal nightFatal;
        private ListJoueur listJoueurs;


        // Constructeur
        public HungerGame() {
            listItems = new ListItems();                //Liste des Items
            bloodBath = new BloodBath();                //Liste des phrases pour le BloodBath
            bloodBathFatal = new BloodBathFatal();      //Liste des phrases pour le BloodBath (Mort)
            day = new Day();                            //Liste des phrases pour le Jour
            dayFatal = new DayFatal();                  //Liste des phrases pour le Jour (Mort)
            night = new Night();                        //Liste des phrases pour la Nuit
            nightFatal = new NightFatal();              //Liste des phrases pour la Nuit (Mort)
            listJoueurs = initJoueurs();
        }


    public ListJoueur initJoueurs() {
        //Demande le nombre de joueurs et appelle la fonction qui demande le nom des joueurs
        //Et initilise les districts aléatoirement
        //Retourne la liste des joueurs
        int choix = 0;
        int nbPersonnesParDistrict = 0;
        listJoueurs = new ListJoueur();
        while (choix < 1 || choix > 5) {
            System.out.println("------ HUNGER GAMES ------");
            System.out.println("Choix du nombre de joueurs :\n ");
            String[] menu = {"24 Tributs", "36 Tributs", "48 Tributs", "Test Avec Liste Définie"};
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

    public ListJoueur getListJoueurs(){
            return listJoueurs;
    }

    public ListJoueur setDistrict(int nbPersonnesDistrict, ListJoueur listJoueurs) {
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


    public ListJoueur demandeJoueurs(int nbr) {
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
    //Retourne le joueur a l'indice x
    public Joueur getJoueur(int x){
            return listJoueurs.getJoueur(x);
    }
        //Simule un BloodBath
    public void bloodBathEvent() {

            ListJoueur liste = listJoueurs;


            while (liste.size()>0){


            }
    }

    //Simule un jour
    public void dayEvent() {

        ListJoueur liste = listJoueurs;


        while (liste.size()>0){


        }
    }

    //Simule une nuit
    public void nightEvent() {

        ListJoueur liste = listJoueurs;


        while (liste.size()>0){


        }
    }


}
