package serie3;

public class App
{
    public static void main(String[] args)
    {
        Localite ville = new Localite("Charleroi", 42);
        Personne p = new Personne("Lisa", "Su", "Rue du pont", 69, ville);

        Marque m = new Marque("Ferrari", "Maranello");
        Modele mod = new Modele("488 GT3", 2016, m);

        Vehicule v = new Vehicule("abc123", 50, p, mod);
        System.out.println(v);


        ville.setNbHabitant(666);
        mod.setAnneeSortie(2018);
        v.setJaugeEssence(78);
        v.setPlaque("zyx-987");
        m.setAdrSiegeCentral("Rome");
        Localite namur = new Localite("Namur", 92);
        p.setLocalite(namur);
        mod.setLibelle("488 evo GT3");
        p.setName("Lind", "Denis");
        System.out.println(v);
    }
}
