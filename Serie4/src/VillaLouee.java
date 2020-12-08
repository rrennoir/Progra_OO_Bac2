public class VillaLouee extends Villa {
    Personne locataire;
    double loyer;
    int dureeBail;

    public VillaLouee(String rueNumero, Localite localite, int anneeConstruction,
            Personne proprietaire, int nbChambres, double superficieTerrain, boolean campagne,
            Personne locataire, double loyer, int dureeBail)
    {
        super(rueNumero, localite, anneeConstruction, proprietaire, nbChambres,
                superficieTerrain, campagne);
        this.locataire = locataire;
        this.loyer = loyer;
        this.dureeBail = dureeBail;
    }

    public String revenuProprietaire()
    {
        return String.format("%s touche un loyer de %.2f euros par an",
                super.getProprietaire(), this.loyer * 12);
    }

    @Override
    public String toString()
    {
        return String.format("%s et est louée à %s pour un loyer de %.2f euros par mois (durée du bail: %d an(s))",
                super.toString(), this.locataire, this.loyer, this.dureeBail);
    }
}
