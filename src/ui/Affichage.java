package ui;

import jeu.*;

public class Affichage {
    private Partie partie;

    Affichage(Partie partie) {
        this.partie = partie;
    }

    public static void afficherGrille(Partie partie) {
        int maxLigne = partie.getGrilleLigne();
        int maxCol = partie.getGrilleCol();
        int grillePartie[][] = partie.getGrille();

        for (int i = 0; i < maxLigne; i++) {
            for (int j = 0; j < maxCol; j++) {
                // Affichage des numéros de colonne
                if (i == 0) {
                    System.out.printf("%i ", i);
                } else {
                    // Affiche chaque case en réalisant les correspondances
                    System.out.printf("%c ", partie.getMotifAffichage(grillePartie[i][j]));
                }
            }
            // Retour à la ligne à la fin de l'affichage de chaque colonne
            System.out.printf("\n");
        }
    }
}
