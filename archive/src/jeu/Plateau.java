package jeu;

import joueur.Joueur;
import ui.Affichage;
import ui.EcrireFichier;
import java.util.Random;

public class Plateau {
    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;
    private Analyse analyse;
    private Affichage affichage;
    private EcrireFichier ef;
    private int nbrManches;
    private int manchesJouees;

    Plateau(Joueur joueur1, Joueur joueur2, Partie partie, Analyse analyse, Affichage affichage, int nbrManches, EcrireFichier ef) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.partie = partie;
        this.analyse = analyse;
        this.affichage = affichage;
        this.nbrManches = nbrManches;
        this.manchesJouees = 0;
        this.ef = ef;
    }

    public void jouer(Random aleatoire, int joueurQuiCommence) {
        int vainqueur = -1;
        int perdant = -1;
        System.out.println("C'est au joueur " + joueurQuiCommence + " de commencer");

        while (vainqueur == -1 && !analyse.estPlein()) {
            if (joueurQuiCommence == 1)
                vainqueur = joueurUnCommence(aleatoire);
            else if (joueurQuiCommence == 2)
                vainqueur = joueurDeuxCommence(aleatoire);
        }

        // Mise en place des actions à exécuter lorsque la partie est finie
        if (manchesJouees < nbrManches - 1) {
            if (vainqueur == -1) {
                System.out.println("Manche terminée ! Match nul !");
                ef.ecrireMancheTransition(joueur1.getScore(), joueur2.getScore(), vainqueur, nbrManches);

                // Réinitialisation et redémarrage de la manche
                partie.reinitGrille();
                affichage.afficherGrille();
                this.jouer(aleatoire, joueurQuiCommence);
            } else {
                String vainqueurNom = "";

                // Récupération du nom du vainqueur en fonction du gagnant et incrémentation des scores
                if (vainqueur == 1) {
                    vainqueurNom = joueur1.getNom();
                    joueur1.incScore();
                    perdant = 2;
                } else {
                    vainqueurNom = joueur2.getNom();
                    joueur2.incScore();
                    perdant = 1;
                }

                // Affichage de la ligne de victoire pour le gagnant
                System.out.println("Bravo ! Le joueur " + vainqueurNom + " gagne cette manche !");
                ef.ecrireMancheTransition(joueur1.getScore(), joueur2.getScore(), vainqueur, nbrManches);

                this.manchesJouees += 1;    // Incrémentation du nombre de manches jouées
                partie.reinitGrille();       // Réinitialisation de la grille
                affichage.afficherGrille(); // Affichage de la grille vide
                this.jouer(aleatoire, perdant);   // Retour dans la boucle de jeu
            }
        } else {
            String vainqueurNom = "";

            // Récupération du nom du vainqueur en fonction du gagnant et incrémentation des scores
            if (vainqueur == 1) {
                joueur1.incScore();
                // Vérification après incrémentation des scores de qui est le grand gagnant
                if (joueur1.getScore() > joueur2.getScore())
                    vainqueurNom = joueur1.getNom();
                else
                    vainqueurNom = joueur2.getNom();
            } else {
                joueur2.incScore();
                // Vérification après incrémentation des scores de qui est le grand gagnant
                if (joueur2.getScore() > joueur1.getScore())
                    vainqueurNom = joueur2.getNom();
                else
                    vainqueurNom = joueur1.getNom();
            }

            if (vainqueur == -1 || joueur1.getScore() == joueur2.getScore()) {
                System.out.println("Partie terminée ! Match nul !");
            } else {
                // Affichage de la ligne de victoire pour le gagnant
                System.out.println("Bravo ! Le joueur " + vainqueurNom + " remporte la partie !");
            }
            ef.ecrireMancheTransition(joueur1.getScore(), joueur2.getScore(), vainqueur, nbrManches);
        }
    }

    private int joueurUnCommence(Random aleatoire) {
        int vainqueur = -1;

        joueur1.jouerTour(partie, ef, aleatoire);
        affichage.afficherGrille();
        // Regarde si le premier joueur est le vainqueur de la partie
        if (analyse.cherche()) {
            vainqueur = 1;
            return vainqueur;
        }

        joueur2.jouerTour(partie, ef, aleatoire);
        affichage.afficherGrille();
        // Regarde si le deuxième joueur est le vainqueur de la partie
        if (analyse.cherche()) {
            vainqueur = 2;
            return vainqueur;
        }

        // Si le plateau est plein, il n'y a pas de vainqueur déclaré
        if (analyse.estPlein()) {
            vainqueur = -1;
        }

        return vainqueur;
    }

    private int joueurDeuxCommence(Random aleatoire) {
        int vainqueur = -1;

        joueur2.jouerTour(partie, ef, aleatoire);
        affichage.afficherGrille();
        // Regarde si le deuxième joueur est le vainqueur de la partie
        if (analyse.cherche()) {
            vainqueur = 2;
            return vainqueur;
        }

        joueur1.jouerTour(partie, ef, aleatoire);
        affichage.afficherGrille();
        // Regarde si le premier joueur est le vainqueur de la partie
        if (analyse.cherche()) {
            vainqueur = 1;
            return vainqueur;
        }

        // Si le plateau est plein, il n'y a pas de vainqueur déclaré
        if (analyse.estPlein()) {
            vainqueur = -1;
        }

        return vainqueur;
    }
}