package joueur;

import jeu.Partie;
import jeu.Plateau;
import jeu.Analyse;

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

    public int jouerTour(Joueur ia, Partie partie, Analyse analyse){
        boolean aDeposer = true;
        if(analyse.estPlein() == true){
            aDeposer = false;
        }
        else{
            while(aDeposer){
                double x = Math.random() * 7;
                int y = 6;
                if(partie.caseDisponible(y) == -1){
                    aDeposer = true;
                }

                else {
                    partie.setCaseGrille(x, ia.motif);
                    aDeposer = false;
                }
            }
        }
    }
}
