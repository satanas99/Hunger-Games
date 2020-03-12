package Events;

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
        addEventF(new EventFatal("[Joueur1] plante un couteau dans la tête de [Joueur2].", 2, mort , tuer));

        //Event
        mort = new boolean[]{};
        tuer = new int[]{};
        addEventF(new EventFatal("", 3, mort , tuer));





        /*

        //Event
        mort = new boolean[]{};
        tuer = new int[]{};
        addEventF(new EventFatal("", 3, mort , tuer));
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
