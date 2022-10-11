import java.util.ArrayList;

public class Jus
{
    private Fruit f;

    public Jus(Fruit f)
    {
        this.f = f;
    }

    public Fruit getFruit()
    {
        return this.f;
    }

    public boolean isSeedless()
    {
        return f.isSeedless();
    }

    public String toString()
    {
        String s1 = this.f.toString();
        String s2 = "Jus de ";
        int i = 0;
        while(s1.charAt(i) != " ")
        {
            s2 += s1.charAt(i);
            i++;
        }
        return s2;
    }

    public double getPrix()
    {
        return f.getPrix();
    }

}
