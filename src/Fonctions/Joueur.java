package Fonctions;

import java.util.ArrayList;

import static Fonctions.MesFonctions.randomNumber;

public class Joueur {
    private String nom, sexe;
    private Integer vie, attaque, defence;
    private ArrayList<Item> sac;

    public Joueur(String nom,String sexe){
        this.nom = nom;
        this.sexe = sexe;
        this.vie = 50;
        this.attaque = 5;
        this.defence = 5;
        this.sac = new ArrayList<Item>();

    }
    public Joueur(String nom,String sexe, Integer vie, Integer attaque, Integer defence) {
        this.nom = nom;
        this.sexe = sexe;
        this.vie = vie;
        this.attaque = attaque;
        this.defence = defence;
        this.sac = new ArrayList<Item>();
    }

    //Getter / Setter

    public Integer getVie() {
        return vie;
    }
    public void setVie(Integer vie) {
        this.vie = vie;
    }
    public Integer getAttaque() {
        return attaque;
    }
    public void setAttaque(Integer attaque) {
        this.attaque = attaque;
    }
    public Integer getDefence() {
        return defence;
    }
    public void setDefence(Integer defence) {
        this.defence = defence;
    }
    public ArrayList<Item> getSac() {
        return sac;
    }
    public void setSac(ArrayList<Item> sac) {
        this.sac = sac;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    //Fonctions
    public void ajouteItem(Item item){
        sac.add(item);
        addStats(item);
    }

    private void addStats(Item item) {
        if (item.getAttaque() > 0){
            attaque += item.getAttaque();
        }
        if (item.getDefence() > 0){
            defence += item.getDefence();
        }
    }

    public void supprimeItem(){
        int x = randomNumber(0,sac.size());
        Item item = sac.get(x);
        sac.remove(x);
        removeStats(item);
    }

    private void removeStats(Item item) {
        if (item.getAttaque() > 0){
            attaque -= item.getAttaque();
        }
        if (item.getDefence() > 0){
            defence -= item.getDefence();
        }
    }


}
