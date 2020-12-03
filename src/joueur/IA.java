package joueur;

import jeu.*;

import java.util.Random;

public class IA extends Joueur {

    public IA(int motif, String nom){
        super(motif, nom);
    }

    public String getNom(){
        return this.nom;
    }

    public int getMotif(){
        return this.motif;
    }

    public int jouerTour(Partie partie, Random rnd){
        Analyse analyse = new Analyse(partie);
        boolean aDeposer = true;
        if(analyse.estPlein()){
            aDeposer = false;
        } else {
            while(aDeposer){
                int x = rnd.nextInt(5);
                partie.setCaseGrille(x, this.getMotif(), analyse);
                aDeposer = false;
            }
        }

        return 0;
    }
}
