package premierPackage;

public class Principale
{
    public static void main(String[] args) throws Exception
    {
        int x, y;
        String mot;

        x = 7;
        y = 3;
        mot = "Java";
        System.out.println(String.format("Le produit vaut %d et le mot est %s", x * y, mot));
    
        Rectangle premierRectangle = new Rectangle(4, 10);

        System.out.println(String.format("hauteur: %d, largeur: %d", premierRectangle.hauteur, premierRectangle.largeur));

        System.out.println("Perimètre: " + premierRectangle.perimetre() + ", surface: " + premierRectangle.surface());
        premierRectangle.modifierHauteur(20);
        premierRectangle.modifierLargeur(11);
        System.out.println("Perimètre: " + premierRectangle.perimetre() + ", surface: " + premierRectangle.surface());
    }
}
