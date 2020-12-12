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
        boolean aDeposer = true;
        boolean estUnNombre = false;

        if(analyse.estPlein()) {
            return 1;
        } else {
            while(aDeposer) {
                estUnNombre = true;
                Scanner sc = new Scanner(System.in);
                String valeurLigne = sc.nextLine();

                for (char c : valeurLigne.toCharArray()) {
                    if (!Character.isDigit(c))
                        estUnNombre = false;
                }

                if (estUnNombre) {
                    int x = Integer.valueOf(valeurLigne);
                    if (x > 7 || x < 1) {
                        System.out.println("Entrer un nombre compris entre 1 et 7");
                        ef.ecrireErreurColonne("non valide", valeurLigne);
                    } else {
                        x--;
                        int verif = partie.setCaseGrille(x, this.getMotif(), analyse);
                        if (verif == -1) {
                            aDeposer = true;
                        } else {
                            ef.ecrireActions(this.getNumeroJoueur(), x + 1);
                            aDeposer = false;
                        }
                    }
                } else {
                    System.out.println("Seuls les nombres compris entre 1 et 7 sont autorisés");
                    ef.ecrireErreurSaisie("colonne", valeurLigne);
                }
            }
        }
        return 0;
    }
}
