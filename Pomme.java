/**
 *
 * @author roudet
 */
public class Pomme implements Fruit{
    private double prix;
    private String origine;
	
    public Pomme() 
    {
        this.prix = 1.25;  //prix en euros
        this.origine="Etats-Unis";
    }
    
    public Pomme(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Etats-Unis";  //Etats-Unis par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Pomme de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 pommes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Pomme or = (Pomme) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Pomme a des pepins
        return false;
    }


    public static void main (String[] args)
    {
        //Ecrire ici vos tests

        System.out.println("1e test Pomme");

        Pomme Pomme1 = new Pomme();
        System.out.println("Constructeur par défaut : " + Pomme1.toString() + "\n");

        System.out.println("2e test Pomme");

        Pomme Pomme2 = new Pomme(1.0, "France");
        System.out.println("Valeurs avant modification : " + Pomme2.toString());

        Pomme2.setPrix(1.25);
        System.out.println("Prix après modification : " + Pomme2.getPrix());

        Pomme2.setOrigine("Etats-Unis");
        System.out.println("Origine après modification : " + Pomme2.getOrigine());

        System.out.println("Valeurs après modification : " + Pomme2.toString() + "\n");

        System.out.println("3e test Pomme");
        System.out.println("Les deux Pommes ont les mêmes caractériques ? " + Pomme1.equals(Pomme2));
    }
}
