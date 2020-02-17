package Fonctions;

import java.util.Random;
import java.util.Scanner;

public class MesFonctions {

        public static int saisirInt(String ch) {
            //Demande a l'utilisateur de saisir un nombre
            //Prend en paramètre une chaine de caractère qui sera la question retourner a l'utilisateur (ex : saisir un nombre)
            Scanner input = new Scanner(System.in);

            Integer saisi = null;

            try {
                System.out.print(ch + " : ");
                saisi = input.nextInt();

            } catch (Exception e){
                System.out.println("Erreur de saisie");
                saisi = saisirInt(ch);
            }
            return saisi;
        }

    public static float saisirFloat(String ch) {
        //Demande a l'utilisateur de saisir un nombre (float)
        //Prend en paramètre une chaine de caractère qui sera la question retourner a l'utilisateur (ex : saisir un nombre)
        Scanner input = new Scanner(System.in);

        float saisi = 0;

        try {
            System.out.print(ch + " : ");
            saisi = input.nextInt();

        } catch (Exception e){
            System.out.println("Erreur de saisie");
            saisi = saisirFloat(ch);
        }
        return saisi;
    }

        public static String saisirStr(String ch) {
            //Demande a l'utilisateur de saisir un mot
            //Prend en paramètre une chaine de caractère qui sera la question retourner a l'utilisateur (ex : saisir un mot)
            Scanner input = new Scanner(System.in);

            String saisi = null;

            try {
                System.out.print(ch + " : ");
                saisi = input.nextLine();

            } catch (Exception e){
                System.out.println("Erreur de saisie");
                saisi = saisirStr(ch);
            }

            return saisi;
        }


        public static int randomNumber(int min, int max) {
            //Donne un nombre aléatoire entre nbr1 et nbr2
            Random rand = new Random();
            return rand.nextInt(max - min + 1) + min;


        }

        public static void choix(String liste[],boolean quitter){
            //System.out.println();
            //System.out.println("=========================");
            for (int i = 0; i < liste.length;i++){
                System.out.println(i+1 + " - " + liste[i]);
            }
            if (quitter) {
                System.out.println(liste.length + 1 + " - Quitter");
            }
        }



}



