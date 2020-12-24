import java.util.ArrayList;

public class Commande
{
    private static ArrayList<String> clientsNamurois;
    private static ArrayList<Article> articleBought;

    private String client;
    private int codePostal;
    private ArrayList<Article> panier;

    public Commande(String client, int codePostal)
    {
        this.client = client;
        this.codePostal = codePostal;
        this.panier = new ArrayList<Article>();
    
        if (Commande.articleBought == null)
            Commande.articleBought = new ArrayList<Article>();
        
        if (Commande.clientsNamurois == null)
            Commande.clientsNamurois = new ArrayList<String>();

        if (this.codePostal >= 5000 & this.codePostal < 6000)
            Commande.clientsNamurois.add(client);
    }

    public void ajouterArticle(Article newArticle)
    {
        panier.add(newArticle);
        Commande.articleBought.add(newArticle);
    }

    public double calculTotalPanier()
    {
        double somme = 0;

        for (Article article : this.panier)
        {
            somme += article.getPrice();
        }
        return somme;
    }

    public String listingPanier()
    {
        String text = String.format("Le Panier du client %s contient les articles suviant:\n", this.client);
        
        for (Article article : this.panier)
        {
            text += article + "\n";
        }
        return String.format("%spour un total de %.2f euros", text, this.calculTotalPanier());
    }

    public static int clientNamurois()
    {
        return Commande.clientsNamurois.size();
    }

    public static int articleAcheter()
    {
        return Commande.articleBought.size();
    }
}
