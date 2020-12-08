public class App
{
    public static void main(String[] args)
    {
        Localite loc1 = new Localite("Chaleroi", 6000);
        System.out.println(loc1);

        Personne per1 = new Personne("Jean Kevin", "0742618588", 'M');
        System.out.println(per1);

        BienImmobilier bi1 = new BienImmobilier("62 rue du pont", loc1, 1999, per1);
        System.out.println(bi1);

        Immeuble im1 = new Immeuble("62 rue de la brique", loc1, 1999, per1, 7, 2, 300.0, 550.0);
        System.out.println(im1);
        System.out.println(im1.tauxTVA());

        Villa v1 = new Villa("69 rue du pain", loc1, 1999, per1, 3, 16.7, false);
        System.out.println(v1);
        System.out.println(v1.descriptionTerrain());

        Personne per2 = new Personne("John Smith", "0452454154", 'M');
        VillaLouee val1 = new VillaLouee("64 rue du pont", loc1, 1999, per1, 3, 16.7, false, per2, 840.0, 8);
        System.out.println(val1);
        System.out.println(val1.revenuProprietaire());

        Personne per3 = new Personne("Ryan Shrout", "145405404", 'f');
        Localite loc2 = new Localite("AZERTY", 123);
        ImmeubleBureaux imb1 = new ImmeubleBureaux("154, rue du RGB", loc2, 1945, per3, 1, 2, 456, 484, 415, 154);
        System.out.println(imb1);

        ImmeubleRezCommercial imrc1 = new ImmeubleRezCommercial("154, rue du RGB", loc2, 1945, per3, 1, 2, 456, 484, 2, 5000);
        System.out.println(imrc1);
        System.out.println(v1.tauxTVA());
        imrc1.setCodePostal(6150);
        System.out.println(imrc1.getProprietaireName());
    }
}
