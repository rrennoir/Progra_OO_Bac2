package serie3;

public class Marque
{
    private String nom;
    private String adrSiegeCentral;

    public Marque(String nom, String adrSiegeCentral)
    {
        this.nom = nom;
        this.adrSiegeCentral = adrSiegeCentral;
    }

    public String getAdrSiegeCentral()
    {
        return this.adrSiegeCentral;
    }

    public void setAdrSiegeCentral(String newAdrSiegeCentral)
    {
        this.adrSiegeCentral = newAdrSiegeCentral;
    }

    public String toString()
    {
        return this.nom + " " + this.adrSiegeCentral;
    }
}
