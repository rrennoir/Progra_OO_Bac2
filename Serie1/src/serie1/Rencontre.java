package serie1;

public class Rencontre 
{
    String nomLocaux;
    String nomVisiteurs;
    
    int pointsLocaux;
    int pointsVisiteurs;
    int nbFautesLocaux;
    int nbFautesVisiteurs;

    public Rencontre(String locaux, String visiteur, int pLocaux, int pVisiteurs, int fLocaux, int fVisiteur)
    {
        nomLocaux = locaux;
        nomVisiteurs = visiteur;
        pointsLocaux = pLocaux;
        pointsVisiteurs = pVisiteurs;
        nbFautesLocaux = fLocaux;
        nbFautesVisiteurs = fVisiteur; 
    }

    public Rencontre(String locaux, String visiteur)
    {
        nomLocaux = locaux;
        nomVisiteurs = visiteur;
        pointsLocaux = 0;
        pointsVisiteurs = 0;
        nbFautesLocaux = 0;
        nbFautesVisiteurs = 0; 
    }

    public Rencontre(String visiteur)
    {
        nomLocaux = "Les seigneurs du combat";
        nomVisiteurs = visiteur;
        pointsLocaux = 0;
        pointsVisiteurs = 0;
        nbFautesLocaux = 0;
        nbFautesVisiteurs = 0; 
    }    

    public String vainqueur()
    {
        if (pointsLocaux > pointsVisiteurs)
            return nomLocaux;

        else if (pointsVisiteurs > pointsLocaux)
            return nomVisiteurs;

        else
            return "Ex aequo";
    }

    public String equipeFairPlay()
    {
        if (nbFautesLocaux < nbFautesVisiteurs)
            return nomLocaux;
        
        else if (nbFautesVisiteurs < nbFautesLocaux)
            return nomVisiteurs;

        else
            return "Ex aequo";
    }

    public boolean exAequo()
    {
        if (pointsLocaux == pointsVisiteurs)
            return true;

        else
            return false;
    }

    public String presenterLocaux()
    {
        return "L'équipe locale " + nomLocaux;
    }

    public String presenterVisiteur()
    {
        return "L'équipe des visiteurs " + nomVisiteurs;
    }

    public void ajouterPointsLocaux()
    {
        pointsLocaux++;
    }

    public void ajouterPointsLocaux(int points)
    {
        pointsLocaux += points;
    }

    public void ajouterPointsVisiteur()
    {
        pointsVisiteurs++;
    }
    
    public void ajouterPointsVisiteur(int points)
    {
        pointsVisiteurs += points;
    }

    public void ajouterPoints(String equipe)
    {
        if (equipe == "L")
            ajouterPointsLocaux();
        
        else if (equipe == "V")
            ajouterPointsVisiteur();
    }

    public void ajouterFauteLocaux()
    {
        nbFautesLocaux++;
    }

    public void ajouterFauteVisiteur()
    {
        nbFautesVisiteurs++;
    }

    public String presenterAdversaire()
    {
        return String.format(" %s reçoit %s", presenterLocaux(), presenterVisiteur());
    }

    public String toString()
    {
        return presenterAdversaire() + "\n" + vainqueur();
    }
}
