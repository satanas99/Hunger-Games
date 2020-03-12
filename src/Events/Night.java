package Events;

import java.util.ArrayList;

public class Night {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public Night(){
        this.listEvent = new ArrayList<>();

        //Event 1
        addEventN(new EventNormal("[Joueur1] allume un feu.",1 ));

        //Event 2
        addEventN(new EventNormal("[Joueur1] grimpe à un arbre pour se reposer.", 1));

        //Event 3
        addEventN(new EventNormal("[Joueur1] et [Joueur2] se racontent des histoires",2 ));

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
