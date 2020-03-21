package Test;

import Events.BloodBath;
import Events.BloodBathFatal;
import Events.EventFatal;
import Events.EventNormal;
import HG.HungerGame;
import HG.Joueur;
import HG.ListItems;
import HG.ListJoueur;

import static Fonctions.MesFonctions.randomNumber;

public class TestBloodbath {
    public static void main(String[] args) {
        HungerGame hg = new HungerGame();
        ListJoueur temp = hg.getListJoueurs();


        ListJoueur listDesVivant = new ListJoueur();
        ListJoueur listDesMort = new ListJoueur();
        int probaDeath = 45;


        System.out.println();
        while (temp.getListJoueurs().size()>0){
            int rdm = randomNumber(0,100);
            hg.getListJoueurs().shuffle();
            //System.out.println(rdm);
            if (rdm < probaDeath) {//Si il faut un event death
                boolean good = false;
                while (!good){
                    EventFatal event = hg.getEventFatal(hg.getBloodBathFatal().getListEvent()); //On recupere un Event au hasard
                    if (event.getNombreTributsImpliquer() <= hg.getListJoueurs().size()){  //Si le nombre de tribut impliquer dans l'event est plus petit que le nombre qui reste dans la liste
                        //Initialisation des variables pour traiter l'event (liste des joueurs)
                        ListJoueur listEvent = new ListJoueur();
                        for (int i = 0; i < event.getNombreTributsImpliquer();i++){
                            listEvent.addJoueur(temp.getJoueur(0));
                            temp.removeJoueur(0);
                        }

                        //Affiche la phrase
                        System.out.println(event.traduirePhrase(listEvent));

                        //Ajout les stats
                        addKills(listEvent, event.getTuer());
                        if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                            addItems(listEvent,event.getQuiAItem(),event.getListitem());
                        }
                        addMort(listEvent, event.getMort());

                        //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                        for (Joueur joueur:listEvent.getListJoueurs()) {
                            if (joueur.isMort()){
                                listDesMort.addJoueur(joueur);
                            }else{
                                listDesVivant.addJoueur(joueur);
                            }
                        }
                        good = true;
                    }
                }

            }else{
                boolean good = false;
                while (!good){
                    EventNormal event = hg.getEventNormal(hg.getBloodBath().getListEvent()); //On recupere un Event au hasard
                    if (event.getNombreTributsImpliquer() <= hg.getListJoueurs().size()){  //Si le nombre de tribut impliquer dans l'event est plus petit que le nombre qui reste dans la liste

                        //Initialisation des variables pour traiter l'event (liste des joueurs)
                        ListJoueur listEvent = new ListJoueur();
                        for (int i = 0; i < event.getNombreTributsImpliquer();i++){
                            listEvent.addJoueur(temp.getJoueur(0));
                            temp.removeJoueur(0);
                        }

                        //Affiche la phrase
                        System.out.println(event.traduirePhrase(listEvent));

                        //Ajout les stats
                        if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
                            addItems(listEvent,event.getQuiAItem(),event.getListitem());
                        }


                        //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
                        for (Joueur joueur:listEvent.getListJoueurs()) {
                            if (joueur.isMort()){
                                listDesMort.addJoueur(joueur);
                            }else{
                                listDesVivant.addJoueur(joueur);
                            }
                        }

                        good = true;
                    }
                }
            }
        }
        System.out.println("\n##########################################\nJoueur Vivant :");
        listDesVivant.afficheJoueurs();
        System.out.println("\n##########################################\nJoueur Mort :");
        listDesMort.afficheJoueurs();
        System.out.println("\nTotal Joueurs : " + (listDesMort.getListJoueurs().size()+listDesVivant.getListJoueurs().size()));
    }

    private static void addMort(ListJoueur ljoueurs, boolean[] mort) { //Ajoute l'etat de mort sur les Joueurs concerner
        int compt = 0;
        for (Joueur joueur:ljoueurs.getListJoueurs()){
            if (mort[compt]){
                joueur.setMort(true);
            }
            compt+=1;
        }
    }
    public static void addItems(ListJoueur ljoueurs, boolean[] item, ListItems list){
        int compt = 0;
        for (Joueur joueur:ljoueurs.getListJoueurs()){
            if (item[compt]){
                joueur.ajouteItems(list);
            }
            compt+=1;
        }
    }
    public static void addKills(ListJoueur ljoueurs,int[] tuer){
        int compt = 0;
        for (int kill:tuer){
            ljoueurs.getJoueur(compt).ajouteKill(kill);
            compt+=1;
        }
    }


}
