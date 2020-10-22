package serie2;

public class Club
{
    String nom;
    String adrClub;
    Secretaire secretaire;

    public Club(String nom, String adrClub, Secretaire secretaire)
    {
        this.nom = nom;
        this.adrClub = adrClub;
        this.secretaire = secretaire;
    }

    public String toString()
    {
        return "Club: " + this.nom + ", adresse: " + this.adrClub + ", " + this.secretaire;
    }
}
