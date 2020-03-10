import Events.EventFatal;
import Events.EventNormal;
import HG.Joueur;
import HG.ListJoueur;

public class test {
    public static void main(String[] args) {
        ListJoueur ljoueurs = new ListJoueur();
        ljoueurs.addJoueur( new Joueur("Toto","M"));
        ljoueurs.addJoueur( new Joueur("Tata","F"));
        EventFatal event = new EventFatal("[Joueur1] tue [Joueur2] .", 2);

      String x = traduirePhraseFatal(ljoueurs, event);
        
    }


    public static String traduirePhraseFatal(ListJoueur joueur, EventFatal event){
        String res = "";
        System.out.println(event.getPhrase());

        for (int i = 0; i < event.getPhrase().length()-1;i++){
            if (event.getPhrase().charAt(i) == '['){
                if (event.getPhrase().substring(i, i + 9).equals("[Joueur1]")){
                    res += joueur.getNom();
                    i+=8;
                }
            }else{
                res += event.getPhrase().charAt(i);
            }

        }


        System.out.println(res);
        return res;
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
