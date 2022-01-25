/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de lancer notre application LOCATION en faisant
* "javac Test.java" puis "java Test"
*/

// Importation des packages nécessaires
import vehicule.Exemplaire;
import vehicule.Moto;
import vehicule.Auto;
import vehicule.Date;
import vehicule.Location;
import vehicule.Emprunteur;
import vehicule.Addresse;
import Files.FileEmprunteurs;
import Files.FileVehicule;

// Import des classes Java nécessaires

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        System.out.println(
                "\n---------------------------------  I N S T R U C T I O N S    ---------------------------------\n");
        System.out.println("- Chaque location ne doit pas durer plus de 30 jours sinon , ajout d'un supplement");
        System.out.println("- Chaque 100 kilomètres, vous êtes facturés 0.30 Euros");
        System.out.println("- Vous n'êtes pas autorisé à rouler plus de 18 000 kilomètres");
        System.out.println("- Le prix de base d'une location de 30 jours maximun est de 3500 Euros");
        System.out.println("- Vous paierez 1000 Euros si vous endommagez le vehicule loué");
        System.out.println("- Chaque vehicule dispose de 100 Litres de carburant inititalement");

        System.out.println(
                "\n\n-----------------------\t L O C A T I O N     V E H I C U L E S \t-----------------------\n\n");

        System.out.println("\n Quelle est votre date de début de location ? ....Format JJ/MM/AAAA");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez jour ... ");
        int jourDebut = scanner.nextInt();
        System.out.println("Entrez le numero du mois ... ");
        int moisDebut = scanner.nextInt();
        System.out.println("Entrez l'année ... ");
        int anDebut = scanner.nextInt();
        Date dateDeDebut = new Date(jourDebut, moisDebut, anDebut);

        System.out.println("\n Quelle est votre date de fin de location ? ....Format JJ/MM/AAAA");

        System.out.println("Entrez jour ... ");
        int jourFin = scanner.nextInt();
        System.out.println("Entrez le numero du mois ... ");
        int moisFin = scanner.nextInt();
        System.out.println("Entrez l'année ... ");
        int anFin = scanner.nextInt();
        Date dateDeFin = new Date(jourFin, moisFin, anFin);

        /*
         * Verification si la durée de location est cohérente
         */
        if (dateDeDebut.differenceEntreDates(dateDeFin) <= 0) {
            throw new ArithmeticException("Erreur d'entrée de dates");
        }
        long dureeLocation = dateDeDebut.differenceEntreDates(dateDeFin);

        /*
         * Afficher la liste des emprunteurs en lisant dans le fichier
         */
        List<String> listEmprunteur = new ArrayList<>();
        FileEmprunteurs fichierEmprunteurs = new FileEmprunteurs("./Files/Emprunteurs.txt");

        System.out.println("\n-----------------  Liste des emprunteurs   -------------------\n");
        listEmprunteur = fichierEmprunteurs.recupererTousLesEmprunteurs();

        /*
         * Gestion des emprunteurs
         */
        boolean gererEmprunteurs = true;
        do {
            /* Pour arranger la vue dans la console */
            System.out.print("\033[H\033[2J");
            // Les différentes options ...
            System.out.println("\n\n-------------------------------------------------------------------\n");
            System.out.println("\t    G E S T I O N   D E S    E M P R U N T E U R S \n");
            System.out.println("Scroller vers le haut pour voir les emprunteurs déja enregistrés");
            System.out.println("-------------------------------------------------------------------\n");

            System.out.println("\n    Choisissez une option ... \n");
            System.out.println("1 - Rechercher un empreunteur par nom \n");
            System.out.println("2 - Insérer un empreunteur \n");
            System.out.println("3 - Supprimer un emprunteur \n");
            System.out.println("4 - Modifier un emprunteur  \n");
            System.out.println("5 - Liste de tous les emprunteurs  \n");
            System.out.println("6 - Sortir \n\n");
            System.out.println("Tapez un chiffre ...");

            int choixGestionEmprunteur = scanner.nextInt();

            switch (choixGestionEmprunteur) {
                case 1:
                    System.out.println("\n Entrez le nom de l'emprunteur recherché ...");
                    Scanner recherche = new Scanner(System.in);
                    String nomRecherche = recherche.nextLine();
                    fichierEmprunteurs.rechercher(listEmprunteur, nomRecherche);
                    break;
                case 2:
                    Scanner scannerEmprunteur = new Scanner(System.in);
                    System.out.println("Entrer le nom");
                    String nomAjouter = scannerEmprunteur.nextLine();
                    System.out.println("Entrer le prénom");
                    String prenomAjouter = scannerEmprunteur.nextLine();
                    System.out.println("Entrer le nom de la rue");
                    String rueAjouter = scannerEmprunteur.nextLine();
                    System.out.println("Entrer le code postal");
                    String cpAjouter = scannerEmprunteur.nextLine();
                    System.out.println("Entrer le nom de la ville");
                    String villeAjouter = scannerEmprunteur.nextLine();
                    System.out.println("Entrer le numero de la rue");
                    int numeroRueAjouter = scannerEmprunteur.nextInt();
                    if (nomAjouter != "" && prenomAjouter != "" && numeroRueAjouter != 0 && rueAjouter != ""
                            && cpAjouter != "" && villeAjouter != "") {
                        fichierEmprunteurs.ajouterEmprunteurAuFichier(nomAjouter, prenomAjouter, numeroRueAjouter,
                                rueAjouter, cpAjouter, villeAjouter);
                    } else {
                        throw new ArithmeticException("Erreur de saisie de donnée");
                    }
                    gererEmprunteurs = true;
                    break;
                case 3:
                    System.out.println("Entrez le numero de la ligne à supprimer");
                    fichierEmprunteurs.supprimerEmprunteur(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Entrez les informations du nouvel emprunteur");
                    Scanner scannerNewEmprunteur = new Scanner(System.in);
                    System.out.println("Entrer le nom");
                    String nomModifier = scannerNewEmprunteur.nextLine();
                    System.out.println("Entrer le prénom");
                    String prenomModifier = scannerNewEmprunteur.nextLine();
                    System.out.println("Entrer le nom de la rue");
                    String rueModifier = scannerNewEmprunteur.nextLine();
                    System.out.println("Entrer le code postal");
                    String cpModifier = scannerNewEmprunteur.nextLine();
                    System.out.println("Entrer le nom de la ville");
                    String villeModifier = scannerNewEmprunteur.nextLine();
                    System.out.println("Entrer le numero de la rue");
                    int numeroRueModifier = scannerNewEmprunteur.nextInt();

                    System.out.println("---> Entrez le numero de la ligne à supprimer");
                    fichierEmprunteurs.modifierEmprunteur(scannerNewEmprunteur.nextInt(), nomModifier, prenomModifier,
                            numeroRueModifier, rueModifier, cpModifier, villeModifier);
                    break;
                case 5:
                    fichierEmprunteurs.recupererTousLesEmprunteurs();
                    gererEmprunteurs = true;
                    break;
                case 6:
                    gererEmprunteurs = false;
                    break;

                default:
                    gererEmprunteurs = false;
                    break;

            }
        } while (gererEmprunteurs == true);

        /*
         * Donner la main à l'utilisateur de choisir son avatar
         * Les deux tableaux vont stocker les différentes composants de l'emprunteur
         */

        System.out.println("\n Qui êtes vous ?");
        System.out.println("Entrez un numero ...");
        String[] partsOfEmprunteur = {};
        String[] the_adress = {};

        try {
            String utilisateurActuel = listEmprunteur.get(scanner.nextInt() - 1);

            // split("\\s") pour les espaces vides entre les élements
            partsOfEmprunteur = utilisateurActuel.split("\\s");
            // split les " - " entre les élements
            the_adress = partsOfEmprunteur[2].split("-");

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * Afficher la liste des vehicules en lisant dans le fichier
         */
        List<String> listVehicule = new ArrayList<>();
        FileVehicule fichierVehicules = new FileVehicule("./Files/Vehicules.txt");

        listVehicule = fichierVehicules.recupererTousLesVehicule();

        System.out.println("\n Quel vehicule voulez vous ? ");
        Scanner scannerVehicule = new Scanner(System.in);
        int idVehiculeAcutel = scannerVehicule.nextInt() - 1;
        System.out.println(idVehiculeAcutel);

        try {
            String vehiculeAcutel = listVehicule.get(idVehiculeAcutel);

            // split les elements quand il rencontre une virgule
            String[] partsOfVehicule = vehiculeAcutel.split(",");

            if (idVehiculeAcutel <= 15) {
                Moto moto = new Moto(partsOfVehicule[1], partsOfVehicule[0]);
                Exemplaire exemplaire = new Exemplaire(moto, 01, 0, dureeLocation);
                Addresse addresse = new Addresse(Integer.parseInt(the_adress[0]), the_adress[1], the_adress[2],
                        the_adress[3]);
                Emprunteur emprunteur = new Emprunteur(exemplaire, 1, partsOfEmprunteur[0], partsOfEmprunteur[1],
                        addresse);

                /* La ligne suivante n'est pas utile... */
                Location location = new Location(0, dateDeDebut, dateDeFin, emprunteur);

                emprunteur.louer();

                /* Pour arranger la vue dans la console */
                System.out.print("\033[H\033[2J");

                /*
                 * Verification de la durée de location pour ajouter des frais supplémentaires
                 * ou non
                 */
                exemplaire.verifierDureeLocation();

                /* Ce booleen verifie si l'utilisateur a terminé de choisir des options */
                boolean faireAction = false;
                do {
                    /* Les différentes options ... */

                    System.out.println("\n\n     Choisissez une option ... \n");
                    System.out.println("1 - Parcourir des kilometres \n");
                    System.out.println("2 - Consommer du carburant \n");
                    System.out.println("3 - Assurer le vehicule \n");
                    System.out.println("4 - Endommmager le vehicule  \n");
                    System.out.println("5 - Ramener le vehicule \n\n");
                    System.out.println("Tapez un chiffre ...");

                    Scanner optionChoisie = new Scanner(System.in);
                    int choix = optionChoisie.nextInt();

                    switch (choix) {
                        case 1:
                            Scanner kilometresParcourues = new Scanner(System.in);
                            System.out.println("Entrez le nombre de kilomètres parcourus");
                            exemplaire.parcourirKilometres(kilometresParcourues.nextInt());
                            faireAction = false;
                            break;
                        case 2:
                            Scanner carburantConsomme = new Scanner(System.in);
                            System.out.println("Entrez la quantité de carburant utilisée");
                            exemplaire.consommerCarburant(carburantConsomme.nextInt());
                            faireAction = false;
                            break;
                        case 3:
                            exemplaire.assurer();
                            faireAction = false;
                            break;
                        case 4:
                            exemplaire.endommager();
                            faireAction = false;
                            break;

                        case 5:
                            emprunteur.ramener();
                            faireAction = true;
                            break;

                        default:
                            emprunteur.ramener();
                            System.out.println(" ... AU REVOIR ...\n");
                            faireAction = true;
                            break;

                    }
                } while (faireAction == false);

            } else {
                Auto auto = new Auto(partsOfVehicule[0], partsOfVehicule[1]);
                Exemplaire exemplaire = new Exemplaire(auto, 01, 0, dureeLocation);
                Addresse addresse = new Addresse(Integer.parseInt(the_adress[0]), the_adress[1], the_adress[2],
                        the_adress[3]);
                Emprunteur emprunteur = new Emprunteur(exemplaire, 1, partsOfEmprunteur[0], partsOfEmprunteur[1],
                        addresse);
                /* La ligne suivante n'est pas utile... */
                Location location = new Location(0, dateDeDebut, dateDeFin, emprunteur);
                
                emprunteur.louer();

                /* Pour arranger la vue dans la console */
                System.out.print("\033[H\033[2J");

                /*
                 * Verification de la durée de location pour ajouter des frais supplémentaires
                 * ou non
                 */
                exemplaire.verifierDureeLocation();

                /* Ce booleen verifie si l'utilisateur a terminé de choisir des options */
                boolean faireAction = false;
                do {
                    /* Les différentes options ... */

                    System.out.println("\n\n     Choisissez une option ... \n");
                    System.out.println("1 - Parcourir des kilometres \n");
                    System.out.println("2 - Consommer du carburant \n");
                    System.out.println("3 - Assurer le vehicule \n");
                    System.out.println("4 - Endommmager le vehicule  \n");
                    System.out.println("5 - Ramener le vehicule \n\n");
                    System.out.println("Tapez un chiffre ...");

                    Scanner optionChoisie = new Scanner(System.in);
                    int choix = optionChoisie.nextInt();

                    switch (choix) {
                        case 1:
                            Scanner kilometresParcourues = new Scanner(System.in);
                            System.out.println("Entrez le nombre de kilomètres parcourus");
                            exemplaire.parcourirKilometres(kilometresParcourues.nextInt());
                            faireAction = false;
                            break;
                        case 2:
                            Scanner carburantConsomme = new Scanner(System.in);
                            System.out.println("Entrez la quantité de carburant utilisée");
                            exemplaire.consommerCarburant(carburantConsomme.nextInt());
                            faireAction = false;
                            break;
                        case 3:
                            exemplaire.assurer();
                            faireAction = false;
                            break;
                        case 4:
                            exemplaire.endommager();
                            faireAction = false;
                            break;

                        case 5:
                            emprunteur.ramener();
                            faireAction = true;
                            break;

                        default:
                            emprunteur.ramener();
                            System.out.println(" ... AU REVOIR ...\n");
                            faireAction = true;
                            break;

                    }
                } while (faireAction == false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
