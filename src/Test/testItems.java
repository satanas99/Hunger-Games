package Test;

import Events.EventFatal;
import HG.Item;
import HG.Joueur;
import HG.ListItems;
import HG.ListJoueur;

public class testItems {
        public static void main(String[] args) {
            ListJoueur ljoueurs = new ListJoueur();
            ljoueurs.addJoueur( new Joueur("Toto","M"));
            ljoueurs.addJoueur( new Joueur("Tata","F"));
            //ljoueurs.addJoueur( new Joueur("Titi","M"));
            boolean[] mort = {false,true};
            int[] tuer = {1,0};

            ListItems list = new ListItems();
            list.addItem(new Item("Epée", 5,5));

            boolean[] item = {true, false};
            EventFatal event = new EventFatal("[Joueur1] trouve une épée et décapite [Joueur2].", 2, mort , tuer, list,item);

            String phrase = event.traduirePhrase(ljoueurs);
            addKills(ljoueurs, tuer);
            addItems(ljoueurs, event.getAjouteItem(), event.getListitem());
            addMort(ljoueurs,event.getMort());
            System.out.println(event.getPhrase());

            System.out.println("\n" + phrase + "\n");
            ljoueurs.afficheJoueurs();
            ljoueurs.afficheItems();

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
    private static void addMort(ListJoueur ljoueurs, boolean[] mort) { //Ajoute l'etat de mort sur les Joueurs concerner
        int compt = 0;
        for (Joueur joueur:ljoueurs.getListJoueurs()){
            if (mort[compt]){
                joueur.setMort(true);
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


////Simule un BloodBath
//    public void bloodBathEvent() {
//            ListJoueur temp = listJoueurs;
//        while (temp.getListJoueurs().size()>0){
//            System.out.println("temp : "+ temp.size());
//            int rdm = randomNumber(0,100);
//            listJoueurs.shuffle();
//            if (rdm < probaDeathBloodbath) {//Si il faut un event death
//                boolean good = false;
//                while (!good){
//                    EventFatal event = getEventFatal(bloodBathFatal.getListEvent()); //On recupere un Event au hasard
//                    if (event.getNombreTributsImpliquer() <= listJoueurs.size()){  //Si le nombre de tribut impliquer dans l'event est plus petit que le nombre qui reste dans la liste
//                        //Initialisation des variables pour traiter l'event (liste des joueurs)
//                        ListJoueur listEvent = new ListJoueur();
//                        for (int i = 0; i < event.getNombreTributsImpliquer();i++){
//                            listEvent.addJoueur(temp.getJoueur(0));
//                            temp.removeJoueur(0);
//                        }
//
//                        //Affiche la phrase
//                        System.out.println(event.traduirePhrase(listEvent));
//
//                        //Ajout les stats
//                        addKills(listEvent, event.getTuer());
//                        if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
//                            addItems(listEvent,event.getAjouteItem(),event.getListitem());
//                        }
//                        addMort(listEvent, event.getMort());
//
//                        //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
//                        for (Joueur joueur:listEvent.getListJoueurs()) {
//                            if (joueur.isMort()){
//                                listJoueursD.addJoueur(joueur);
//                            }else{
//                                listJoueurs.addJoueur(joueur);
//                            }
//                        }
//                        good = true;
//                    }
//                }
//
//            }else{
//                boolean good = false;
//                while (!good){
//                    EventNormal event = getEventNormal(bloodBath.getListEvent()); //On recupere un Event au hasard
//                    if (event.getNombreTributsImpliquer() <= listJoueurs.size()){  //Si le nombre de tribut impliquer dans l'event est plus petit que le nombre qui reste dans la liste
//
//                        //Initialisation des variables pour traiter l'event (liste des joueurs)
//                        ListJoueur listEvent = new ListJoueur();
//                        for (int i = 0; i < event.getNombreTributsImpliquer();i++){
//                            listEvent.addJoueur(temp.getJoueur(0));
//                            temp.removeJoueur(0);
//                        }
//
//                        //Affiche la phrase
//                        System.out.println(event.traduirePhrase(listEvent));
//
//                        //Ajout les stats
//                        if (event.getListitem().size() > 0){ //Si il y a des Items a ajouter
//                            addItems(listEvent,event.getAjouteItem(),event.getListitem());
//                        }
//                        //on met les joueurs dans leurs liste en fonction de leur Etat (mort ou non)
//                        for (Joueur joueur:listEvent.getListJoueurs()) {
//                            if (joueur.isMort()){
//                                listJoueursD.addJoueur(joueur);
//                            }else{
//                                listJoueurs.addJoueur(joueur);
//                            }
//                        }
//                        good = true;
//                    }
//                }
//            }
//        }
//    }