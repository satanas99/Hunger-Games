package Events;

import HG.Item;
import HG.ListItems;

import java.util.ArrayList;



public class BloodBath {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public BloodBath(){
        this.listEvent = new ArrayList<>();

        //Event 1
        addEventN(new EventNormal("[Joueur1] s'enfuis de la corne d'abondance", 1));

        //Event 2
        ListItems listItems = new ListItems(new Item("bouclier"));
        addEventN(new EventNormal("[Joueur1] attrape un bouclier appuyé sur la corne d'abondance.", 1,listItems));

        //Event 3
        listItems = new ListItems();
        listItems.addItem(new Item("explosif"));

        addEventN(new EventNormal("[Joueur1] trouve un sac plein d'explosifs.", 1));

        /*
        //Event
        addEventN(new EventNormal("", ));
         */

    }

    //Getter
    public ArrayList<EventNormal> getListEvent() {
        return listEvent;
    }

    //Fonctions

    // On ajoute un EventNormal a la liste
    public void addEventN(EventNormal event){
        listEvent.add(event);
    }
}
