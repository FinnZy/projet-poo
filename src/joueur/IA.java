package joueur;

import jeu.*;

import java.util.Random;

public class IA extends Joueur {

    public IA(int motif, String nom){
        super(motif, nom);
    }

    public int jouerTour(Partie partie, Random rnd){
        Analyse analyse = new Analyse(partie);
        boolean aDeposer = true;
        if(analyse.estPlein()){
            aDeposer = false;
        } else {
            while(aDeposer){
                int x = rnd.nextInt(5);
                int check = partie.setCaseGrille(x, this.getMotif(), analyse);
                if (check == -1) {
                    aDeposer = true;
                } else {
                    aDeposer = false;
                }
            }
        }

        return 0;
    }
}
