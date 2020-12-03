package jeu;

import joueur.Humain;
import joueur.IA;
import joueur.Joueur;
import ui.Affichage;
import ui.Input;

import java.util.Random;

public class Partie {
    int[][] grille;

    int vide = 0;
    int x = 1;
    int o = 2;
    int grilleLigne;
    int grilleCol;

    //Constructors
    Partie() {
        setGrilleLigne(6);
        setGrilleCol(7);
        creerGrille(this.getGrilleLigne(), this.getGrilleCol());
    }

    void creerGrille(int ligne, int colonne) {
        grille = new int[ligne][colonne];
        for (int l = 0; l < ligne; l++) {
            for (int c = 0; c < colonne; c++) {
                grille[l][c] = vide;
            }
        }
    }

    public char getMotifAffichage(int motif) {
        if (motif == 0) return '.';
        else if (motif == 1) return 'x';
        else return 'o';
    }

    //Setters & Getters
    public int[][] getGrille() { return this.grille; }

    public int getGrilleLigne() { return this.grilleLigne; }

    public int getGrilleCol() { return this.grilleCol; }

    public void setGrilleLigne(int grilleLigne) { this.grilleLigne = grilleLigne; }

    public void setGrilleCol(int grilleCol) { this.grilleCol = grilleCol; }

    public void setCaseGrille(int colonne, int motif, Analyse analyse) {
        int ligne = analyse.caseDisponible(colonne);
        if (ligne != -1) {
            this.grille[ligne][colonne] = motif;
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        Partie p = new Partie();
        Affichage a = new Affichage(p);
        Input i = new Input();
        Analyse analyse = new Analyse(p);
        Joueur joueur1;
        Joueur joueur2;

        // Initialisation des joueurs
        /* Joueur 1 */
        i.initialiserJeu(1);
        //System.out.println(i.getJoueurType() + " " + i.getJoueurNom());
        if (i.getJoueurType().equals("humain")) {
            joueur1 = new Humain(1, i.getJoueurNom());
            System.out.println("J1 : humain");
        } else {
            joueur1 = new IA(1, i.getJoueurNom());
            System.out.println("J1 : ia");
        }

        /* Joueur 2 */
        i.initialiserJeu(2);
        //System.out.println(i.getJoueurType() + " " + i.getJoueurNom());
        if (i.getJoueurType().equals("humain")) {
            joueur2 = new Humain(2, i.getJoueurNom());
            System.out.println("J2 : humain");
        } else {
            joueur2 = new IA(2, i.getJoueurNom());
            System.out.println("J2 : ia");
        }

        Plateau monPlateau = new Plateau(joueur1, joueur2, p, analyse, a);
        monPlateau.jouer(rnd);

    }

}
