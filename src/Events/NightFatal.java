package Events;

import java.util.ArrayList;

public class NightFatal {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public NightFatal(){
        this.listEvent = new ArrayList<>();
    }

    //Getter
    public ArrayList<EventNormal> getListEvent() {
        return listEvent;
    }

    //Fonctions

    // On ajoute un EventFatal a la liste
    public void addEventF(EventNormal event){
        listEvent.add(event);
    }
}
