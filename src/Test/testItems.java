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

    public static void addKills(ListJoueur ljoueurs,int[] tuer){
        int compt = 0;
        for (int kill:tuer){
            ljoueurs.getJoueur(compt).ajouteKill(kill);
            compt+=1;
        }
    }
}
