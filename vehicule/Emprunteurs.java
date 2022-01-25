/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il représente le conteneur d'Emprunteurs'
*/

package vehicule;

import java.util.ArrayList;
import java.util.List;

public class Emprunteurs {

    private List<Emprunteur> Emprunteurs;

    // Constructeur
    public Emprunteurs() {
        this.Emprunteurs = new ArrayList<>();
    }

    // Getter
    public Emprunteur get(int index) {
        return Emprunteurs.get(index);
    }

    /* Ajouter un emprunteur ... */
    public void add(Emprunteur empreunteur) {
        if (!Emprunteurs.contains(empreunteur)) {
            Emprunteurs.add(empreunteur);
        }
    }

    /* Supprimer un emprunteur */
    public void remove(Emprunteur empreunteur) {
        try {
            System.out.println("Tente d'effacer ...");
            Emprunteurs.remove(empreunteur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Lister tous les elements */
    public List<Emprunteur> afficherTousLesElements() {
        List<Emprunteur> allEmprunteurs = new ArrayList<>();
        for (int i = 0; i < Emprunteurs.size(); i++) {
            allEmprunteurs.add(Emprunteurs.get(i));
        }
        // retourne un element de type Emprunteur
        return allEmprunteurs;
    }

    /* Recherche Emprunteurs selon le nom ... */
    public List<Emprunteur> selectByBrand(String nom) {
        List<Emprunteur> selectedEmprunteurs = new ArrayList<>();
        for (int i = 0; i < Emprunteurs.size(); i++) {
            Emprunteur empreunteur = Emprunteurs.get(i);
            if (empreunteur.nom == nom) {
                selectedEmprunteurs.add(empreunteur);
            }
        }
        // retourne un element de type Emprunteur
        return selectedEmprunteurs;
    }

}
