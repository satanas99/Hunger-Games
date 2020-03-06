package Events;

import java.util.ArrayList;



public class BloodBath {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public BloodBath(){
        this.listEvent = new ArrayList<>();
        listEvent.add(new EventNormal("(Joueur1) s'enfuis", 1));
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
