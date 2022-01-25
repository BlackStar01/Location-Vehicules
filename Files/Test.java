/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de gérer créer l'ensemble des emprunteurs et vehicules par défaut dans les fichiers
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Test {
    public static void main(String[] args) {
        File file = new File("./Vehicules.txt");
        File file2 = new File("./Emprunteurs.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter writer = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                for (int i = 0; i < 15; i++) {
                    bufferedWriter.write("Marque_moto_numero_" + (i + 1) + ",");
                    bufferedWriter.write(i * 4 + "cc\n");
                }

                for (int i = 0; i < 15; i++) {
                    bufferedWriter.write("Marque_auto_standard_numero_" + (i + 1) + ",");
                    bufferedWriter.write("" + i * 2 + i * 2 + "_modele_standard\n");
                }

                for (int i = 0; i < 20; i++) {
                    bufferedWriter.write("Marque_auto_luxe_numero_" + (i + 1) + ",");
                    bufferedWriter.write((i * 3 + 6) + "_modele_luxieux\n");
                }

                bufferedWriter.close();
                writer.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de l'écriture dans le fichier");
                e.printStackTrace();
            }
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter writer = new FileWriter(file2);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                for (int i = 0; i < 20; i++) {
                    bufferedWriter.write("Nom_" + (i + 1));
                    bufferedWriter.write(" ");
                    bufferedWriter.write("Prenom_" + (i + 1) + "");
                    bufferedWriter.write(" ");
                    bufferedWriter
                            .write((i + 22) + "-Rue_National-" + (i * 500) + "-Ville_n°_" + (i + 1)+"\n");
                }

                bufferedWriter.close();
                writer.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de l'écriture dans le fichier");
                e.printStackTrace();
            }
        }

    }
}
