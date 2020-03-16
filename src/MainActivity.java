import HG.HungerGame;
import HG.ListJoueur;

/*
Basé sur le site : https://brantsteele.net/hungergames/

Partie custom pour essayer : http://brantsteele.net/hungergames/r.php?c=FMuMPYaE
 */

public class MainActivity {
    public static void main(String[] args) {
        HungerGame hg = new HungerGame();
        int jour = 0;
        hg.bloodBathEvent();
        System.out.println();
        //hg.bloodBathEvent();
        System.out.println("\n##########################################\nJoueur Vivant :");
        hg.getListJoueurs().afficheJoueurs();
        System.out.println("Size : " + hg.getListJoueurs().size());
        System.out.println("\n##########################################\nJoueur Mort :");
        hg.getListJoueursD().afficheJoueurs();
        System.out.println("Size : " + hg.getListJoueursD().size());


//        while (hg.getListJoueurs().size() > 1){
//
//            if(jour==0){
//                hg.bloodBathEvent();
//            }else {
//
//                /*Si ajoute des events spéciaux faire ici
//                  proba = 1; //Nombre pour faire la probabilité d'avoir l'event
//                  x = randomNumber(0, 100);
//                  if(x <= proba){  //Si x et dans l'interval de probabilité on lance un event
//                    hg.feast ou hg.arena (voir site)
//                  }*/
//
//                if (jour%2 == 1) {
//                    hg.dayEvent();
//                }else {
//                    hg.nightEvent();
//                }
//
//
//
//            }
//            jour+=1;
//        }
    }
}

