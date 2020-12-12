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
                // Initialisation de la grille avec le motif "vide"
                grille[l][c] = vide;
            }
        }
    }

    public char getMotifAffichage(int motif) {
        // Récupération du motif pour l'affichage sur le terminal
        if (motif == 0) return '.';
        else if (motif == 1) return 'x';
        else return 'o';
    }

    // Déclaration des setters et des getters
    public int[][] getGrille() { return this.grille; }

    public int getGrilleLigne() { return this.grilleLigne; }

    public int getGrilleCol() { return this.grilleCol; }

    public void setGrilleLigne(int grilleLigne) { this.grilleLigne = grilleLigne; }

    public void setGrilleCol(int grilleCol) { this.grilleCol = grilleCol; }

    public int setCaseGrille(int colonne, int motif, Analyse analyse) {
        // Récupération de la première case disponible dans la colonne
        int ligne = analyse.caseDisponible(colonne);
        if (ligne != -1) {
            // Si la colonne n'est pas pleine, dépôt du jeton
            this.grille[ligne][colonne] = motif;
        } else {
            // Si la colonne est pleine, retourne une erreur
            int vraieColonne = colonne + 1;
            System.out.println("La colonne " + vraieColonne + " est pleine, veuillez en choisir une autre !");
            ef.ecrireErreurColonne("pleine", String.valueOf(vraieColonne));
        }
        return ligne;
    }

    public void reinitGrille() {
        int ligne = grille.length;
        int colonne = grille[0].length;
        for (int l = 0; l < ligne; l++) {
            for (int c = 0; c < colonne; c++) {
                grille[l][c] = vide;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Random aleatoire = new Random();

        EcrireFichier ef = new EcrireFichier();
        Partie p = new Partie(ef);
        Affichage a = new Affichage(p);
        Entree i = new Entree(ef);
        Analyse analyse = new Analyse(p);
        Joueur joueur1;
        Joueur joueur2;

        // Initialisation des joueurs
        /* Joueur 1 */
        i.initialiserJeu(1);
        if (i.getJoueurType().equals("humain")) {
            joueur1 = new Humain(1, i.getJoueurNom());
        } else {
            joueur1 = new IA(1, i.getJoueurNom());
        }
        ef.ecrireNom(1, i.getJoueurType() + " " + i.getJoueurNom());

        /* Joueur 2 */
        i.initialiserJeu(2);
        if (i.getJoueurType().equals("humain")) {
            joueur2 = new Humain(2, i.getJoueurNom());
        } else {
            joueur2 = new IA(2, i.getJoueurNom());
        }
        ef.ecrireNom(2, i.getJoueurType() + " " + i.getJoueurNom());

        Plateau monPlateau = new Plateau(joueur1, joueur2, p, analyse, a, 3, ef);
        // Affichage de la grille vide
        a.afficherGrille();
        ef.ecrireManche();
        monPlateau.jouer(aleatoire, 1);
    }
}
