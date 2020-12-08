package serie3;

public class Localite
{
    private String nom;
    private String communaute;
    private int nbHabitants;

    public Localite(String nom, String communaute, int nbHabitants)
    {
        this.nom = nom;
        this.communaute = communaute;
        this.nbHabitants = nbHabitants;
    }

    public Localite(String nom, int nbHabitants)
    {
        this.nom = nom;
        this.communaute = "Française";
        this.nbHabitants = nbHabitants;
    }

    public int getNbHabitant()
    {
        return this.nbHabitants;
    }

    public void setNbHabitant(int newNbHabitants)
    {
        this.nbHabitants = newNbHabitants;
    }

    public String langue()
    {
        if (this.communaute.equals("Française"))
            return "Français";

        else if (this.communaute.equals("Flammande"))
            return "Neerlandais";
        
        else
            return "Allemand";
    }

    public String toString()
    {
        return  String.format("%s, Communauté: %s, Habitants: %s", this.nom, this.communaute, this.nbHabitants);
    }
}
