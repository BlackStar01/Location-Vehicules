/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il représente le conteneur de Vehicules
*/


package vehicule;

import java.util.ArrayList;
import java.util.List;

public class Vehicules {

    private List<Vehicule> Vehicules;

    // Constructeur
    public Vehicules() {
        this.Vehicules = new ArrayList<>();
    }

    // Getter
    public Vehicule get(int index) {
        return Vehicules.get(index);
    }

    // Ajouter un exemplaire ... 
    public void add(Vehicule vehicule) {
        if(!Vehicules.contains(vehicule)) {
            Vehicules.add(vehicule);
        }
        else
        {
            System.out.println("Déja dedans ...");
        }
    }

    // Supprimer un exemplaire
    public void remove(Vehicule vehicule) {
        try {
            System.out.println("Tente d'effacer ...");
            Vehicules.remove(vehicule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Lister tous les elements */
    public List<Vehicule> afficherTousLesElements() {
        List<Vehicule> allVehicules = new ArrayList<>();
        for (int i = 0; i < Vehicules.size(); i++) {
            allVehicules.add(Vehicules.get(i));
        }
        
        return allVehicules;
    }

    /* Recherche exemplaires selon la marque */
    public List<Vehicule> selectByBrand(String brand) {
        List<Vehicule> selectedCars = new ArrayList<>();
        for (int i = 0; i < Vehicules.size(); i++) {
            Vehicule vehicule = Vehicules.get(i);
            if (vehicule.marque.equals(brand)) {
                selectedCars.add(vehicule);
            }
        }

        //retourne un tableau content des Vehicules ... un tableau
        return selectedCars;
    }

}
