package serie2;

public class Principal
{
    public static void main(String[] args)
    {
        Arbitre arbitre = new Arbitre("Su", "Lisa", "SUL", 1973);

        Secretaire secretaire1 = new Secretaire("The Cherno", "", "0725551544");
        Club club1 = new Club("club_1", "rue club 1", secretaire1);
        Coach coach1 = new Coach("Huang", "Jen-Hsun", 1998);
        Equipe e1 = new Equipe("e1", "débutant", club1, coach1);

        Secretaire secretaire2 = new Secretaire("Coretek", "", "0724351484");
        Club club2 = new Club("club_1", "rue club 2", secretaire2);
        Coach coach2 = new Coach("Koduri", "Raja", 1982);
        Equipe e2 = new Equipe("e2", "confirmé", club2, coach2);

        Rencontre renc1 = new Rencontre(e1, e2, arbitre);

        System.out.println(renc1);
        System.out.println(renc1.pointsLocaux);
        System.out.println(renc1.equipeFairPlay());
        System.out.println(renc1.juge.prenom);
        System.out.println(renc1.locaux.categorie);
        System.out.println(renc1.locaux.nom);
        System.out.println(renc1.visiteur.nom);
        System.out.println(renc1.juge.matricule());
        System.out.println(renc1.locaux.coach.nom + " " + renc1.locaux.coach.prenom);
        System.out.println(renc1.visiteur.club.adrClub);
        System.out.println(renc1.visiteur.club.secretaire);
        System.out.println(renc1.visiteur.coach.nbAnneesExperience());

        renc1.ajouterPointsVisiteur(56);
        Arbitre arbitre2 = new Arbitre("Papermaster", "Mark", "PAM", 1971);
        renc1.juge = arbitre2;
    }
}
