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
        this.nomLocaux = locaux;
        this.nomVisiteurs = visiteur;
        this.pointsLocaux = pLocaux;
        this.pointsVisiteurs = pVisiteurs;
        this.nbFautesLocaux = fLocaux;
        this.nbFautesVisiteurs = fVisiteur; 
    }

    public Rencontre(String locaux, String visiteur)
    {
        this.nomLocaux = locaux;
        this.nomVisiteurs = visiteur;
        this.pointsLocaux = 0;
        this.pointsVisiteurs = 0;
        this.nbFautesLocaux = 0;
        this.nbFautesVisiteurs = 0; 
    }

    public Rencontre(String visiteur)
    {
        this.nomLocaux = "Les seigneurs du combat";
        this.nomVisiteurs = visiteur;
        this.pointsLocaux = 0;
        this.pointsVisiteurs = 0;
        this.nbFautesLocaux = 0;
        this.nbFautesVisiteurs = 0; 
    }    

    public String vainqueur()
    {
        if (this.pointsLocaux > this.pointsVisiteurs)
            return this.nomLocaux;

        else if (this.pointsVisiteurs > this.pointsLocaux)
            return this.nomVisiteurs;

        else
            return "Ex aequo";
    }

    public String equipeFairPlay()
    {
        if (this.nbFautesLocaux < this.nbFautesVisiteurs)
            return nomLocaux;
        
        else if (this.nbFautesVisiteurs < this.nbFautesLocaux)
            return this.nomVisiteurs;

        else
            return "Ex aequo";
    }

    public boolean exAequo()
    {
        return this.pointsLocaux == this.pointsVisiteurs;
    }

    public String presenterLocaux()
    {
        return "L'équipe locale " + this.nomLocaux;
    }

    public String presenterVisiteur()
    {
        return "L'équipe des visiteurs " + this.nomVisiteurs;
    }

    public void ajouterPointsLocaux()
    {
        this.pointsLocaux++;
    }

    public void ajouterPointsLocaux(int points)
    {
        this.pointsLocaux += points;
    }

    public void ajouterPointsVisiteur()
    {
        this.pointsVisiteurs++;
    }
    
    public void ajouterPointsVisiteur(int points)
    {
        this.pointsVisiteurs += points;
    }

    public void ajouterPoints(String equipe)
    {
        if (equipe != null && equipe.equals("L"))
            ajouterPointsLocaux();
        
        else if (equipe != null && equipe.equals("V"))
            ajouterPointsVisiteur();
    }

    public void ajouterFauteLocaux()
    {
        this.nbFautesLocaux++;
    }

    public void ajouterFauteVisiteur()
    {
        this.nbFautesVisiteurs++;
    }

    public String presenterAdversaire()
    {
        return String.format(" %s reçoit %s", this.presenterLocaux(), this.presenterVisiteur());
    }

    public String toString()
    {
        return this.presenterAdversaire() + "\n" + this.vainqueur();
    }
}
