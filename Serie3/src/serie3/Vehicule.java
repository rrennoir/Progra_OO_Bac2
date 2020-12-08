package serie3;

public class Vehicule
{
    private String plaque;
    private int jaugeEssence;
    private Personne proprio;
    private Modele type;

    Vehicule(String plaque, int jaugeEssence, Personne proprio, Modele type)
    {
        this.plaque = plaque;
        this.jaugeEssence = jaugeEssence;
        this.proprio = proprio;
        this.type = type;
    }

    public String getPlaque()
    {
        return this.plaque;
    }

    public void setPlaque(String newPlaque)
    {
        this.plaque = newPlaque;
    }

    public int getJaugeEssence()
    {
        return this.jaugeEssence;
    }

    public void setJaugeEssence(int newJaugeEssence)
    {
        this.jaugeEssence = newJaugeEssence;
    }

    public Personne getProprio()
    {
        return this.proprio;
    }

    public String getProprioName()
    {
        return this.proprio.getName();
    }

    public void setProprio(Personne newProprio)
    {
        this.proprio = newProprio;
    }

    public int getModelYear()
    {
        return this.type.getAnneeSortie();
    }

    public String toString()
    {
        return String.format("Plaque: %s%nJauge d'essence: %d%nPropriétaire: %s%nModel: %s", this.plaque, this.jaugeEssence, this.proprio, this.type);
    }
}
