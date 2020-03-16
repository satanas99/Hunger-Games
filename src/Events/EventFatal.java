package Events;

import HG.ListItems;
import HG.ListJoueur;

public class EventFatal {
    //Attribut
    private String phrase;
    private int nombreTributsImpliquer;
    private boolean[] mort; //Tableaux contenant dans des boolean signifiant si le joueur est mort ou non
    private int[] tuer; //Tableaux contenant dans des nombres signifiant combien le joueur a tuer de personnes
    /* Par exemple, si il y a 4 tributs impliquer et que le 1er tue tout le monde les tableaux seront
    mort = [false,true,true,true]       le 1er est vivant et les 3 autres sont morts
    tuer = [3,0,0,0]                    le 1er a tuer 3 personnes et les autres 0
    */

    private ListItems listitem; //Liste des items qui peuvent être ajouter
    private boolean[] ajouteItem; //Pour determiner qui obtient l'item



    //Constructeur
    public EventFatal(String phrase, int nombreTributImpliquer, boolean[] mort, int[] tuer){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
        this.mort = mort;
        this.tuer = tuer;
        this.listitem =new ListItems();
        this.ajouteItem = new boolean[0];
    }

    public EventFatal(String phrase, int nombreTributImpliquer, boolean[] mort, int[] tuer, ListItems listitem, boolean[] ajouteItem){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
        this.mort = mort;
        this.tuer = tuer;
        this.listitem =listitem;
        this.ajouteItem = ajouteItem;
    }

    //Getters / Setters
    public boolean[] getMort() {
        return mort;
    }
    public int[] getTuer() {
        return tuer;
    }
    public String getPhrase() {
        return phrase;
    }
    public int getNombreTributsImpliquer() {
        return nombreTributsImpliquer;
    }
    public ListItems getListitem() {
        return listitem;
    }
    public boolean[] getAjouteItem() {
        return ajouteItem;
    }

    //Méthodes
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
