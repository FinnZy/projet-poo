package jeu;

import joueur.Joueur;
import ui.Affichage;

import java.util.Random;

public class Plateau {
    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;
    private Analyse analyse;
    private Affichage affichage;

    Plateau(Joueur joueur1, Joueur joueur2, Partie partie, Analyse analyse, Affichage affichage) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.partie = partie;
        this.analyse = analyse;
        this.affichage = affichage;
    }

    public void jouer(Random rnd) {
        int vainqueur = -1;

        while (vainqueur == -1 && !analyse.estPlein()) {

            joueur1.jouerTour(partie, rnd);
            affichage.afficherGrille();
            // Regarde si le premier joueur est le vainqueur de la partie
            if (analyse.cherche()) {
                vainqueur = 1;
                break;
            }

            joueur2.jouerTour(partie, rnd);
            affichage.afficherGrille();
            // Regarde si le deuxième joueur est le vainqueur de la partie
            if (analyse.cherche()) {
                vainqueur = 2;
            }

            // Si le plateau est plein, il n'y a pas de vainqueur déclaré
            if (analyse.estPlein()) {
                vainqueur = -1;
            }
        }

        // Mise en place des actions à exécuter lorsque la partie est finie
        if (vainqueur == -1) {
            System.out.println("Partie terminée ! Match nul !");
        } else {
            System.out.println("Bravo ! Le joueur " + vainqueur + " est gagnant !");
        }
    }
}