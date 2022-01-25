/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de gérer les entrées et sorties sur le fichiers Vehicules.txt
*/

package Files;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class FileVehicule {
    private String chemin;

    public FileVehicule(String chemin) {
        this.chemin = chemin;
    }

    /* Recupération de tous les Vehicules présents dans le fichier puis affichage */
    public List<String> recupererTousLesVehicule() {
        List<String> listVehicule = new ArrayList<>();
        try {
            File myObj = new File(this.chemin);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listVehicule.add(data);
            }
            myReader.close();
            for (int i = 0; i < listVehicule.size(); i++) {
                System.out.println((i + 1) + " - " + listVehicule.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur rencontrée ...");
            e.printStackTrace();
        }

        return listVehicule;
    }
}
