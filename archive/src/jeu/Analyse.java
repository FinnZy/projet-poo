package jeu;

public class Analyse {
    private Partie partie;
    // Constructeur
    public Analyse(Partie partie) {
        this.partie = partie;
    }

    // Cherche de potentiels jetons alignés
    public boolean cherche() {
        // Cherche horizontalement
        for (int y = 0; y < this.partie.getGrilleCol(); y++) {
            if (chercheAlignes(0, y, 1, 0)) {
                return true;
            }
        }

        // Cherche verticalement
        for (int x = 0; x < this.partie.getGrilleLigne(); x++) {
            if (chercheAlignes(x, 0, 0, 1)) {
                return true;
            }
        }

        // Cherche sur les diagonales gauche et droite
        for (int x = 0; x < this.partie.getGrilleLigne(); x++) {
            for (int y = 0; y < this.partie.getGrilleCol(); y++) {
                // Diagonale droite
                if (chercheAlignes(x, y, 1, 1)) {
                    return true;
                }

                // Diagonale gauche
                if (chercheAlignes(this.partie.getGrilleLigne() - 1 - x, y, -1, 1)) {
                    return true;
                }
            }
        }

        // Pas d'alignement trouvé
        return false;
    }

    public boolean chercheAlignes(int debutX, int debutY, int pasX, int pasY) {
        int compteur = 0;
        int motifCourant = 0;

        int xCourant = debutX;
        int yCourant = debutY;

        int[][] grille = this.partie.getGrille();
        int grilleTailleY = this.partie.getGrilleCol();
        int grilleTailleX = this.partie.getGrilleLigne();

        motifCourant = grille[xCourant][yCourant];

        // Recherche de quatre jetons alignés selon la position de départ et le pas
        while ((xCourant < grilleTailleX) && (yCourant < grilleTailleY) && (xCourant >= 0)) {
            if (grille[xCourant][yCourant] != motifCourant) {
                // Le motif n'est pas le même donc réinitialisation
                compteur = 1;
                motifCourant = grille[xCourant][yCourant];
            } else {
                // Le motif est le même, incrémentation du compteur
                compteur++;
            }

            // Il y a quatre jetons alignés sur le plateau
            if (compteur == 4 && motifCourant != 0)
                return true;

            xCourant += pasX;
            yCourant += pasY;
        }

        return false;
    }

    public int caseDisponible(int y) {
        // Recherche de la première case disponible dans la colonne choisie
        // S'il n'y en as pas, retourne -1
        int xCourant = this.partie.getGrilleLigne() - 1;
        while (xCourant >= 0) {
            if (this.partie.getGrille()[xCourant][y] != 0) {
                xCourant--;
            }
            else
                return xCourant;
        }
        return -1;
    }

    public boolean estPlein() {
        for (int x = 0; x < this.partie.getGrilleLigne(); x++) {
            for (int y = 0; y < this.partie.getGrilleCol(); y++) {
                // Si une case est vide, la grille n'est pas pleine
                if (this.partie.getGrille()[x][y] == 0)
                    return false;
            }
        }

        // Si aucune case vide n'a été trouvée, la grille est pleine
        return true;
    }
}
