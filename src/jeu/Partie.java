package jeu;

import joueur.*;
import ui.*;

import java.io.IOException;
import java.util.Random;

public class Partie {
    private int[][] grille;

    private int vide = 0;
    private int x = 1;
    private int o = 2;
    private int grilleLigne;
    private int grilleCol;
    private EcrireFichier ef;

    //Constructors
    Partie(EcrireFichier ef) {
        setGrilleLigne(6);
        setGrilleCol(7);
        creerGrille(this.getGrilleLigne(), this.getGrilleCol());
        this.ef = ef;
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

    public int setCaseGrille(int colonne, int motif, Analyse analyse) {
        int ligne = analyse.caseDisponible(colonne);
        if (ligne != -1) {
            this.grille[ligne][colonne] = motif;
        } else {
            int vraieColonne = colonne + 1;
            System.out.println("La colonne " + vraieColonne + " est pleine, veuillez en choisir une autre !");
            ef.ecrireErreurColonne("pleine", String.valueOf(vraieColonne));
        }
        return ligne;
    }

    public void resetGrille() {
        int ligne = grille.length;
        int colonne = grille[0].length;
        for (int l = 0; l < ligne; l++) {
            for (int c = 0; c < colonne; c++) {
                grille[l][c] = vide;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Random rnd = new Random();

        EcrireFichier ef = new EcrireFichier();
        Partie p = new Partie(ef);
        Affichage a = new Affichage(p);
        Input i = new Input(ef);
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
        ef.writeName(1, i.getJoueurType() + " " + i.getJoueurNom());

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
        ef.writeName(2, i.getJoueurType() + " " + i.getJoueurNom());

        Plateau monPlateau = new Plateau(joueur1, joueur2, p, analyse, a, 3, ef);
        // Affichage de la grille vide
        a.afficherGrille();
        ef.writeManche();
        monPlateau.jouer(rnd, 1);
    }
}
