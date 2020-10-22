package serie2;

public class Secretaire
{
    String nom;
    String prenom;
    String noTel;
    
    public Secretaire(String nom, String prenom, String noTel)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.noTel = noTel;
    }

    public String toString()
    {
        return "Secretaire: " + this.nom + "" + this.prenom + ", N° Tel: " + this.noTel;
    }
}
