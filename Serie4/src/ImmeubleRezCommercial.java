public class ImmeubleRezCommercial extends Immeuble
{
    private int nbMagasins;
    private double revenuLocationMagasin;


    public ImmeubleRezCommercial(String rueNumero, Localite localite, int anneeConstruction,
            Personne proprietaire, int nbStudios, int nbAppartements, double loyersStudios,
            double loyersAppartements, int nbMagasins, double revenuLocationMagasin)
    {
        super(rueNumero, localite, anneeConstruction, proprietaire, nbStudios,
        nbAppartements, loyersStudios, loyersAppartements);
        this.nbMagasins = nbMagasins;
        this.revenuLocationMagasin = revenuLocationMagasin;
    }

    public double revenuMensuel()
    {
        return super.revenuMensuel() + (this.revenuLocationMagasin * this.nbMagasins);
    }

    public String toString()
    {
        return String.format("%s (il compend un rez de chaussée commercial composé de %d magasins dont le revenu commercial est de %.2f euros", 
                                super.toString(), this.nbMagasins, this.nbMagasins * this.revenuLocationMagasin);
    }
}
