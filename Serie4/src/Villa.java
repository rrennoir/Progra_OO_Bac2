public class Villa extends BienImmobilier
{
    private int nbChambres;
    private double superficieTerrain;
    private boolean campagne;

    public Villa(String rueNumero, Localite localite, int anneeConstruction,
            Personne proprietaire, int nbChambres, double superficieTerrain, boolean campagne)
    {
        super(rueNumero, localite, anneeConstruction, proprietaire);
        this.nbChambres = nbChambres;
        this.superficieTerrain = superficieTerrain;
        this.campagne = campagne;
    }

    public String descriptionTerrain()
    {
        if (this.campagne)
            return String.format("Terrain de %.2f ares situé à la campagne, %s",
                    this.superficieTerrain, super.getRueNumero());

        else
            return String.format("Terrain de %.2f ares situé en ville, %s",
                    this.superficieTerrain, super.getRueNumero());
    }

    @Override
    public String toString()
    {
        return String.format("%s est une villa à %d chambre(s) situé sur un terrain de %f ares",
                super.toString(), this.nbChambres, this.superficieTerrain);
    }
}
