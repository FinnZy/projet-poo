package jeu;

public class Partie {
    int[][] grille;

    int vide = 0;
    int x = 1;
    int o = 2;
    int grilleLigne;
    int grilleCol;

    //Constructors
    Partie() {
        setGrilleLigne(6);
        setGrilleCol(7);
        creerGrille(this.getGrilleLigne(), this.getGrilleCol());
    }

    void creerGrille(int ligne, int colonne) {
        grille = new int[ligne][colonne];
        for (int l = 0; l < ligne; l++) {
            for (int c = 0; c < colonne; c++) {
                grille[l][c] = vide;
            }
        }
    }

    char getMotifAffichage(int motif) {
        if (motif == 0) return '.';
        else if (motif == 1) return 'x';
        else return 'o';
    }

    void afficherGrille(Partie p) {
        String s = new String();
        int[][] grille = p.getGrille();
        s = s + "1";
        for (i = 2; i <= p.getGrilleCol; i++) {
            s = s + " " + i.toString();
        }
        System.out.println(s);
        for (j = 1; j <= p.getGrilleLigne; j++) {
            s = "\0";
            for (i = 1; i <= p.getGrilleCol; i++) {
                s = s + getMotifAffichage(grille[j][i]) + " ";
            }
            System.out.println(s);
        }
        System.out.println("$ ");
    }

    //Setters & Getters
    int[][] getGrille() { return this.grille; }
    int getGrilleLigne() { return this.grilleLigne; }
    int getGrilleCol() { return this.grilleCol; }
    void setGrilleTailleX(int grilleLigne) { this.grilleLigne = grilleLigne; }
    void setGrilleTailleY(int grilleCol) { this.grilleCol = grilleCol; }
    void setCaseGrille(int colonne, int motif) {
        int ligne = caseDisponible(colonne);
        if (ligne != -1) {
            this.grille[ligne][colonne] = motif;
        }
    }

    int caseDisponible(int y) {
        int currX = 0;

        while (currX < grilleLigne) {
            if (grille[currX][y] != 0)
                currX++;
            else
                return currX;
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
