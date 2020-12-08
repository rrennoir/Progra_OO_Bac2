public class Localite
{
    private String nomLocalite;
    private int codePostal;
    
    public Localite(String nom, int code)
    {
        this.nomLocalite = nom;
        this.codePostal = code;
    }

    public int getCodePostal()
    {
        return this.codePostal;
    }

    public void setCodePostal(int newCodePostal)
    {
        this.codePostal = newCodePostal;
    }

    public String toString()
    {
        return String.format("%s %s", this.codePostal, this.nomLocalite);
    }
}
