/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de créer l'ensemble des fonctionnalités de la classe Emprunteur
*/

package vehicule;

public class Emprunteur {

    private int id;
    protected String nom;
    private String prenom;
    private Addresse adresse;
    private Exemplaire exemplaire;

    public Emprunteur(Exemplaire exemplaire, int id, String nom, String prenom, Addresse adresse) {
        this.id = id;
        this.exemplaire = exemplaire;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Addresse getAdresse() {
        return adresse;
    }

    public void louer() {

        System.out.println("\n\n------------------------- D E V I S    I N I T A L -----------------------\n\n");
        System.out.println("----> INFORMATIONS LOUEUR \n");
        System.out.println("Nom : " + this.getNom());
        System.out.println("Prenom : " + this.getPrenom());
        System.out.println("Adresse : " + this.getAdresse());
        System.out.println("\n----> INFORMATIONS VEHICULE LOUÉ \n");
        System.out.println(this.exemplaire.toString());
        System.out.println();

        System.out.println("\n\nFACTURE TEMPORAIRE: " + exemplaire.getPrix_de_base() + " Euros (€)" + "\n\n");

        System.out.println(
                "\n--------------------------  F I N    D E V I S    I N I T A L  ------------------------\n\n");

    }

    public void ramener() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n------------------------- D E V I S    F I N A L -----------------------\n\n");
        System.out.println("----> INFORMATIONS LOUEUR \n");
        System.out.println("Nom : " + this.getNom());
        System.out.println("Prenom : " + this.getPrenom());
        System.out.println("Adresse : " + this.getAdresse());
        System.out.println("\n----> INFORMATIONS VEHICULE \n");
        System.out.println(this.exemplaire.toString());

        System.out.println("\n\nMONTANT TOTAL À PAYER : " + exemplaire.getPrix_total() + " Euros (€)" + "\n\n");

        System.out
                .println("\n--------------------------  F I N    D E V I S    F I N A L  ------------------------\n\n");

    }

    @Override
    public String toString() {
        return "Loueur " + this.prenom + " " + this.nom + " habitant à " + this.adresse + " a loué "
                + this.exemplaire.toString();
    }
}
