package Events;

public class EventNormal {
    //Attribut
    private String phrase;
    private int nombreTributsImpliquer;


    //Constructeur
    public EventNormal(String phrase, int nombreTributImpliquer){
        this.phrase = phrase;
        this.nombreTributsImpliquer = nombreTributImpliquer;
    }

    public String getPhrase() {
        return phrase;
    }
    public int getNombreTributsImpliquer() {
        return nombreTributsImpliquer;
    }

}
