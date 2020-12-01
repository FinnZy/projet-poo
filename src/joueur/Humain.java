package joueur;

import jeu.*;

public class Humain extends Joueur {


    public Humain(int motif, String nom){
        super(motif, nom);
    }

    public String getNom(){
        return this.nom;
    }

    public int getMotif(){
        return this.motif;
    }

    public int jouerTour(Partie partie) {
        return 0;
    }

}
