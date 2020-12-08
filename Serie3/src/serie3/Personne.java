package serie3;

public class Personne
{
    private String prenom;
    private String nom;
    private String rue;
    private int numeroRue;
    private Localite ville;

    public Personne(String prenom, String nom, String rue, int numeroRue, Localite ville)
    {
        this.prenom = prenom;
        this.nom = nom;
        this.rue = rue;
        this.numeroRue = numeroRue;
        this.ville = ville;
    }

    public Localite getLocalite()
    {
        return this.ville;
    }

    public void setName(String newNom, String newPrenom)
    {
        this.nom = newNom;
        this.prenom = newPrenom;
    }

    public String getName()
    {
        return String.format("%s %s", this.nom, this.prenom);
    }

    public void setLocalite(Localite newVille)
    {
        this.ville = newVille;
    }

    public String toString()
    {
        return String.format("%n\tPrenom: %s, Nom: %s%n\tAdresse: %s %d%n\tVille: %s", this.prenom, this.nom, this.rue, this.numeroRue, this.ville);
    }
}
