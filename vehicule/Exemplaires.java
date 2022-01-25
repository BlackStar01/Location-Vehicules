/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il représente le conteneur de Exemplaires
*/

package vehicule;

import java.util.ArrayList;
import java.util.List;

public class Exemplaires {

    private List<Exemplaire> Exemplaires;

    // Constructeur 
    public Exemplaires() {
        this.Exemplaires = new ArrayList<>();
    }

    //  Getter
    public Exemplaire get(int index) {
        return Exemplaires.get(index);
    }


    /* Ajouter un exemplaire ... */
    public void add(Exemplaire exemplaire) {
        if(!Exemplaires.contains(exemplaire)) {
            Exemplaires.add(exemplaire);
        }
    }

    /* Supprimer un exemplaire */
    public void remove(Exemplaire exemplaire) {
        try {
            System.out.println("Tente d'effacer ...");
            Exemplaires.remove(exemplaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Lister tous les elements */
    public List<Exemplaire> afficherTousLesElements() {
        List<Exemplaire> allExemplaires = new ArrayList<>();
        for (int i = 0; i < Exemplaires.size(); i++) {
            allExemplaires.add(Exemplaires.get(i));
        }
        
        return allExemplaires;
    }

    /* Recherche exemplaires selon la marque */
    public List<Exemplaire> selectByBrand(int numero) {
        List<Exemplaire> selectedExemplaires = new ArrayList<>();
        for (int i = 0; i < Exemplaires.size(); i++) {
            Exemplaire exemplaire = Exemplaires.get(i);
            if (exemplaire.numero_exemplaire == numero) {
                selectedExemplaires.add(exemplaire);
            }
        }
        //  retourne un element de type Exemplaire
        return selectedExemplaires;
    }

}
