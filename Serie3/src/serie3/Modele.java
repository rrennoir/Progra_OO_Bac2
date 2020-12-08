package serie3;

import java.util.*;

public class Modele
{
    private String libelle;
    private int anneeSortie;
    private Marque fabricant;

    public Modele(String libelle, int anneeSortie, Marque fabricant)
    {
        this.libelle = libelle;
        this.anneeSortie = anneeSortie;
        this.fabricant = fabricant;
    }

    int anciennete()
    {
        GregorianCalendar now = new GregorianCalendar();
        int anneeEnCours = now.get(GregorianCalendar.YEAR);

        return anneeEnCours - this.anneeSortie;
    }

    public String getLibelle()
    {
        return this.libelle;
    }

    public void setLibelle(String newLibelle)
    {
        this.libelle = newLibelle;
    }

    public int getAnneeSortie()
    {
        return this.anneeSortie;
    }

    public void setAnneeSortie(int newAnneeSortie)
    {
        this.anneeSortie = newAnneeSortie;
    }

    public String toString()
    {
        return String.format("%s %s %d", this.fabricant, this.libelle, this.anneeSortie);
    }
}
