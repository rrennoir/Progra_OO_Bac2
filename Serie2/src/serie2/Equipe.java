package serie2;

public class Equipe
{
    String nom;
    String categorie;
    Club club;
    Coach coach;

    public Equipe(String nom, String cateogrie, Club club, Coach coach)
    {
        this.nom = nom;
        this.categorie = cateogrie;
        this.club = club;
        this.coach = coach;
    }

    public String toString()
    {
        return "Equipe: " + this.nom + "\n\tCategory: " + this.categorie + "\n\t" + this.club + "\n\t" + this.coach;
    }
}
