package Events;

import java.util.ArrayList;

public class Night {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public Night(){
        this.listEvent = new ArrayList<>();
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
