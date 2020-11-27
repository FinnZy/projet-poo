package jeu;

public class Analyse extends Partie {
    private int[][] grille;

    private int X = 1;
    private int O = 2;
    private int grilleTailleX;
    private int grilleTailleY;

    // Constructors
    Analyse() {
        this.grille = getGrille();
        this.grilleTailleX = getGrilleLigne();
        this.grilleTailleY = getGrilleCol();
    }

    // Cherche de potentiels jetons alignés
    boolean cherche() {
        // Cherche horizontalement
        for (int y = 0; y < grilleTailleY; y++) {
            if (true == chercheAlignes(0, y, 1, 0)) {
                return true;
            }
        }

        // Cherche verticalement
        for (int x = 0; x < grilleTailleX; x++) {
            if (true == chercheAlignes(x, 0, 0, 1)) {
                return true;
            }
        }

        // Cherche sur les diagonales gauche et droite
        for (int x = 0; x < grilleTailleX; x++) {
            for (int y = 0; y < grilleTailleY; y++) {
                // Diagonale droite
                if (true == chercheAlignes(x, y, 1, 1)) {
                    return true;
                }

                // Diagonale gauche
                if (chercheAlignes(grilleTailleX - x, y, -1, 1)) {
                    return true;
                }
            }
        }

        // Pas d'alignement trouvé
        return false;
    }

    boolean chercheAlignes(int debutX, int debutY, int pasX, int pasY) {
        int compteur = 0;
        int currMotif = 0;

        int currX = debutX;
        int currY = debutY;

        currMotif = grille[currX][currY];

        while ((currX < grilleTailleX) && (currY < grilleTailleY) && (currX >= 0)) {
            if (grille[currX][currY] != currMotif) {
                compteur = 1;
                currMotif = grille[currX][currY];
            } else {
                compteur++;
            }

            if (compteur == 4 && currMotif != 0)
                return true;

            currX += pasX;
            currY += pasY;
        }

        return false;
    }

    boolean estPlein() {
        for (int x = 0; x < grilleTailleX; x++) {
            for (int y = 0; y < grilleTailleY; y++) {
                // Si une case est vide, la grille n'est pas pleine
                if (grille[x][y] == 0)
                    return false;
            }
        }

        // Si aucune case vide n'a été trouvée, la grille est pleine
        return true;
    }
}
