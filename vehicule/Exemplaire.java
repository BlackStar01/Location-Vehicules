/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de créer l'ensemble des fonctionnalités de la classe Exemplaire
*/

package vehicule;

public class Exemplaire {
    protected int numero_exemplaire;
    private float kilometres;
    private Vehicule vehicule;
    private long duree;
    protected int prixDeBase = 3500;
    protected int prix_total = 3500;
    protected int carburant = 100;
    private boolean estAssuré = false;
    private final int PRIX_ASSURANCE = 350;
    private final int DUREE_NORMALE_LOCATION = 30;
    private final int PRIX_VIOLATION_DUREE = 400;
    private final double PRIX_100_KILOMETRES = 0.30;
    private final int PRIX_VOITURE_ENDOMMAGE = 1000;

    public Exemplaire(Vehicule vehicule, int numero_exemplaire, float kilometres, long duree) {
        this.numero_exemplaire = numero_exemplaire;
        this.kilometres = kilometres;
        this.vehicule = vehicule;
        this.duree = duree;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public int getPrix_de_base() {
        return prixDeBase;
    }

    /*
     * Pour ajouter les kilomètres lorsque le vehicule est de retour de location
     * Maximum 180 000 km pour un exemplaire de vehicule
     */
    public void parcourirKilometres(float kilometres) {

        if ((this.kilometres + kilometres) >= 180000) {
            throw new ArithmeticException("Refusé, Pour excès de kilométrages");
        } else {
            /*
             * On ajoute les kilomètres que l'emprunteur a eu à faire aux kilomètres
             * initiaux
             */
            this.kilometres += kilometres;
            long supplement = Math.round((this.kilometres / 100) * this.PRIX_100_KILOMETRES);
            if (kilometres / 100 != 0) {
                /* Compte 10 Euros pour chaque 100 km parcourus */
                this.prix_total += supplement;
            }
            System.out.println("Kilomètres mis à jour avec succès ... + (" + supplement + " Euros)");
        }
    }

    public void endommager() {
        System.out.println(" Vous avez endommagé le véhicule\n");
        if (this.estAssuré == true) {
            System.out.println("Aucun frais supplémentaire, vous disposez d'une assurance \n");
        } else {
            this.prix_total += this.PRIX_VOITURE_ENDOMMAGE;
            System.out.println(" Vous ne disposez pas d'une assurance, " + this.PRIX_VOITURE_ENDOMMAGE
                    + " Euros seront ajoutés à votre facture");
        }
    }

    /*
     * Gestion de la consommation de carburant
     * Erreur si carburant négatif
     * Ajout d'une certaine somme en fonction de la quantité actuelle de carburant
     */
    public void consommerCarburant(int carburant) {
        if ((this.carburant - carburant) <= 0) {
            throw new ArithmeticException("Refusé, Pour manque de carburant ");
        } else {
            this.carburant -= carburant;
            if (this.carburant < 25) {
                this.prix_total += (this.prixDeBase * 0.75);
            } else if (this.carburant >= 25 && this.carburant < 50) {
                this.prix_total += (this.prixDeBase * 0.50);
            } else if (this.carburant >= 50 && this.carburant <= 75) {
                this.prix_total += (this.prixDeBase * 0.25);
            }
            System.out.println("Carburant mis à jour avec succès \n");
        }
    }

    public void verifierDureeLocation() {
        if (this.duree > DUREE_NORMALE_LOCATION) {
            System.out.println("Votre location a durée plus de 30 jours...");
            this.prix_total += PRIX_VIOLATION_DUREE;
        }
    }

    /* Donner une assurance à un vehicule */
    public void assurer() {
        if (estAssuré) {
            throw new ArithmeticException("Vous êtes déja assuré conte les accidents");
        } else {
            System.out.println("Assurance ajoutée avec succès...\n");
            this.prix_total += this.PRIX_ASSURANCE;
            this.estAssuré = true;
        }

    }

    public void louer() {
        /* Au debut de la location, on initialise les kilometres */
        this.parcourirKilometres(0);
        System.out.println(
                this.vehicule.toString() + " exemplaire number " + this.numero_exemplaire
                        + " est envoyé en location... Kilométrage : " + this.kilometres);
        /*
         * Ecrire des fonctions pour modifiers d'autres elements
         */
    }

    @Override
    public String toString() {
        return "Marque : " + this.vehicule.toString() + "\nNumero de l'exemplaire: " + this.numero_exemplaire
                + "\nKilométrage: " + this.kilometres + "\nCarburant : " + this.carburant + " Litres"
                + "\nDurée de location : " + this.duree + " Jours ... "
                + "\nAssuré : " + this.estAssuré;
    }

}
