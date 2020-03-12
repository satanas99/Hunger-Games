package Events;

import java.util.ArrayList;

public class DayFatal {
    //Attribut
    private ArrayList<EventNormal> listEvent;

    //Constructeur
    public DayFatal(){
        this.listEvent = new ArrayList<>();

        boolean[] mort = {false,true,true};
        int[] tuer = {2,0,0};
        listEvent.addEventF(new EventFatal("[Joueur1] combat [Joueur2] et [Joueur3]. [il/elle1] les tue.", 3, mort , tuer));
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
