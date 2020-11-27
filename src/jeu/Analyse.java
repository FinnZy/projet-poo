package jeu;

public class Analyse extends Partie {
    // Constructors
    Analyse() {
    }

    // Cherche de potentiels jetons alignés
    public boolean cherche() {
        // Cherche horizontalement
        for (int y = 0; y < this.getGrilleCol(); y++) {
            if (chercheAlignes(0, y, 1, 0)) {
                return true;
            }
        }

        // Cherche verticalement
        for (int x = 0; x < this.getGrilleLigne(); x++) {
            if (chercheAlignes(x, 0, 0, 1)) {
                return true;
            }
        }

        // Cherche sur les diagonales gauche et droite
        for (int x = 0; x < this.getGrilleLigne(); x++) {
            for (int y = 0; y < this.getGrilleCol(); y++) {
                // Diagonale droite
                if (chercheAlignes(x, y, 1, 1)) {
                    return true;
                }

                // Diagonale gauche
                if (chercheAlignes(this.getGrilleCol() - x, y, -1, 1)) {
                    return true;
                }
            }
        }

        // Pas d'alignement trouvé
        return false;
    }

    public boolean chercheAlignes(int debutX, int debutY, int pasX, int pasY) {
        int compteur = 0;
        int currMotif = 0;

        int currX = debutX;
        int currY = debutY;

        int[][] grille = this.getGrille();
        int grilleTailleY = this.getGrilleCol();
        int grilleTailleX = this.getGrilleLigne();

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

    public boolean estPlein() {
        for (int x = 0; x < this.getGrilleLigne(); x++) {
            for (int y = 0; y < this.getGrilleCol(); y++) {
                // Si une case est vide, la grille n'est pas pleine
                if (this.getGrille()[x][y] == 0)
                    return false;
            }
        }

        // Si aucune case vide n'a été trouvée, la grille est pleine
        return true;
    }
}
