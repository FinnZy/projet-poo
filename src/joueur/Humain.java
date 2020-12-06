package joueur;

import jeu.*;

import java.util.Random;
import java.util.Scanner;

public class Humain extends Joueur {


    public Humain(int motif, String nom){

        super(motif, nom);
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
                    int check = partie.setCaseGrille(x, this.getMotif(), analyse);
                    if (check == -1) {
                        System.out.println("La case choisie est pleine, veuillez en choisir une autre !");
                        aDeposer = true;
                    } else {
                        aDeposer = false;
                    }
                }
            }
        }

        return 0;
    }


}
