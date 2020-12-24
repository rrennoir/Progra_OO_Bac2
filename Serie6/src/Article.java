import java.util.ArrayList;

public class Article
{
    private static ArrayList<Double> prices;

    private String libelle;
    private double prix;

    public Article(String libelle, double prix)
    {
        this.libelle = libelle;
        this.prix = prix;

        if (Article.prices == null)
            Article.prices = new ArrayList<Double>();

        Article.prices.add(this.prix);
    }

    public double getPrice()
    {
        return this.prix;
    }

    public String getLibelle()
    {
        return this.libelle;
    }

    public static double avgPrice()
    {
        double avg = 0;
        for (Double price : Article.prices)
        {
            avg += price;
        }

        return avg / Article.prices.size();
    }

    public String toString()
    {
        return String.format("%s au prix de %.2f", this.libelle, this.prix);
    }
}
