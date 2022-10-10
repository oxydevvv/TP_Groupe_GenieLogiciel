import java.util.ArrayList;

import java.util.ArrayList;

public class Macedoine
{
    private ArrayList<Fruit> fruits;
    private boolean seedless;

    public Macedoine(Fruit f)
    {
        this.fruits = new ArrayList<Fruit>();
        this.fruits.add(f);
        this.seedless = f.isSeedless();
    }

    public ArrayList<Fruit> getFruits()
    {
        return this.fruits;
    }

    public boolean isSeedless()
    {
        // exception macedoine "vide"
        return this.seedless;
    }
    
    public void ajoute(Fruit f) 
    {
        // throw new PanierVideException();

        // vérifier les fruits d'avant
        this.fruits.add(f);

        if(!f.isSeedless())
        {
            this.seedless = false;
        }
    }

    public void ajoute(Macedoine macedoine)
    {
        for(Fruit f : macedoine.getFruits())
        {
            this.ajoute(f);
        }
    }

    public String toString()
    {
        string s = "Macedoine : \n";
        for(Fruit f : fruits)
        {
            s = s + f.toString+ "\n";
        }
        return s;
    }

    public double getPrix()
    {
        double prix = 0.0;
        for(Fruit f : fruits)
        {
            prix += f.getPrix();
        }
        return prix;
    }
}