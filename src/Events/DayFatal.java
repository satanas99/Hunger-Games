package Events;

import HG.Item;
import HG.ListItems;

import java.util.ArrayList;

public class DayFatal {
    //Attribut
    private ArrayList<EventFatal> listEvent;

    //Constructeur
    public DayFatal(){
        this.listEvent = new ArrayList<>();

        //Event 1
        boolean[] mort = {false,true};
        int[] tuer = {1,0};
        ListItems listItems = new ListItems(new Item("epee"));
        boolean[] quiAItem = {true, false};
        addEventF(new EventFatal("[Joueur1] plante une épee dans la tête de [Joueur2].", 2, mort , tuer, listItems, quiAItem));

        //Event 2
        mort = new boolean[]{false,true};
        tuer = new int[]{1,0};
        addEventF(new EventFatal("[Joueur1] frappe plusieurs fois la tête de [Joueur2] contre un rocher.", 2, mort , tuer));

        //Event 3
        mort = new boolean[]{true};
        tuer = new int[]{0};
        addEventF(new EventFatal("Un pikachu sauvage apparait et attaque tonnere sur [Joueur1]",1 , mort , tuer));


        /*

        //Event
        mort = new boolean[]{};
        tuer = new int[]{};
        addEventF(new EventFatal("", , mort , tuer));
         */


    }

    //Getter
    public ArrayList<EventFatal> getListEvent() {
        return listEvent;
    }

    //Fonctions

    // On ajoute un EventFatal a la liste
    public void addEventF(EventFatal event){
        listEvent.add(event);
    }
}
