package fr.ufrsciencestech.groupe3.model;
/**
 *
 * @author roudet
 */
public class Durian {
    private double prix;
    private String origine;

    public Durian()
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }

    public Durian(double prix, String origine)
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
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
        return "Durian de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Durians sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Durian or = (Durian) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Durian a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
	       System.out.println("premier test Durian");
         Durian Durian_1 = new Durian();
         Durian Durian_2 = new Durian(0.6, "Corée du Nord");
         Durian Durian_3 = new Durian(0.5, "Espagne");

         if( Durian_1.equals(Durian_3) && !(Durian_1.equals(Durian_2)) && Durian_2.getPrix() == 0.6 && Durian_1.getClass() ==  Durian_2.getClass() )
         {
           System.out.println("TRUE");
         }
         else
         {
           System.out.println("FALSE");
         }
   }
}
