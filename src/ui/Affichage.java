package ui;

import jeu.*;

public class Affichage {
    private Partie partie;

    public Affichage(Partie partie) {
        this.partie = partie;
    }

    public void afficherGrille() {
        int maxLigne = partie.getGrilleLigne();
        int maxCol = partie.getGrilleCol();
        int grillePartie[][] = partie.getGrille();

        System.out.printf("\n");
        for (int i = 0; i < maxLigne + 1; i++) {
            for (int j = 0; j < maxCol; j++) {
                // Affichage des numéros de colonne
                if (i == 0) {
                    System.out.printf("%d ", j+1);
                } else {
                    // Affiche chaque case en réalisant les correspondances
                    System.out.printf("%c ", partie.getMotifAffichage(grillePartie[i-1][j]));
                }
            }
            // Retour à la ligne à la fin de l'affichage de chaque colonne
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
}
