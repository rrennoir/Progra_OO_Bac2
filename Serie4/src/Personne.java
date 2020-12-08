public class Personne
{
    private String nomPrenom;
    private String telephone;
    private char sexe;
    
    public Personne(String nomPrenom, String telephone, char sexe)
    {
        this.nomPrenom = nomPrenom;
        this.telephone = telephone;

        if (sexe == 'F' && sexe == 'f')
            this.sexe = 'F';

        else
            this.sexe = 'M';
    }

    public String getName()
    {
        return this.nomPrenom;
    }

    public String toString()
    {
        String text;
        if (sexe == 'M')
            text = String.format("Monsieur %s (tel: %s)", this.nomPrenom, this.telephone);

        else
            text = String.format("Madame %s (tel: %s)", this.nomPrenom, this.telephone);

        return text;
    }
}
