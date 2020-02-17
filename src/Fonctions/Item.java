package Fonctions;

public class Item {
    private Integer attaque,defence;
    private String nom;

    public Item(String nom, Integer attaque, Integer defence) {
        this.nom = nom;
        this.attaque = attaque;
        this.defence = defence;
    }

    //Getter / Setter

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
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Fonctions






}
