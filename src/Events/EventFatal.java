package Events;

public class EventFatal {
    //Attribut
    private String phrase;
    private int nombreTributsImpliquer;
    private boolean aTuer;
    private boolean estTuer;

    //Constructeur
    public EventFatal(String phrase, int nombreTributImpliquer){
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
