package joueur;

import jeu.Partie;
import jeu.Plateau;

public abstract class Joueur {

    protected String nom;
    protected int motif;

    public Joueur(int motif, String nom){

        this.nom = nom;
        this.motif = motif;
    }


    public String getNom(){
        return this.nom;
    }

    public int getMotif(){
        return this.motif;
    }


    private void setNom(String nom){
        this.nom = nom;
    }

    private void setMotif(int motif){
        this.motif = motif;
    }

    public abstract void jouerTour(Joueur joueur);





}