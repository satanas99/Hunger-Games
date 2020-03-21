package Events;

import HG.Item;

import java.util.ArrayList;

public class NightFatal {
    //Attribut
    private ArrayList<EventFatal> listEvent;

    //Constructeur
    public NightFatal(){
        this.listEvent = new ArrayList<>();

        //Event 1
        boolean[] mort = new boolean[]{false,true};
        int[] tuer = new int[]{1,0};
        addEventF(new EventFatal("[Joueur1] empoisonne la nourriture de [Joueur2], [le/la2] tuant.", 2, mort , tuer));

        //Event 2
        mort = new boolean[]{true};
        tuer = new int[]{0};
        addEventF(new EventFatal("[Joueur1] meurt à cause de blessures non traitées.", 1, mort , tuer));

        //Event 3
        mort = new boolean[]{false,true};
        tuer = new int[]{1,0};
        addEventF(new EventFatal("[Joueur1] tue [Joueur2] pendant qu'[il/elle2] dort.", 2, mort , tuer));


        //Event 4
        mort = new boolean[]{false, true, true, true};
        tuer = new int[]{3,0,0,0};
        boolean[] whoNeedItem = {true, false, false, false};
        Item itemNeed = new Item("explosif");
        addEventF(new EventFatal("[Joueur1] place un explosif est tue [Joueur2], [Joueur3] et [Joueur4]",4 , mort , tuer,itemNeed,whoNeedItem));


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
