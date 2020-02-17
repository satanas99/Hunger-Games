package Fonctions;

public class Tableaux {

    //Affiche un tableau d'entier
    public static void Affiche_tableau(int tableau[], String ch) {

        System.out.print( ch + " [");
        for (int i = 0; i < tableau.length; i++) {
            if (i < tableau.length - 1) {
                System.out.print(tableau[i] + " ,");
            } else {
                System.out.println(tableau[i] + "]");
            }
        }
    }

    //Affiche un tableau de réél
    public static void Affiche_tableau_float(float tableau[]) {

        System.out.print("Tableau [");
        for (int i = 0; i < tableau.length; i++) {
            if (i < tableau.length - 1) {
                System.out.print(tableau[i] + " ,");
            } else {
                System.out.println(tableau[i] + "]");
            }
        }
    }

    //Affiche un tableau de String
    public static void Affiche_tableau_string(String tableau[]) {

        System.out.print("Tableau [");
        for (int i = 0; i < tableau.length; i++) {
            if (i < tableau.length - 1) {
                System.out.print(tableau[i] + " ,");
            } else {
                System.out.println(tableau[i] + "]");
            }
        }
    }


    //Tri un tableau d'entier dans l'ordre croissant
    public static void Tri_tableau(int tableau[]) {

        int compt = 0;
        while (compt < tableau.length) {
            int plus_petit = tableau[compt];
            int remplace = tableau[compt];
            int ind = compt;

            for (int i = compt; i < tableau.length; i++) {
                if (plus_petit > tableau[i]) {
                    plus_petit = tableau[i];
                    ind = i;
                }
            }
            tableau[compt] = plus_petit;
            tableau[ind] = remplace;
            compt += 1;
/* Affiche a chaque tour dans la boucle le tableau

            for (int i = 0 ; i < tableau2.length; i++){
                if (i<tableau2.length-1) {
                    System.out.print(tableau2[i] + " ,");
                }else{
                   System.out.println(tableau2[i]);
                }
            }
*/
        }
    }


    //Calcul la moyenne des valeurs d'un tableau d'entier
    public static boolean Moyenne_tableau(int tableau[], String phrase) {
        int somme = 0;

        for (int i = 0; i < tableau.length; i++) {
            somme += tableau[i];
        }

        float moyenne = somme / tableau.length;

        int res = 0;
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] >= moyenne) {
                res += 1;
            }
        }
        System.out.println(phrase + " : " + moyenne);
        return true;
    }









}