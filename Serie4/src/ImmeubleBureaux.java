public class ImmeubleBureaux extends Immeuble
{
    int nbM2;
    double prixM2;

    public ImmeubleBureaux(String rueNumero, Localite localite, int anneeConstruction,
            Personne proprietaire, int nbStudios, int nbAppartements, double loyersStudios,
            double loyersAppartements, int nbM2, double prixM2)
    {
        super(rueNumero, localite, anneeConstruction, proprietaire, nbStudios,
            nbAppartements, loyersStudios, loyersAppartements);
        this.nbM2 = nbM2;
        this.prixM2 = prixM2;
    }

    @Override
    public double revenuMensuel()
    {
        return super.revenuMensuel() + nbM2 * prixM2;
    }

    @Override
    public String toString()
    {
        return String.format("%s (il comprend %d m² de bureau dont la location rapporte %.2f euros)",
                super.toString(), this.nbM2, this.nbM2 * this.prixM2);
    }
}
