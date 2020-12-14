package ui;

import java.util.Scanner;

public class Entree {
    private String nom;
    private String type;
    private EcrireFichier ef;

    public Entree(EcrireFichier ef) {
        this.ef = ef;
    }

    public void initialiserJeu(int i) {
        Scanner ligneSaisie = new Scanner(System.in);  // Création d'un objet de type Scanner

        // Déclaration des deux chaînes de caractères correspondant au nom et au type
        String chaineDeCaracteres1 = "";
        String chaineDeCaracteres2 = "";

        while (!chaineDeCaracteres1.equalsIgnoreCase("humain") && !chaineDeCaracteres1.equalsIgnoreCase("ia")) {
            System.out.printf("Joueur %d?\n", i);

            String chaineEntree = ligneSaisie.nextLine();  // Lecture de l'entrée utilisateur
            int a = chaineEntree.indexOf(' ');  // Récupération de l'index du premier espace

            // Dans le cas où le joueur saisit "sortir"
            if (chaineEntree.equalsIgnoreCase("sortir")) {
                System.exit(0);
            }

            // Deux cas : il n'y a pas d'espace ou il y en a un
            if (a == -1) {
                System.out.println("Erreur saisie Joueur " + i);
                ef.ecrireErreurSaisie("Joueur", String.valueOf(i));
            } else {
                // Séparation des deux arguments
                chaineDeCaracteres1 = chaineEntree.substring(0, a);
                chaineDeCaracteres2 = chaineEntree.substring(a + 1);

                // Vérification du type de joueur
                if (!chaineDeCaracteres1.equalsIgnoreCase("humain") && !chaineDeCaracteres1.equalsIgnoreCase("ia")) {
                    System.out.println("Erreur saisie Joueur " + i);
                    ef.ecrireErreurSaisie("Joueur", String.valueOf(i));
                }
            }
        }

        setJoueurType(chaineDeCaracteres1);
        setJoueurNom(chaineDeCaracteres2);
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
