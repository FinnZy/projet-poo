package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EcrireFichier {

    File log;
    FileWriter ecrivain;

    public EcrireFichier() throws IOException {
        this.log = new File("log.txt");
        this.ecrivain = new FileWriter(this.log);
    }

    public void ecrireNom(int numeroJoueur, String nom) {
        try {
            String nomComplet = "Joueur " + numeroJoueur + " est " + nom + "\n";
            ecrivain.write(nomComplet);
            ecrivain.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireManche() {
        try {
            String ligneManche = "Manche commence\n";
            ecrivain.write(ligneManche);
            ecrivain.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrirePartieFinie() {
        try {
            String partieFinie = "Partie finie\n";
            ecrivain.write(partieFinie);
            ecrivain.flush();
            ecrivain.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireActions(int numero, int colonne){
        try {
            String affichageAction = "Joueur " + numero + " joue " + colonne + "\n";
            ecrivain.write(affichageAction);
            ecrivain.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireMancheTransition(int score1, int score2, int numero, int pointsMax) {
        try {
            String affichageVictoire = null;

            // Gestion cas victoire ou egalite
            if(numero == -1) {
                affichageVictoire = "Egalite\n";
            } else {
                affichageVictoire = "Joueur " + numero + " gagne\n";
            }

            String affichageScore = "Score " + score1 + " - " +  score2 + "\n";

            ecrivain.write(affichageVictoire);
            ecrivain.write(affichageScore);
            ecrivain.flush();

            // Gestion nombre de manches remportees
            if(score1 + score2 == pointsMax) {
                ecrirePartieFinie();
            } else {
                ecrireManche();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireErreurSaisie(String type, String numero) {
        try {
            String affichageErreurSaisie = "Erreur saisie " + type + " " + numero + "\n";
            ecrivain.write(affichageErreurSaisie);
            ecrivain.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireErreurColonne(String type, String numero) {
        try {
            String affichageErreurColonne = "Erreur colonne " + type + " " + numero + "\n";
            ecrivain.write(affichageErreurColonne);
            ecrivain.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
