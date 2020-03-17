package Events;

import HG.Item;
import HG.ListItems;

import java.util.ArrayList;

public class Day {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public Day(){
        this.listEvent = new ArrayList<>();

        //Event 1

        addEventN(new EventNormal("[Joueur1] vole [Joueur2] alors qu'[il/elle2] ne regarde pas.", 2));

        //Event 2
        addEventN(new EventNormal("[Joueur1] découvre une grotte.", 1));

        //Event 3
        addEventN(new EventNormal("[Joueur1] recherche une source d'eau.",1 ));

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
