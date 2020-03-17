package Events;

import HG.Item;
import HG.ListItems;

import java.util.ArrayList;

public class BloodBathFatal {
    //Attribut
    private ArrayList<EventFatal> listEvent;

    //Constructeur
    public BloodBathFatal(){
        this.listEvent = new ArrayList<>();

        //Event 1
        boolean[] mort = new boolean[]{true};
        int[] tuer = new int[]{0};
        addEventF(new EventFatal("[Joueur1] descend trop tôt de son podium et explose.",1 , mort , tuer));

        //Event 2
        mort = new boolean[]{false, true};
        tuer = new int[]{1,0};
        ListItems listItems = new ListItems(new Item("epee"));
        addEventF(new EventFatal("[Joueur1] prend une épée et décapite [Joueur2] avec une épée.", 2, mort , tuer));

        //Event 3
        mort = new boolean[]{true};
        tuer = new int[]{0};
        addEventF(new EventFatal("[Joueur1] tombe dans une fosse et meurt.", 1, mort , tuer));

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
