package joueur;

import jeu.*;
import ui.EcrireFichier;

import java.util.Random;

public class IA extends Joueur {

    public IA(int motif, String nom){
        super(motif, nom);
    }

    public int jouerTour(Partie partie, EcrireFichier ef, Random aleatoire){
        Analyse analyse = new Analyse(partie);
        boolean aDeposer = true;
        if(analyse.estPlein()){
            return 1;
        } else {
            while(aDeposer){
                int x = aleatoire.nextInt(5);
                int verif = partie.setCaseGrille(x, this.getMotif(), analyse);
                ef.ecrireActions(this.getNumeroJoueur(), x+1);
                if (verif == -1) {
                    aDeposer = true;
                } else {
                    aDeposer = false;
                }
            }
        }
        return 0;
    }
}
