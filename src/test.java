import Events.EventFatal;
import Events.EventNormal;
import HG.Joueur;
import HG.ListJoueur;

public class test {
    public static void main(String[] args) {
        ListJoueur ljoueurs = new ListJoueur();
        ljoueurs.addJoueur( new Joueur("Toto","M"));
        ljoueurs.addJoueur( new Joueur("Tata","F"));
        EventFatal event = new EventFatal("[Joueur1] combat [Joueur2]. [il/elle1] [le/la2] tue.", 2);

        System.out.println(event.getPhrase());
        System.out.println(traduirePhrase(ljoueurs, event));

    }

    public static String traduirePhrase(ListJoueur joueur, EventNormal event) {
        //Prend la phrase de l'EventNormal en paramètre et remplace le nom des joueurs et les il/elle etc
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < event.getPhrase().length() - 1; i++) {
            if (event.getPhrase().charAt(i) == '[') {
                if (event.getPhrase().substring(i, i + 6).equals("[Joueur")) { //Si il faut remplacer par le nom
                    res.append(joueur.getJoueur(Character.getNumericValue(event.getPhrase().charAt(i+7))-1).getNom());
                    i += 8;
                }else if (event.getPhrase().substring(i, i + 7).equals("[il/elle")){
                    if (joueur.getJoueur(Character.getNumericValue(event.getPhrase().charAt(i+8))).getSexe().equals("M")){
                        res.append("il");
                        i += 9;
                    }else {
                        res.append("elle");
                        i += 9;
                    }
                }
            } else {
                res.append(event.getPhrase().charAt(i));
            }
        }
        return res.toString();
    }

    public static String traduirePhrase(ListJoueur joueur, EventFatal event){
        //Prend la phrase de l'EventFatal en paramètre et remplace le nom des joueurs et les il/elle etc
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < event.getPhrase().length(); i++) {
            if (event.getPhrase().charAt(i) == '[') {
                if (event.getPhrase().substring(i, i + 7).equals("[Joueur")) {                           //Si il faut remplacer par le nom
                    res.append(joueur.getJoueur(Character.getNumericValue(event.getPhrase().charAt(i+7))-1).getNom());
                    i += 8;
                }else if (event.getPhrase().substring(i, i + 8).equals("[il/elle")){                    //Si il faut remplacer par il/elle
                    if (joueur.getJoueur(Character.getNumericValue(event.getPhrase().charAt(i+8))-1).getSexe().equals("M")){
                        res.append("il");
                        i += 9;
                    }else {
                        res.append("elle");
                        i += 9;
                    }
                } else if (event.getPhrase().substring(i, i + 6).equals("[le/la")){                    //Si il faut remplacer par le/la
                    if (joueur.getJoueur(Character.getNumericValue(event.getPhrase().charAt(i+6))-1).getSexe().equals("M")){
                        res.append("le");
                        i += 7;
                    }else {
                        res.append("la");
                        i += 7;
                    }
                }else if (event.getPhrase().substring(i, i + 7).equals("[son/sa")){                    //Si il faut remplacer par son/sa
                    if (joueur.getJoueur(Character.getNumericValue(event.getPhrase().charAt(i+7))-1).getSexe().equals("M")){
                        res.append("son");
                        i += 8;
                    }else {
                        res.append("sa");
                        i += 8;
                    }
                }
            }else {
                res.append(event.getPhrase().charAt(i));
            }
        }
        return res.toString();
    }















//    public static String traduirePhraseNormal(ListJoueur joueur, EventNormal event){
//        String res = "";
//        System.out.println(event.getPhrase());
//
//        for (int i = 0; i < event.getPhrase().length()-1;i++){
//            if (event.getPhrase().charAt(i) == '['){
//                if (event.getPhrase().substring(i, i + 9).equals("[Joueur1]")){
//                    res += joueur.getNom();
//                    i+=8;
//                }
//            }else{
//                res += event.getPhrase().charAt(i);
//            }
//
//        }
//
//
//        System.out.println(res);
//        return res;
//    }
    
}
