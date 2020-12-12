package joueur;

import jeu.*;
import ui.EcrireFichier;

import java.util.Random;

public abstract class Joueur {

    private String nom;
    private int motif;
    private int numeroJoueur;
    private int score;

    public Joueur(int motif, String nom){
        this.nom = nom;
        this.motif = motif;
        this.numeroJoueur = motif;
        this.score = 0;
    }

    public String getNom(){
        return this.nom;
    }

    public int getMotif(){
        return this.motif;
    }

    public int getNumeroJoueur(){
        return this.numeroJoueur;
    }

    public int getScore(){
        return this.score;
    }

    public void incScore(){
        this.score += 1;
    }

    public abstract int jouerTour(Partie partie, EcrireFichier ef, Random aleatoire);
}
