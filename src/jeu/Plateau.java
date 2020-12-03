package jeu;

import joueur.Joueur;

public class Plateau {
    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;
    private Analyse analyse;

    Plateau(Joueur joueur1, Joueur joueur2, Partie partie, Analyse analyse) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.partie = partie;
        this.analyse = analyse;
    }

    public void jouer() {
        int vainqueur = -1;

        while (vainqueur == -1 && !analyse.estPlein()) {
            joueur1.jouerTour(partie);
            // Regarde si le premier joueur est le vainqueur de la partie
            if (analyse.cherche()) {
                vainqueur = 1;
            }

            joueur2.jouerTour(partie);
            // Regarde si le deuxième joueur est le vainqueur de la partie
            if (analyse.cherche()) {
                vainqueur = 1;
            }

            // Si le plateau est plein, il n'y a pas de vainqueur déclaré
            if (analyse.estPlein()) {
                vainqueur = -1;
            }
        }

        // Mise en place des actions à exécuter lorsque la partie est finie
        if (vainqueur == -1) {

        } else {

        }
    }
}