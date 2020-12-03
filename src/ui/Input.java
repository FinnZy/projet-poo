package ui;

import java.util.Scanner;

public class Input {
    private String nom;
    private String type;

    public Input() {

    }

    public void initialiserJeu(int i) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.printf("Joueur %d?\n", i);

        String inputString = myObj.nextLine();  // Read user input
        int a = inputString.indexOf(' ');
        String splittedString1 = inputString.substring(0, a);
        String splittedString2 = inputString.substring(a + 1);

        setJoueurType(splittedString1);
        setJoueurNom(splittedString2);
    }

    public String getJoueurNom() {
        return this.nom;
    }

    public String getJoueurType() {
        return this.type;
    }

    public void setJoueurNom(String nom) {
        this.nom = nom;
    }

    public void setJoueurType(String type) {
        this.type = type;
    }
}
