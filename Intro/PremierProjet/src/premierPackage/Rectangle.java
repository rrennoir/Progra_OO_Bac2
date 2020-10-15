package premierPackage;

public class Rectangle
{
    int hauteur;
    int largeur;

    public Rectangle(int hauteur, int largeur)
    {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public int perimetre()
    {
        return (this.hauteur + this.largeur) * 2;
    }

    public int surface()
    {
        return this.hauteur * this.largeur;
    }

    public void modifierHauteur(int hauteur)
    {
        this.hauteur = hauteur;
    }

    public void modifierLargeur(int largeur)
    {
        this.largeur = largeur;
    }   
}
