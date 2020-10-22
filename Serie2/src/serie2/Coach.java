package serie2;

import java.util.*;

public class Coach
{
    String nom;
    String prenom;
    int anneeDebut;

    public Coach(String nom, String prenom, int anneeDebut)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeDebut = anneeDebut;
    }

    public int nbAnneesExperience()
    {
        GregorianCalendar now = new GregorianCalendar();
        int anneeEnCours = now.get(GregorianCalendar.YEAR);

        return anneeEnCours - anneeDebut;
    }

    public String toString()
    {
        return "Coatch: " + this.nom + " " + this.prenom + " a commencé en " + this.anneeDebut;
    }
}
