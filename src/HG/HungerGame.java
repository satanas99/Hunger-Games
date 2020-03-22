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
        ListJoueur liste = listJoueurs;

        ListJoueur listeVivant = new ListJoueur();
        while (liste.size() > 0){
            int rdm = randomNumber(0,100);
            liste.shuffle();
            if (rdm < probaDeathBloodbath){
                EventFatal event = getEventFatal(bloodBathFatal.getListEvent()); //On recupere un Event au hasard

                if (event.getNombreTributsImpliquer() <= liste.getListJoueurs().size()){ //On regarde si il reste asser de joueurs a impliquer dans l'event
                    ListJoueur joueursImpliquer = new ListJoueur();
                    for (int i = 0; i < event.getNombreTributsImpliquer();i++){
                        joueursImpliquer.addJoueur(liste.getJoueur(0)); //On ajoute a la liste des joueurs impliquer le premier joueur de la liste des joueurs restants
                        liste.removeJoueur(0); //On supprime le premier joueur de la liste des joueurs restant
                    }

                    //Affiche la phrase
                    System.out.print("==> ");
                    System.out.println(event.traduirePhrase(joueursImpliquer));

                    //Ajout les stats
                    addKills(joueursImpliquer, event.getTuer());
                    if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                        addItems(joueursImpliquer,event.getQuiAItem(),event.getListitem());
                    }
                    addMort(joueursImpliquer, event.getMort());

                    //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                    for (Joueur joueur:joueursImpliquer.getListJoueurs()) {
                        if (joueur.isMort()){
                            listJoueursD.addJoueur(joueur);
                        }else{
                            listeVivant.addJoueur(joueur);
                        }
                    }
                }
            }else{
                EventNormal event = getEventNormal(bloodBath.getListEvent()); //On recupere un Event au hasard

                if (event.getNombreTributsImpliquer() <= liste.getListJoueurs().size()){ //On regarde si il reste asser de joueurs a impliquer dans l'event
                    ListJoueur joueursImpliquer = new ListJoueur();
                    for (int i = 0; i < event.getNombreTributsImpliquer();i++){
                        joueursImpliquer.addJoueur(liste.getJoueur(0)); //On ajoute a la liste des joueurs impliquer le premier joueur de la liste des joueurs restants
                        liste.removeJoueur(0); //On supprime le premier joueur de la liste des joueurs restant
                    }

                    //Affiche la phrase
                    System.out.print("==> ");
                    System.out.println(event.traduirePhrase(joueursImpliquer));

                    //Ajout les stats
                    if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter et que le joueur n'a pas deja l'Item
                        addItems(joueursImpliquer,event.getQuiAItem(),event.getListitem());
                    }


                    //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                    for (Joueur joueur:joueursImpliquer.getListJoueurs()) {
                        if (joueur.isMort()){
                            listJoueursD.addJoueur(joueur);
                        }else{
                            listeVivant.addJoueur(joueur);
                        }
                    }
                }
            }
        }
        listJoueurs = listeVivant;
    }


    //Simule un jour
    public void dayEvent() {
        ListJoueur liste = listJoueurs;
        ListJoueur listeVivant = new ListJoueur();
        while (liste.size() > 0){
            int rdm = randomNumber(0,100);
            liste.shuffle();
            ListJoueur listbackup = setBackupList(liste);
            if (rdm < probaDeathDay){
                boolean peuxUseEvent = false;
                ListJoueur joueursImpliquer = new ListJoueur();
                EventFatal event = getEventFatal(dayFatal.getListEvent()); //On recupere un Event au hasard
                while(!peuxUseEvent) {
                    joueursImpliquer = new ListJoueur();
                    liste = setBackupList(listbackup);
                    event = getEventFatal(dayFatal.getListEvent()); //On recupere un Event au hasard
                    if (event.getNombreTributsImpliquer() <= liste.getListJoueurs().size()) { //On regarde si il reste asser de joueurs a impliquer dans l'event
                        for (int i = 0; i < event.getNombreTributsImpliquer(); i++) {
                            joueursImpliquer.addJoueur(liste.getJoueur(0)); //On ajoute a la liste des joueurs impliquer le premier joueur de la liste des joueurs restants
                            liste.removeJoueur(0); //On supprime le premier joueur de la liste des joueurs restant
                        }


                        if (event.isRequiert()) {//Si un joueur a besoin d'un Item pour afficher la phrase
                            int compt = 0;
                            boolean possedeItem = false;
                            for (Joueur joueur : joueursImpliquer.getListJoueurs()) {
                                if (event.getWhoNeedItem()[compt]) {
                                    for (Item item : joueur.getSac().getListItems()) {
                                        if (item.getNom().equals(event.getItemNeed().getNom())) {
                                            possedeItem = true;
                                        }
                                    }
                                }
                                compt += 1;
                            }
                            if (possedeItem) {
                                peuxUseEvent = true;
                            }
                        } else {
                            peuxUseEvent = true;
                        }
                    }
                }


                    //Affiche la phrase

                    System.out.print("==> ");
                    System.out.println(event.traduirePhrase(joueursImpliquer));

                    //Ajout les stats
                    addKills(joueursImpliquer, event.getTuer());
                    if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                        addItems(joueursImpliquer,event.getQuiAItem(),event.getListitem());
                    }
                    addMort(joueursImpliquer, event.getMort());

                    //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                    for (Joueur joueur:joueursImpliquer.getListJoueurs()) {
                        if (joueur.isMort()){
                            listJoueursD.addJoueur(joueur);
                        }else{
                            listeVivant.addJoueur(joueur);
                        }
                    }

            }else{
                boolean peuxUseEvent = false;
                ListJoueur joueursImpliquer = new ListJoueur();
                EventNormal event = getEventNormal(day.getListEvent()); //On recupere un Event au hasard
                while(!peuxUseEvent) {
                    joueursImpliquer = new ListJoueur();
                    liste = setBackupList(listbackup);
                    event = getEventNormal(day.getListEvent()); //On recupere un Event au hasard
                    if (event.getNombreTributsImpliquer() <= liste.getListJoueurs().size()) { //On regarde si il reste asser de joueurs a impliquer dans l'event

                        for (int i = 0; i < event.getNombreTributsImpliquer(); i++) {
                            joueursImpliquer.addJoueur(liste.getJoueur(0)); //On ajoute a la liste des joueurs impliquer le premier joueur de la liste des joueurs restants
                            liste.removeJoueur(0); //On supprime le premier joueur de la liste des joueurs restant
                        }
                        if (event.isRequiert()) {//Si un joueur a besoin d'un Item pour afficher la phrase
                            int compt = 0;
                            boolean possedeItem = false;
                            for (Joueur joueur : joueursImpliquer.getListJoueurs()) {
                                if (event.getWhoNeedItem()[compt]) {
                                    for (Item item : joueur.getSac().getListItems()) {
                                        if (item.getNom().equals(event.getItemNeed().getNom())) {
                                            possedeItem = true;
                                            break;
                                        }
                                    }
                                }
                                compt += 1;
                            }
                            if (possedeItem) {
                                peuxUseEvent = true;
                            }
                        } else {
                            peuxUseEvent = true;
                        }
                    }
                }

                    //Affiche la phrase
                    System.out.print("==> ");
                    System.out.println(event.traduirePhrase(joueursImpliquer));

                    //Ajout les stats
                    if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                        addItems(joueursImpliquer,event.getQuiAItem(),event.getListitem());
                    }

                    //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                    for (Joueur joueur:joueursImpliquer.getListJoueurs()) {
                        if (joueur.isMort()){
                            listJoueursD.addJoueur(joueur);
                        }else{
                            listeVivant.addJoueur(joueur);
                        }
                    }
                }
            }
        listJoueurs = listeVivant;
        }


    //Simule une nuit
    public void nightEvent() {

        ListJoueur liste = listJoueurs;
        ListJoueur listeVivant = new ListJoueur();

        while (liste.size() > 0){
            int rdm = randomNumber(0,100);
            liste.shuffle();
            ListJoueur listbackup = setBackupList(liste);
            if (rdm < probaDeathNight){
                boolean peuxUseEvent = false;
                ListJoueur joueursImpliquer = new ListJoueur();
                EventFatal event = getEventFatal(nightFatal.getListEvent()); //On recupere un Event au hasard
                while(!peuxUseEvent) {
                    joueursImpliquer = new ListJoueur();
                    liste = setBackupList(listbackup);
                    event = getEventFatal(nightFatal.getListEvent()); //On recupere un Event au hasard
                    if (event.getNombreTributsImpliquer() <= liste.getListJoueurs().size()) { //On regarde si il reste asser de joueurs a impliquer dans l'event

                        for (int i = 0; i < event.getNombreTributsImpliquer(); i++) {
                            joueursImpliquer.addJoueur(liste.getJoueur(0)); //On ajoute a la liste des joueurs impliquer le premier joueur de la liste des joueurs restants
                            liste.removeJoueur(0); //On supprime le premier joueur de la liste des joueurs restant
                        }

                        if (event.isRequiert()) {//Si un joueur a besoin d'un Item pour afficher la phrase
                            int compt = 0;
                            boolean possedeItem = false;
                            for (Joueur joueur : joueursImpliquer.getListJoueurs()) {
                                if (event.getWhoNeedItem()[compt]) {
                                    for (Item item : joueur.getSac().getListItems()) {
                                        if (item.getNom().equals(event.getItemNeed().getNom())) {
                                            possedeItem = true;
                                            break;
                                        }
                                    }
                                }
                                compt += 1;
                            }
                            if (possedeItem) {
                                peuxUseEvent = true;
                            }
                        } else {
                            peuxUseEvent = true;
                        }
                    }
                }

                    //Affiche la phrase
                    System.out.print("==> ");
                    System.out.println(event.traduirePhrase(joueursImpliquer));

                    //Ajout les stats
                    addKills(joueursImpliquer, event.getTuer());
                    if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                        addItems(joueursImpliquer,event.getQuiAItem(),event.getListitem());
                    }
                    addMort(joueursImpliquer, event.getMort());

                    //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                    for (Joueur joueur:joueursImpliquer.getListJoueurs()) {
                        if (joueur.isMort()){
                            listJoueursD.addJoueur(joueur);
                        }else{
                            listeVivant.addJoueur(joueur);
                        }
                    }

            }else{
                boolean peuxUseEvent = false;
                ListJoueur joueursImpliquer = new ListJoueur();
                EventNormal event = getEventNormal(night.getListEvent()); //On recupere un Event au hasard
                while(!peuxUseEvent) {
                    joueursImpliquer = new ListJoueur();
                    liste = setBackupList(listbackup);
                    event = getEventNormal(night.getListEvent()); //On recupere un Event au hasard
                    if (event.getNombreTributsImpliquer() <= liste.getListJoueurs().size()) { //On regarde si il reste asser de joueurs a impliquer dans l'event

                        for (int i = 0; i < event.getNombreTributsImpliquer(); i++) {
                            joueursImpliquer.addJoueur(liste.getJoueur(0)); //On ajoute a la liste des joueurs impliquer le premier joueur de la liste des joueurs restants
                            liste.removeJoueur(0); //On supprime le premier joueur de la liste des joueurs restant
                        }
                        if (event.isRequiert()) {//Si un joueur a besoin d'un Item pour afficher la phrase
                            int compt = 0;
                            boolean possedeItem = false;
                            for (Joueur joueur : joueursImpliquer.getListJoueurs()) {
                                if (event.getWhoNeedItem()[compt]) {
                                    for (Item item : joueur.getSac().getListItems()) {
                                        if (item.getNom().equals(event.getItemNeed().getNom())) {
                                            possedeItem = true;
                                            break;
                                        }
                                    }
                                }
                                compt += 1;
                            }
                            if (possedeItem) {
                                peuxUseEvent = true;
                            }
                        } else {
                            peuxUseEvent = true;
                        }
                    }
                }

                    //Affiche la phrase
                    System.out.print("==> ");
                    System.out.println(event.traduirePhrase(joueursImpliquer));

                    //Ajout les stats
                    if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                        addItems(joueursImpliquer,event.getQuiAItem(),event.getListitem());
                    }


                    //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                    for (Joueur joueur:joueursImpliquer.getListJoueurs()) {
                        if (joueur.isMort()){
                            listJoueursD.addJoueur(joueur);
                        }else{
                            listeVivant.addJoueur(joueur);
                        }
                    }
                }
            }
        listJoueurs = listeVivant;
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

    public void addItems(ListJoueur ljoueurs, boolean[] quiAItem, ListItems list){
        int compt = 0;
        boolean estDansSac = false;
        for (Joueur joueur:ljoueurs.getListJoueurs()){
            if (quiAItem[compt]){ //On regarde si le joueur peux avoir l'item
                for (Item item:list.getListItems()) { //On prend chaque item que l'on veux add
                    for (Item itemJoueur:joueur.getSac().getListItems()) { //On prend chaque items du joueur et on test si il possède deja l'item que l'on veux add
                        if (itemJoueur.getNom().equals(item.getNom())) {
                            estDansSac = true;
                            break;
                        }
                    }
                    if (!estDansSac){
                        joueur.ajouteItem(item);
                    }
                }
            }
            compt+=1;
        }
    }
    public ListJoueur setBackupList(ListJoueur liste) {
        ListJoueur listeBackup = new ListJoueur();
        for (Joueur joueur: liste.getListJoueurs()) {
            listeBackup.addJoueur(joueur);
        }
        return listeBackup ;
    }


    public void addKills(ListJoueur ljoueurs,int[] tuer){
        int compt = 0;
        for (int kill:tuer){
            ljoueurs.getJoueur(compt).ajouteKill(kill);
            compt+=1;
        }
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
