package HG;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;

public class ListItems{
    //Attribut
    private ArrayList<Item> listItems;


    //Constructeur
    public ListItems(){
        this.listItems = new ArrayList<>();
/*        listItems.add(new Item("Arc",2,0));
        listItems.add(new Item("Epée",5,0));
        listItems.add(new Item("Bouclier",0,5));
        listItems.add(new Item("Trident",3,0));*/
    }
    public ListItems(Item item){
        this.listItems = new ArrayList<>();
        this.listItems.add(item);
    }

    //Fonctions
    public void addItem (Item item){
        listItems.add(item);
    }

    public int size(){return listItems.size();}

    public ArrayList<Item> getListItems() {
        return listItems;
    }

    public Item get(int x) {
        return listItems.get(x);
    }

    public void remove(int x) {
        listItems.remove(x);
    }
}
