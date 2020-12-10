package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EcrireFichier {

    File log;
    FileWriter writer;

    public EcrireFichier() throws IOException {
        this.log = new File("puissance4.log");
        this.writer = new FileWriter(this.log);
    }

    public void writeName(int numeroJoueur, String name) {
        try {
            String completeName = "Joueur " + numeroJoueur + " est " + name + "\n";
            writer.write(completeName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeManche() {
        try {
            String ligneManche = "Manche commence\n";
            writer.write(ligneManche);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePartieFinie() {
        try {
            String partieFinie = "Partie finie\n";
            writer.write(partieFinie);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeActions(String name, int numero, int caseToWrite){
        try {
            String affichageAction = "Joueur " + numero + " joue " + caseToWrite + "\n";
            writer.write(affichageAction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMancheTransition(int score1, int score2, int numero, int pointsMax) {
        try {
            String affichageVictoire = null;

            // Gestion cas victoire ou egalite
            if(numero == -1) {
                affichageVictoire = "Egalite\n";
            } else {
                affichageVictoire = "Joueur " + numero + " gagne\n";
            }

            String affichageScore = "Score " + score1 + " - " +  score2 + "\n";

            writer.write(affichageVictoire);
            writer.write(affichageScore);

            // Gestion nombre de manches remportees
            if(score1 + score2 == pointsMax) {
                writePartieFinie();
            } else {
                writeManche();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireErreurSaisie(String type, String numero) {
        try {
            String affichageErreurSaisie = "Erreur saisie " + type + " " + numero + "\n";
            writer.write(affichageErreurSaisie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrireErreurColonne(String type, String numero) {
        try {
            String affichageErreurColonne = "Erreur colonne " + type + " " + numero + "\n";
            writer.write(affichageErreurColonne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
