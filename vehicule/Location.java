/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet d'associer la date de location à une location de voiture donnée
*/


package vehicule;

public class Location {
    private int numero_location;
    private Date debut_location;
    private Date fin_location;
    private Emprunteur emprunteur;

    /* L'emprunteur prend déja en pramaetre l'exemlplaire  */

    public Location(int numero_location, Date debut_location, Date fin_location, Emprunteur emprunteur)
    {
        this.numero_location = numero_location;
        this.debut_location = debut_location;
        this.fin_location = fin_location;
        this.emprunteur = emprunteur;
    }

    @Override
    public String toString() {
        String message = "\nDebut: " + this.debut_location + "\nFin ... " + this.fin_location;
        
        return message;
    }

    
    
}
