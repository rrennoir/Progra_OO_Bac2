package serie2;

public class Arbitre
{
    String nom;
    String prenom;
    String code;
    int anneeNaissance;

    public Arbitre(String nom, String prenom, String code, int anneeNaissance)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.code = code;
        this.anneeNaissance = anneeNaissance;
    }

    public String matricule()
    {
        return anneeNaissance + code;
    }

    public String toString()
    {
        return "Arbitre: " + this.nom + " " + this.prenom + "\n\tCode: " + this.code + "\n\tAnnée de naissance: " + this.anneeNaissance;
    }
}
