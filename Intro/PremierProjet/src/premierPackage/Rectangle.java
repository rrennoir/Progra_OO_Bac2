package premierPackage;

public class Rectangle
{
    int hauteur;
    int largeur;

    public Rectangle(int _hauteur, int _largeur)
    {
        hauteur = _hauteur;
        largeur = _largeur;
    }

    public int perimetre()
    {
        return (hauteur + largeur) * 2;
    }

    public int surface()
    {
        return hauteur * largeur;
    }

    public void modifierHauteur(int newHauteur)
    {
        hauteur = newHauteur;
    }

    public void modifierLargeur(int newLargeur)
    {
        largeur = newLargeur;
    }   
}
