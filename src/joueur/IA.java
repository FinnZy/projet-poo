package joueur;

import jeu.*;
import ui.EcrireFichier;

import java.util.Random;

public class IA extends Joueur {

    public IA(int motif, String nom){
        super(motif, nom);
    }

    public int jouerTour(Partie partie, EcrireFichier ef, Random rnd){
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
                    ef.writeActions(this.getNom(), this.getNumeroJoueur(), x+1);
                    aDeposer = false;
                }
            }
        }
        return 0;
    }
}
