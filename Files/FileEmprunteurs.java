/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de gérer les entrées et sorties sur le fichiers Emprunteurs.txt
*/

package Files;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class FileEmprunteurs {

    private String chemin;

    public FileEmprunteurs(String chemin) {
        this.chemin = chemin;
    }

    /* Recupération de tous les Emprunteurs présents dans le fichier puis affichage */

    public List<String> recupererTousLesEmprunteurs() {
        List<String> listEmprunteur = new ArrayList<>();
        try {
            File myObj = new File(this.chemin);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listEmprunteur.add(data);
            }
            myReader.close();
            for (int i = 0; i < listEmprunteur.size(); i++) {
                System.out.println((i + 1) + " - " + listEmprunteur.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur rencontrée ...");
            e.printStackTrace();
        }

        return listEmprunteur;
    }

    /* Ajout d'un emprunteur à la dernière ligne du fichier Emprunteurs.txt */

    public void ajouterEmprunteurAuFichier(String nom, String prenom, int numeroRue, String rue, String cp,
            String ville) {

        try {

            // Le fichier d'entrée
            File file = new File(this.chemin);
            int nbrLignes = 0;
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String str;
            // Lire le contenu du fichier
            while ((str = br.readLine()) != null) {
                nbrLignes++;
            }
            fr.close();

            try {
                FileWriter writer = new FileWriter(this.chemin);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                for (int i = 0; i < nbrLignes + 1; i++) {
                    if (i <= nbrLignes - 1) {
                        bufferedWriter.write("Nom_" + (i + 1));
                        bufferedWriter.write(" ");
                        bufferedWriter.write("Prenom_" + (i + 1) + "");
                        bufferedWriter.write(" ");
                        bufferedWriter
                                .write((i + 22) + "-Rue_National-" + (i * 500) + "-Ville_n°_" + (i + 1) + "\n");
                    } else {
                        bufferedWriter.write(nom);
                        bufferedWriter.write(" ");
                        bufferedWriter.write(prenom);
                        bufferedWriter.write(" ");
                        bufferedWriter
                                .write(numeroRue + "-Rue_" + rue + "-" + cp + "-" + ville + "\n");
                    }
                }

                bufferedWriter.close();
                writer.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de l'écriture dans le fichier");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Erreur lors de l'écriture dans le fichier");
            e.printStackTrace();
        }
    }

    /* Suppression de l'élement à la ligne dont le numero est passé en paramètre */

    public void supprimerEmprunteur(int numeroLigne) {
        try {
            FileWriter writer = new FileWriter(this.chemin);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < 20; i++) {
                if (i + 1 != numeroLigne) {

                    bufferedWriter.write("Nom_" + (i + 1));
                    bufferedWriter.write(" ");
                    bufferedWriter.write("Prenom_" + (i + 1) + "");
                    bufferedWriter.write(" ");
                    bufferedWriter
                            .write((i + 22) + "-Rue_National-" + (i * 500) + "-Ville_n°_" + (i + 1) + "\n");
                }

            }

            bufferedWriter.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de l'écriture dans le fichier");
            e.printStackTrace();
        }
    }

    public void modifierEmprunteur(int numeroLigne, String nom, String prenom, int numeroRue, String rue, String cp,
            String ville) {
        try {
            FileWriter writer = new FileWriter(this.chemin);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < 20; i++) {
                if (i + 1 != numeroLigne) {

                    bufferedWriter.write("Nom_" + (i + 1));
                    bufferedWriter.write(" ");
                    bufferedWriter.write("Prenom_" + (i + 1) + "");
                    bufferedWriter.write(" ");
                    bufferedWriter
                            .write((i + 22) + "-Rue_National-" + (i * 500) + "-Ville_n°_" + (i + 1) + "\n");
                } else {
                    this.ajouterEmprunteurAuFichier(nom, prenom, numeroRue, rue, cp, ville);
                }
            }

            bufferedWriter.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de l'écriture dans le fichier");
            e.printStackTrace();
        }
    }

    /* Rechercher des informations sur un emprunteur */
    public void rechercher(List<String> listEmprunteur, String nom) {
        FileEmprunteurs fichierEmprunteurs = new FileEmprunteurs(this.chemin);

        listEmprunteur = fichierEmprunteurs.recupererTousLesEmprunteurs();

        for (String element : listEmprunteur) {
            if (element.contains(nom)) {
                System.out.println("\n\n Element trouvé : " + element + "\n\n");
                break;
            }
        }
    }

}
