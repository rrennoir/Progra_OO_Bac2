package serie1;

public class Principal
{
    public static void main(String[] args)
    {
        Rencontre match = new Rencontre("les A", "les B", 0, 0, 0, 0);
        match.ajouterPointsVisiteur();
        match.ajouterPointsLocaux();
        match.ajouterPointsVisiteur();
        match.ajouterPointsLocaux();
        match.ajouterPointsLocaux(1);
        match.ajouterPointsVisiteur();
        match.ajouterPointsLocaux();
        match.ajouterPointsLocaux(7);
        match.ajouterPointsVisiteur(10);
        match.ajouterPointsLocaux();
        match.ajouterPointsLocaux();
        match.ajouterPointsVisiteur();
        match.ajouterPointsVisiteur();


        match.ajouterFauteVisiteur();
        match.ajouterFauteVisiteur();

        match.ajouterPoints("L");
        match.ajouterPoints("V");
        match.ajouterPoints("L");
        match.ajouterPoints("V");
        match.ajouterPoints("V");

        System.out.println(match.presenterLocaux());
        System.out.println(match.presenterVisiteur());

        System.out.println(match.vainqueur());
        System.out.println(match.equipeFairPlay());

        System.out.println("Match ex aequo: " + match.exAequo());

        Rencontre match2 = new Rencontre("Les A2", "Les B2");
        match2.ajouterPointsVisiteur();
        match2.ajouterPointsLocaux();
        match2.ajouterPointsLocaux(2);
        match2.ajouterPointsVisiteur();
        match2.ajouterPointsVisiteur(3);

        match2.ajouterFauteVisiteur();
        match2.ajouterFauteVisiteur();

        System.out.println(match2.presenterLocaux());
        System.out.println(match2.presenterVisiteur());

        System.out.println(match2.vainqueur());
        System.out.println(match2.equipeFairPlay());

        System.out.println("Match ex aequo: " + match2.exAequo());

        Rencontre match3 = new Rencontre("Les B3");
        match3.ajouterPointsVisiteur();
        match3.ajouterPointsLocaux();
        match3.ajouterPointsLocaux(4);
        match3.ajouterPointsVisiteur();
        match3.ajouterPointsVisiteur(2);

        match3.ajouterFauteVisiteur();
        match3.ajouterFauteVisiteur();

        System.out.println(match3.presenterLocaux());
        System.out.println(match3.presenterVisiteur());

        System.out.println(match3.vainqueur());
        System.out.println(match3.equipeFairPlay());

        System.out.println("Match ex aequo: " + match3.exAequo());
    }
}
