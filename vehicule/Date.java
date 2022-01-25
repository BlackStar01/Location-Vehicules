/*
* Nom du projet: LOCATION
* Auteurs: AGBANOU Vital Warren && MBUGUEM KOYOUE Anriane
* Rôle de ce fichier: Il permet de contenir l'ensemble des fonctionnalités de la classe Date
*/

package vehicule;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Date {
    private int jour;
    private int mois;
    private int annee;

    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    /* Constructeur par recopie */
    public Date(Date d) {
        jour = d.jour;
        mois = d.mois;
        annee = d.annee;
    }

    /*
     * Une methode pour trouver le nombre de jours entre deux dates
     * LocalDate transforme la date au format // JJ-MM-AAAA
     */
    public long differenceEntreDates(Date date2) {

        LocalDate startDate = LocalDate.of(this.annee, Month.of(this.mois), this.jour);
        // 29-July-2017, change this to your desired End Date
        LocalDate endDate = LocalDate.of(date2.annee, Month.of(date2.mois), date2.jour);

        long nbrDays = ChronoUnit.DAYS.between(startDate, endDate);
        return nbrDays;
    }

    @Override
    public String toString() {
        return "\nDate : " + this.jour + " " + this.mois + " " + this.annee;
    }
}
