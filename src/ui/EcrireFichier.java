package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EcrireFichier {

    File log;

    public EcrireFichier(int motif, String nom){

        this.log = new File("log.txt");

    }

    private void writeName(String name1, String name2) {
        FileWriter writer = null;
        try {
            String completeName1 = "Joueur 1 est" + name1;
            String completeName2 = "Joueur 2 est" + name1;
            String debutPartie = "Manche commence";
            writer = new FileWriter(this.log);
            writer.write(completeName1);
            writer.write(completeName2);
            writer.write(debutPartie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void writeActions(String name, int numero, int caseToWrite){
        FileWriter writer = null;
        try {
            String numeroJoueur = String.valueOf(numero);
            String positionCaseX = String.valueOf(caseToWrite);
            String affichageAction = "Joueur" + numeroJoueur + "joue" + positionCaseX;

            writer = new FileWriter(this.log);
            writer.write(affichageAction);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeMancheTransition(int score1, int score2, int numero){
        FileWriter writer = null;
        try {
            String numeroJoueur = String.valueOf(numero);

            String affichageVictoire = null;
            String affichageEtatJeu = null;

            // Gestion cas victoire ou egalite

            if(score1 < score2 || score1 > score2){
                affichageVictoire = "Joueur" + numeroJoueur + "gagne" ;
            }

            else{
                affichageVictoire = "Egalite" ;
            }

            String affichageScore = "score :" + score1 + "-" +  score2 ;

            // Gestion nombre de manches remportees

            if(score1 >= 3 || score2 >= 3){
                affichageEtatJeu = "Partie finie" ;
            }

            else{
                affichageEtatJeu = "Manche commence" ;
            }



            writer = new FileWriter(this.log);
            writer.write(affichageVictoire);
            writer.write(affichageScore);
            writer.write(affichageEtatJeu);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
