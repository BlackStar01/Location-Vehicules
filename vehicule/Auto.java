/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de contenir l'ensemble des fonctionnalités de la classe Auto -> Enfant de la classe Vehicule
*/

package vehicule;

public class Auto extends Vehicule {

    private String modele;

    public Auto(String modele, String marque)
    {
        super(marque);
        this.modele = modele;
    }

    @Override
    public String toString() {
        return super.toString() + "\nModele : " + this.modele;
    }
}
