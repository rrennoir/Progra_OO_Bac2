public class Immeuble extends BienImmobilier
{
    private int nbStudios;
    private int nbAppartements;
    private double loyersStudios;
    private double loyersAppartements;

    public Immeuble(String rueNumero, Localite localite, int anneeConstruction,
            Personne proprietaire, int nbStudios, int nbAppartements,
            double loyersStudios, double loyersAppartements)
    {
        super(rueNumero, localite, anneeConstruction, proprietaire);
        this.nbStudios = nbStudios;
        this.nbAppartements = nbAppartements;
        this.loyersStudios = loyersStudios;
        this.loyersAppartements = loyersAppartements;
    }
    
    public double revenuMensuel()
    {
        return nbStudios * loyersStudios + nbAppartements * loyersAppartements;
    }

    @Override
    public String toString()
    {
        return String.format("%s contient %d studio(s) et %d appartement(s) et rapporte %.2f euros par mois",
                super.toString(), this.nbStudios, this.nbAppartements, revenuMensuel());
    }
}
