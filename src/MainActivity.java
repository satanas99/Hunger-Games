import HG.HungerGame;
import HG.ListJoueur;

/*
Basé sur le site : https://brantsteele.net/hungergames/

Partie custom pour essayer : http://brantsteele.net/hungergames/r.php?c=FMuMPYaE
 */

public class MainActivity {
    public static void main(String[] args) {
        HungerGame hg = new HungerGame();
        int tour = 0;
        int jour = 0;
        int nuit = 0;
        while (hg.getListJoueurs().size() > 1){
            if(tour==0){
                System.out.println("============================================================\nBloodBath");
                hg.bloodBathEvent();
            }else {

                /*Si ajoute des events spéciaux faire ici
                  proba = 1; //Nombre pour faire la probabilité d'avoir l'event
                  x = randomNumber(0, 100);
                  if(x <= proba){  //Si x et dans l'interval de probabilité on lance un event
                    hg.feast ou hg.arena (voir site)
                  }*/

                if (tour%2 == 1) {
                    jour+=1;
                    System.out.println("============================================================\nJour : "+ jour);
                    hg.dayEvent();
                }else {
                    nuit+=1;
                    System.out.println("============================================================\nNuit : "+ nuit);
                    hg.nightEvent();
                }
            }
            tour+=1;
        }

        System.out.println("\nClassement");
        hg.getListJoueursD().afficheJoueurs();
        hg.getListJoueursD().afficheItems();

        System.out.println("\nGagnant : ");
        hg.getListJoueurs().afficheJoueurs();
        hg.getListJoueurs().afficheItems();

        System.out.println("Joueurs total : " + (hg.getListJoueursD().size()+hg.getListJoueurs().size()) + "/48");


        //        System.out.println();
        //        System.out.println("\n##########################################\nJoueur Vivant :");
        //        hg.getListJoueurs().afficheJoueurs();
        //        System.out.println("Size : " + hg.getListJoueurs().size());
        //        System.out.println("\n##########################################\nJoueur Mort :");
        //        hg.getListJoueursD().afficheJoueurs();
        //        System.out.println("Size : " + hg.getListJoueursD().size());

    }
}

