/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de créer l'ensemble des fonctionnalités de la classe Vehicule
*/

package vehicule;

public abstract class Vehicule {
    protected String marque;

    public Vehicule(String marque)
    {
        this.marque = marque;
    }

    public Vehicule(Vehicule vehicule)
    {
        marque = vehicule.marque;
    }

    @Override
    public String toString() {
        return this.marque;
    }

}
