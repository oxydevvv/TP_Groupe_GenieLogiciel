package fr.ufrsciencestech.groupe3.model;

import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier

    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String s = "Votre panier contient:\n";
        for (Fruit f: this.fruits)
        {
            s += "- " + f.toString() + "\n";
        }
        return s;
    }

    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    public int getContenanceMax(){  //accesseur du second attribut
        return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        return this.fruits.get(i);
    }

    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if(i < 0 || i >= this.getTaillePanier())
            return;
        else
            this.fruits.set(i, f);
    }

    public boolean estVide(){  //predicat indiquant que le panier est vide
        return this.fruits.isEmpty();
    }

    public boolean estPlein(){  //predicat indiquant que le panier est plein
        return this.getTaillePanier() == this.getContenanceMax();
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException
    {
        //Si le panier est plein, on lève une exception
        if (this.estPlein())
            throw new PanierPleinException();
        //sinon on ajoute le fruit au panier
        else
           this.fruits.add(o);
    }


    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide
        if(this.fruits.isEmpty())
            throw new PanierVideException();
        else
            this.fruits.remove(this.getTaillePanier()-1);
    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
        double prix = 0;
        for(Fruit f: this.fruits)
        {
            prix += f.getPrix();
        }
        return prix;
    }

    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
        Iterator<Fruit> it = this.fruits.iterator();
        while(it.hasNext())
        {
            if(it.next().getOrigine().equals(origine))
                it.remove();
        }
    }

    //groupe 8
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        //Si l'objet n'est pas de type Panier
        if(!(o.getClass().equals(Panier.class)))
            return false;
        else
        {
            Panier p2 = (Panier)o;
            //On vérifie si la taille des deux paniers est identique
            if(p2.getTaillePanier() != this.getTaillePanier())
                return false;
            else
            {
                int i = 0;
                boolean estIdentique = true;
                while(i < this.getTaillePanier() && estIdentique)
                {
                    Fruit f1 = this.getFruit(i);
                    Fruit f2 = p2.getFruit(i);
                    //On vérifie si ce sont les mêmes fruits
                    //même type de fruit
                    if(!(f1.getClass().equals(f2.getClass())))
                        estIdentique = false;
                    else
                    {
                        //même origine et même prix
                        if((f1.getOrigine().equals(f2.getOrigine())) && (f1.getPrix() == f2.getPrix()))
                            i++;
                        else
                            estIdentique = false;
                    }
                }
                return estIdentique;
            }
        }
    }

    //tests
    public static void main (String[] args) throws Exception{
        //Ecrire ici vos tests
        System.out.println("premier test Panier\n");

        //Création d'un premier panier
        Panier p1 = new Panier(69);

        //test de la contenace max du panier
        if (p1.getContenanceMax() == 69)
            System.out.println("getContenanceMax OK");
        else
            System.out.println("getContenanceMax FALSE");

        p1.ajout(new Pamplemousse());

        //test de la méthode getFruit
        if(p1.getFruit(0).getClass().equals(Pamplemousse.class))
            System.out.println("getFruit OK");
        else
            System.out.println("getFruit FALSE");

        //test de l'ajout d'un fruit
        if(p1.getFruits().size() == 1)
            System.out.println("ajout OK");
        else
            System.out.println("ajout FALSE");

        p1.ajout(new Pamplemousse());

        //test de la taille du panier
        if(p1.getTaillePanier() == 2)
            System.out.println("getTaillePanier OK");
        else
            System.out.println("getTaillePanier FALSE");

        //test de la méthode setFruit
        Fruit f = new Orange();
        p1.setFruit(0, f);
        if(p1.getFruit(0).getClass().equals(Orange.class))
            System.out.println("setFruit OK");
        else
            System.out.println("setFruit FALSE");

        //test si le panier p1 n'est pas vide
        if(!p1.estVide())
            System.out.println("estVide OK");
        else
            System.out.println("estVide FALSE");

        //création d'un second panier
        Panier p2 = new Panier(2);
        p2.ajout(new Orange());
        p2.ajout(new Pamplemousse());

        //test si le panier p2 est plein
        if(p2.estPlein())
            System.out.println("estPlein OK");
        else
            System.out.println("estPlein FALSE");

        //test si le contenu des paniers p1 et p2 est identique
        if(p1.equals(p2))
            System.out.println("equals OK");
        else
            System.out.println("equals FALSE");

        //test du prix du panier p1
        if(p1.getPrix() == 2.3)
            System.out.println("getPrix OK");
        else
            System.out.println("getPrix FALSE");

        //test de la méthode boycotteOrigine
        p1.boycotteOrigine("Espagne");
        if(p1.getTaillePanier() == 1)
            System.out.println("boycotteOrigine OK");
        else
            System.out.println("boycotteOrigine FALSE");

        //test de la méthode retrait
        p1.retrait();
        if(p1.estVide())
            System.out.println("retrait OK");
        else
            System.out.println("retrait FALSE");

        //descriptif du panier p2
        System.out.println("\n" + p2.toString());
    }
}
