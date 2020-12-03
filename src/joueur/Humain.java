package joueur;

import jeu.*;
import java.util.Scanner;

public class Humain extends Joueur {


    public Humain(int motif, String nom){
        super(motif, nom);
    }

    public String getNom(){
        return this.nom;
    }

    public int getMotif(){
        return this.motif;
    }

    public int jouerTour(Partie partie) {
        Analyse analyse = new Analyse(partie);
        boolean aDeposer = true;
        if(analyse.estPlein()){
            aDeposer = false;
        }
        else{
            while(aDeposer){

                Scanner sc = new Scanner(System.in);
                double x = sc.nextDouble();
                if(x <= 7 && x > 0){
                    System.out.println("Entrer un nombre compris entre 1 et 7");
                }

                else{
                    int y = 6;
                    if(analyse.caseDisponible(y) == -1){
                        aDeposer = true;
                    }

                    else {
                        partie.setCaseGrille((int) x, this.getMotif());
                        aDeposer = false;
                    }
                }

            }
        }

        return 0;
    }


}
