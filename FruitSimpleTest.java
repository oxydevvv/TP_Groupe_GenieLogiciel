import org.junit.Test;

public abstract class FruitSimpleTest 
{
	 // the factory methods
	 abstract Fruit createFruit(double prix, String origine);
	 abstract Fruit createFruitNull();

	 public void testGetPrix() 
	 {
	 	Fruit fs = createFruit(0.5, "France");
	 	double expectedPrice = 0.5;
	 	boolean b = expectedPrice == fs.getPrix();
		assertTrue( b );
	 }

	 public void testGetOrigine()
	 {
	 	Fruit fs = createFruit(0.5, "France");
		String expectedCountry = "France";
		boolean b = expectedCountry.equals(fs.getOrigine());
		assertTrue( b );
	 }

	 public void testEquals()
	 {

	 	Fruit[] fruits = new Fruit[] {
	 		createFruit(0.5, "France"),
	 		createFruit(0.5, "France"),
	 		createFruit(0.35, "Maroc"),
	 		createFruit(0.5, "Italie"),
	 		createFruit(0.4, "Maroc"),
	 		createFruitNull()
	 	};

	 	assertTrue( true == ( fruits[0].equals(fruits[1]) ) );
	 	assertTrue( false == ( fruits[0].equals(fruits[2]) ) );
	 	assertTrue( false == ( fruits[0].equals(fruits[3]) ) );
	 	assertTrue( false == ( fruits[2].equals(fruits[4]) ) );
	 	assertTrue( false == ( fruits[0].equals(fruits[5]) ) );
	 	assertTrue( true == ( fruits[5].equals(fruits[5]) ) );
	 
	 }

};