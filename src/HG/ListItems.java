package HG;

import java.util.ArrayList;

public class ListItems extends ArrayList {
    //Attribut
    private ArrayList<Item> listItems;

    //Constructeur
    public ListItems(){
        this.listItems = new ArrayList<>();
    }

    //Fonctions
    public void addItem (Item item){
        listItems.add(item);
    }

}
