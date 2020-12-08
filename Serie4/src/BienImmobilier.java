import java.util.*;

public class BienImmobilier
{
    private String rueNumero;
    private Localite localite;
    private int anneeConstruction;
    private Personne proprietaire;
    
    public BienImmobilier(String rueNumero, Localite localite, int anneeConstruction,
            Personne proprietaire)
    {
        this.rueNumero = rueNumero;
        this.localite = localite;
        this.anneeConstruction = anneeConstruction;
        this.proprietaire = proprietaire;
    }

    public String getRueNumero()
    {
        return this.rueNumero;
    }

    public void setRueNumero(String newRueNumero)
    {
        this.rueNumero = newRueNumero;
    }

    public int getCodePostal()
    {
        return this.localite.getCodePostal();
    }

    public void setCodePostal(int newCodePostal)
    {
        this.localite.setCodePostal(newCodePostal);
    }

    public Personne getProprietaire()
    {
        return this.proprietaire;
    }

    public String getProprietaireName()
    {
        return this.proprietaire.getName();
    }

    public void setProprietaire(Personne newProprietaire)
    {
        this.proprietaire = newProprietaire;
    }

    public int tauxTVA()
    {
        GregorianCalendar now = new GregorianCalendar();
        int anneeEnCours = now.get(GregorianCalendar.YEAR);

        int tva = 21;
        if (anneeEnCours - anneeConstruction > 20)
            tva = 6;

        return tva;
    }

    public String toString()
    {
        return String.format("L'immeuble situé %s à %s appartenant à %s",
                this.rueNumero, this.localite, this.proprietaire);
    }
}
