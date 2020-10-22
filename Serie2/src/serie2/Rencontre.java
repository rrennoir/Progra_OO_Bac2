package serie2;

public class Rencontre
{
    Equipe locaux;
    Equipe visiteur;
    int pointsLocaux;
    int pointsVisiteurs;
    int fautesLocaux;
    int fautesVisiteurs;
    Arbitre juge;
    
    public Rencontre(Equipe locaux, Equipe visiteur, Arbitre juge)
    {
        this.locaux = locaux;
        this.visiteur = visiteur;
        this.pointsLocaux = 0;
        this.pointsVisiteurs = 0;
        this.fautesLocaux = 0;
        this.fautesVisiteurs = 0;
        this.juge = juge;
    }

    public String vainqueur()
    {
        if (this.pointsLocaux > this.pointsVisiteurs)
            return this.locaux.nom;

        else if (this.pointsVisiteurs > this.pointsLocaux)
            return this.visiteur.nom;

        else
            return "Ex aequo";
    }

    public String equipeFairPlay()
    {
        if (this.fautesLocaux < this.fautesVisiteurs)
            return this.locaux.nom;
        
        else if (this.fautesVisiteurs < this.fautesLocaux)
            return this.visiteur.nom;

        else
            return "Ex aequo";
    }

    public boolean exAequo()
    {
       return this.pointsLocaux == this.pointsVisiteurs;
    }

    public String presenterLocaux()
    {
        return "L'équipe locale " + this.locaux.nom;
    }

    public String presenterVisiteur()
    {
        return "L'équipe des visiteurs " + this.visiteur.nom;
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
        this.fautesLocaux++;
    }

    public void ajouterFauteVisiteur()
    {
        this.fautesVisiteurs++;
    }

    public String presenterAdversaire()
    {
        return String.format(" %s reçoit %s", this.presenterLocaux(), this.presenterVisiteur());
    }

    // public String toString()
    // {
    //     return this.presenterAdversaire() + "\n" + this.vainqueur();
    // }

    public String toString()
    {
        return this.locaux + "\n" + this.visiteur + "\n" + this.juge;
    }
}
