/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de contenir l'ensemble des fonctionnalités de la classe Adresse
*/

package vehicule;

public class Addresse {
    private int numero;
    private String rue;
    private String cp;
    private String ville;

    public Addresse(int numero, String rue, String cp, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }

    /* Constructeur par recopie */
    public Addresse(Addresse address)
    {
        numero = address.numero;
        rue = address.rue;
        cp = address.cp;
        ville = address.ville;
    }

    @Override
    public String toString() {
        return this.numero + " " + this.rue + " " + this.cp + " " + this.ville;
    }
}
