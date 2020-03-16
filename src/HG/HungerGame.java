package HG;

import Events.*;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static Fonctions.MesFonctions.*;

public class HungerGame {

    //Attibuts
        private ListItems listItems;
        private BloodBath bloodBath;
        private BloodBathFatal bloodBathFatal;
        private Day day;
        private DayFatal dayFatal;
        private Night night;
        private NightFatal nightFatal;
        private ListJoueur listJoueurs,listJoueursD,temporaire;
        private int probaDeathBloodbath, probaDeathDay, probaDeathNight;


        // Constructeur
        public HungerGame() {
            this.listItems = new ListItems();                //Liste des Items
            this.bloodBath = new BloodBath();                //Liste des phrases pour le BloodBath
            this.bloodBathFatal = new BloodBathFatal();      //Liste des phrases pour le BloodBath (Mort)
            this.day = new Day();                            //Liste des phrases pour le Jour
            this.dayFatal = new DayFatal();                  //Liste des phrases pour le Jour (Mort)
            this.night = new Night();                        //Liste des phrases pour la Nuit
            this.nightFatal = new NightFatal();              //Liste des phrases pour la Nuit (Mort)
            this.listJoueurs = initJoueurs();
            this.listJoueursD = new ListJoueur();            //Liste des Joueurs mort
            this.probaDeathBloodbath = 35;
            this.probaDeathDay = 35;
            this.probaDeathNight = 20;

            this.temporaire = new ListJoueur();
        }

    public ListJoueur getTemporaire() {
        return temporaire;
    }

    public ListItems getListItems() {
        return listItems;
    }
    public BloodBath getBloodBath() {
        return bloodBath;
    }
    public BloodBathFatal getBloodBathFatal() {
        return bloodBathFatal;
    }
    public Day getDay() {
        return day;
    }
    public DayFatal getDayFatal() {
        return dayFatal;
    }
    public Night getNight() {
        return night;
    }
    public NightFatal getNightFatal() {
        return nightFatal;
    }
    public ListJoueur getListJoueursD() {
        return listJoueursD;
    }

    //Méthodes
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
                System.out.println("liste pré-defini a 48\n");

                nbPersonnesParDistrict = 48/12;
                listJoueurs = new ListJoueur(true);

//                    nbPersonnesParDistrict = 2;
//                    listJoueurs = new ListJoueur(false);

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
    public Joueur getJoueur(int x){//Retourne le joueur a l'indice x
            return listJoueurs.getJoueur(x);
    }
    public EventFatal getEventFatal(ArrayList<EventFatal> eventsFatal){ //Retourne un eventFatal au hasard d'une liste d'event
            return eventsFatal.get(randomNumber(0,eventsFatal.size()-1));
    }
    public EventNormal getEventNormal(ArrayList<EventNormal> listEvent) {
        return listEvent.get(randomNumber(0,listEvent.size()-1));
    }



    //Simule un BloodBath
    public void bloodBathEvent() {
            ListJoueur temp = listJoueurs;
            temp.shuffle();
            while (temp.getListJoueurs().size()>0){
                int rdm = randomNumber(0,100);
                //temp.shuffle();
                if (rdm < probaDeathBloodbath) {//Si il faut un event death
                    boolean good = false;
                    while (!good){
                        EventFatal event = getEventFatal(bloodBathFatal.getListEvent()); //On recupere un Event au hasard
                        if (event.getNombreTributsImpliquer() <= temp.size()){  //Si le nombre de tribut impliquer dans l'event est plus petit que le nombre qui reste dans la liste

                            //Initialisation de la liste des joueurs impliquer dans l'event
                            ListJoueur listEvent = initEventTeamF(event, temp);

                            //Affiche la phrase
                            System.out.println(event.traduirePhrase(listEvent));

                            //Ajout les stats
                            addKills(listEvent, event.getTuer()); //Ajout des kills
                            if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                                addItems(listEvent,event.getAjouteItem(),event.getListitem());
                            }  //Ajout des Items si il y en a à ajouter
                            addMort(listEvent, event.getMort()); //Ajout de l'etat de mort si le joueur est mort

                            //On met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                            ajouteAListe(listEvent);

                            good = true;
                        }
                    }

                }else{
                    boolean good = false;
                    while (!good){
                        EventNormal event = getEventNormal(bloodBath.getListEvent()); //On recupere un Event au hasard
                        if (event.getNombreTributsImpliquer() <= temp.size()){  //Si le nombre de tribut impliquer dans l'event est plus petit que le nombre qui reste dans la liste

                            //Initialisation de la liste des joueurs impliquer dans l'event
                            ListJoueur listEvent = initEventTeamN(event, temp);

                            //Affiche la phrase
                            System.out.println(event.traduirePhrase(listEvent));

                            //Ajout les stats
                            if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                                addItems(listEvent,event.getAjouteItem(),event.getListitem());
                            }

                            //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                            ajouteAListe(listEvent);

                            good = true;
                        }
                    }
                }
            }

            listJoueurs = temporaire;
        for (int i=0; i<temporaire.getListJoueurs().size();i++) {
            temporaire.removeJoueur(i);
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

    private void addMort(ListJoueur ljoueurs, boolean[] mort) { //Ajoute l'etat de mort sur les Joueurs concerner
        int compt = 0;
        for (Joueur joueur:ljoueurs.getListJoueurs()){
            if (mort[compt]){
                joueur.setMort(true);
            }
            compt+=1;
        }
    }
    public void addItems(ListJoueur ljoueurs, boolean[] item, ListItems list){
        int compt = 0;
        for (Joueur joueur:ljoueurs.getListJoueurs()){
            if (item[compt]){
                joueur.ajouteItems(list);
            }
            compt+=1;
        }
    }
    public void addKills(ListJoueur ljoueurs,int[] tuer){
        int compt = 0;
        for (int kill:tuer){
            ljoueurs.getJoueur(compt).ajouteKill(kill);
            compt+=1;
        }
    }
    public ListJoueur initEventTeamF(EventFatal event, ListJoueur temp){
        ListJoueur listEvent = new ListJoueur();
        for (int i = 0; i < event.getNombreTributsImpliquer();i++){
            listEvent.addJoueur(temp.getJoueur(0));
            temp.removeJoueur(0);
        }
        return listEvent;
    }
    public ListJoueur initEventTeamN(EventNormal event, ListJoueur temp){
        ListJoueur listEvent = new ListJoueur();
        for (int i = 0; i < event.getNombreTributsImpliquer();i++){
            listEvent.addJoueur(temp.getJoueur(0));
            temp.removeJoueur(0);
        }
        return listEvent;
    }
    public void ajouteAListe(ListJoueur listEvent){
        for (Joueur joueur:listEvent.getListJoueurs()) {
            if (joueur.isMort()){
                listJoueursD.addJoueur(joueur);
            }else{
                temporaire.addJoueur(joueur);
            }
        }
    }
}
