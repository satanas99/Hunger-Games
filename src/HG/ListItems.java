package HG;

import java.util.ArrayList;

public class ListItems{
    //Attribut
    private ArrayList<Item> listItems;

    //Constructeur
    public ListItems(){
        this.listItems = new ArrayList<>();
        listItems.add(new Item("Arc",2,0));
        listItems.add(new Item("Epée",5,0));
        listItems.add(new Item("Bouclier",0,5));
        listItems.add(new Item("Trident",3,0));
    }

    //Fonctions
    public void addItem (Item item){
        listItems.add(item);
    }

}
