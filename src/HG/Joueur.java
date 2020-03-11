package HG;

import java.util.ArrayList;

import static Fonctions.MesFonctions.randomNumber;

public class Joueur {
    private String nom, sexe;
    private Integer vie, attaque, defence, district, kills;
    private ListItems sac;


    public Joueur(String nom,String sexe){
        //A la création du joueur il a des stats de base
        this.nom = nom;
        this.sexe = sexe;
        this.vie = 50;
        this.attaque = 5;
        this.defence = 5;
        this.district = 0;
        this.kills = 0;
        this.sac = new ListItems();
    }

    public Joueur(String nom,String sexe, int district){
        //A la création du joueur il a des stats de base et un district défini
        this.nom = nom;
        this.sexe = sexe;
        this.vie = 50;
        this.attaque = 5;
        this.defence = 5;
        this.district = district;
        this.kills = 0;
        this.sac = new ListItems();
    }

    public Joueur(String nom,String sexe, Integer vie, Integer attaque, Integer defence) {
        //Si on doit créer un joueur spécial
        this.nom = nom;
        this.sexe = sexe;
        this.vie = vie;
        this.attaque = attaque;
        this.defence = defence;
        this.district = 0;
        this.sac = new ListItems();
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
    public ListItems getSac() {
        return sac;
    }
    public String getNom() {
        return nom;
    }
    public String getSexe() {
        return sexe;
    }
    public Integer getDistrict() {
        return district;
    }

    //Fonctions
    public void ajouteItem(Item item){
        sac.addItem(item);
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
    public void addDistrict(Integer district){
        this.district = district;
    }

    public void supprimeItem(){
        int x = randomNumber(0,sac.size());
        Item item = (Item) sac.get(x);
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
