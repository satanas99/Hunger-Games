package Events;

import HG.Item;
import HG.ListItems;
import HG.ListJoueur;

public class EventNormal {
    //Attribut
    private String phrase;
    private int nombreTributsImpliquer;

    private ListItems listitem; //Liste des items qui peuvent être ajouter
    private boolean[] quiAItem; //Pour determiner a qui appartient l'item pour savoir si on affiche la phrase

    private boolean requiert; //permet de savoir si il y a besoin d'un item
    private Item itemNeed; //Item qui est demander sur certaines phrases
    private boolean[] whoNeedItem; //Pour determiner qui a besoin de l'item pour afficher la phrase

    //Constructeur
    public EventNormal(String phrase, int nombreTributImpliquer){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
        this.listitem =new ListItems();
        this.quiAItem = new boolean[0];
        this.itemNeed = new Item("void");
        this.whoNeedItem = new boolean[0];
        this.requiert = false;
    }

    public EventNormal(String phrase, int nombreTributImpliquer,ListItems listitem,boolean[] quiAItem){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
        this.listitem =listitem;
        this.quiAItem = quiAItem;
        this.requiert = false;
        this.itemNeed = new Item("void");
        this.whoNeedItem = new boolean[0];
    }

    public EventNormal(String phrase, int nombreTributImpliquer, Item itemNeed, boolean[] whoNeedItem){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
        this.listitem =new ListItems();
        this.quiAItem = new boolean[0];
        this.itemNeed = itemNeed;
        this.whoNeedItem = whoNeedItem;
        this.requiert = true;
    }

    public EventNormal(String phrase, int nombreTributImpliquer,ListItems listitem,boolean[] quiAItem, Item itemNeed, boolean[] whoNeedItem){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
        this.listitem =listitem;
        this.quiAItem = quiAItem;
        this.itemNeed = itemNeed;
        this.whoNeedItem = whoNeedItem;
        this.requiert = true;
    }

    public Item getItemNeed() {
        return itemNeed;
    }
    public boolean[] getWhoNeedItem() {
        return whoNeedItem;
    }
    public boolean isRequiert() {
        return requiert;
    }
    public boolean[] getQuiAItem() {
        return quiAItem;
    }
    public ListItems getListitem() {
        return listitem;
    }
    public String getPhrase() {
        return phrase;
    }
    public int getNombreTributsImpliquer() {
        return nombreTributsImpliquer;
    }
    public String traduirePhrase(ListJoueur joueur){
        //Retourne la phrase avec le nom des joueurs a la place de [JoueurX], de même pour [il/elle]...
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '[') {
                if (phrase.substring(i, i + 7).equals("[Joueur")) {                           //Si il faut remplacer par le nom
                    res.append(joueur.getJoueur(Character.getNumericValue(phrase.charAt(i+7))-1).getNom());
                    i += 8;
                }else if (phrase.substring(i, i + 8).equals("[il/elle")){                    //Si il faut remplacer par il/elle
                    if (joueur.getJoueur(Character.getNumericValue(phrase.charAt(i+8))-1).getSexe().equals("M")){
                        res.append("il");
                        i += 9;
                    }else {
                        res.append("elle");
                        i += 9;
                    }
                } else if (phrase.substring(i, i + 6).equals("[le/la")){                    //Si il faut remplacer par le/la
                    if (joueur.getJoueur(Character.getNumericValue(phrase.charAt(i+6))-1).getSexe().equals("M")){
                        res.append("le");
                        i += 7;
                    }else {
                        res.append("la");
                        i += 7;
                    }
                }else if (phrase.substring(i, i + 7).equals("[son/sa")){                    //Si il faut remplacer par son/sa
                    if (joueur.getJoueur(Character.getNumericValue(phrase.charAt(i+7))-1).getSexe().equals("M")){
                        res.append("son");
                        i += 8;
                    }else {
                        res.append("sa");
                        i += 8;
                    }
                }
            }else {
                res.append(phrase.charAt(i));
            }
        }
        return res.toString();
    }
}
