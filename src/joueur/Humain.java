package joueur;

import jeu.*;
import ui.EcrireFichier;

import java.util.Random;
import java.util.Scanner;

public class Humain extends Joueur {

    public Humain(int motif, String nom) {
        super(motif, nom);
    }

    public int jouerTour(Partie partie, EcrireFichier ef, Random aleatoire) {
        Analyse analyse = new Analyse(partie);
        boolean estUnNombre = true;
        boolean aDeposer = true;

        while (aDeposer) {
            aDeposer = true;
            Scanner sc = new Scanner(System.in);
            String valeurLigne = sc.nextLine();

            for (char c : valeurLigne.toCharArray()) {
                if (!Character.isDigit(c) && c != '-' && c != '+')
                    estUnNombre = false;
            }

            if (estUnNombre) {
                int x = Integer.valueOf(valeurLigne);
                if (x > 7 || x < 1) {
                    System.out.println("Erreur colonne non valide " + x);
                    ef.ecrireErreurColonne("non valide", valeurLigne);
                    aDeposer = true;
                } else {
                    x--;
                    int verif = partie.setCaseGrille(x, this.getMotif(), analyse);
                    ef.ecrireActions(this.getNumeroJoueur(), x + 1);
                    if (verif == -1) {
                        aDeposer = true;
                    } else {
                        aDeposer = false;
                    }
                }
            } else {
                if (valeurLigne.equalsIgnoreCase("sortir")) {
                    System.exit(0);
                } else {
                    System.out.println("Erreur saisie colonne " + valeurLigne);
                    ef.ecrireErreurSaisie("colonne", valeurLigne);
                }
            }
        }
        return 0;
    }
}
