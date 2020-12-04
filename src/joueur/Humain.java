package joueur;

import jeu.*;

import java.util.Random;
import java.util.Scanner;

public class Humain extends Joueur {


    public Humain(int motif, String nom, int numeroJoueur, int score){

        super(motif, nom, numeroJoueur, score);
    }

    public int jouerTour(Partie partie, Random rnd) {
        Analyse analyse = new Analyse(partie);
        boolean aDeposer = true;
        if(analyse.estPlein()){
            aDeposer = false;
        } else {
            while(aDeposer) {

                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();
                if (x > 7 || x <= 0){
                    System.out.println("Entrer un nombre compris entre 1 et 7");
                } else {
                    x--;
                    partie.setCaseGrille(x, this.getMotif(), analyse);
                    aDeposer = false;
                }
            }
        }

        return 0;
    }


}
