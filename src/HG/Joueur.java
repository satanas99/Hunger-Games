package HG;

import java.util.ArrayList;

import static Fonctions.MesFonctions.randomNumber;

public class Joueur {
    private String nom, sexe;
    private Integer vie, attaque, defence, district, kills;
    private ListItems sac;
    private boolean mort;


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
        this.mort = false;
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
        this.mort = false;
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
        this.mort = false;
    }

    //Getter / Setter

    public boolean isMort() {
        return mort;
    }
    public void setMort(boolean mort) {
        this.mort = mort;
    }
    public Integer getKills() {
        return kills;
    }
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
    }
    public void addDistrict(Integer district){
        this.district = district;
    }
    public void ajouteKill(int kills){//Ajoute au joueur le nombre de kills en paramètres
        this.kills += kills;
    }
    public void ajouteItems(ListItems listItems) {//Ajoute plusieurs Item au sac
        for (Item item: listItems.getListItems()) {
            sac.addItem(item);
        }
    }
}
