package joueur;

import jeu.*;

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

    public int jouerTour(Partie partie){
        Analyse analyse = new Analyse(partie);
        boolean aDeposer = true;
        if(analyse.estPlein()){
            aDeposer = false;
        }
        else{
            while(aDeposer){
                double x = Math.random() * 7;
                int y = 6;
                if(analyse.caseDisponible(y) == -1){
                    aDeposer = true;
                }

                else {
                    partie.setCaseGrille((int) x, this.getMotif());
                    aDeposer = false;
                }
            }
        }

        return 0;
    }
}
