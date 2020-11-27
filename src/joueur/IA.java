package joueur;

import jeu.Partie;
import jeu.Plateau;
import jeu.Analyse;

public abstract class IA extends Joueur {

    public IA(int motif, String nom){
        super(motif, nom);
    }

    public String getNom(){
        return this.nom;
    }

    public int getMotif(){
        return this.motif;
    }

    public void jouerTour(IA ia){
        boolean aDeposer = true;
        if(Analyse.estPlein() == true){
            aDeposer = false;
        }
        else{
            while(aDeposer){
                double x = Math.random() * 7;
                int y = 6;
                if(Partie.caseDisponible(y) == -1){
                    aDeposer = true;
                }

                else {
                    Partie.setCaseGrille(x, ia.motif);
                    aDeposer = false;
                }
            }
        }
    }
}
