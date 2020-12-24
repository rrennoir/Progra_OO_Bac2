public class App {
    public static void main(String[] args) throws Exception
    {
        Article a1 = new Article("Patate", 1.1);
        Article a2 = new Article("PS5", 399.99);
        Article a3 = new Article("Baguette", 2.50);

        Commande c1 = new Commande("Chad Smith", 1592);
        c1.ajouterArticle(a1);
        c1.ajouterArticle(a1);
        c1.ajouterArticle(a1);
        c1.ajouterArticle(a2);
        c1.ajouterArticle(a3);
        c1.ajouterArticle(a3);
        
        System.out.println(c1.calculTotalPanier());
        System.out.println(c1.listingPanier());

        System.out.println(Article.avgPrice());
        System.out.println(Commande.clientNamurois());
        System.out.println(Commande.articleAcheter());
    }
}
