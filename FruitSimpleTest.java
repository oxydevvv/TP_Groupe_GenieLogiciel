public abstract class FruitSimpleTest 
{
	 // the factory methods
	 abstract FruitSimple createFruit(double prix, String origine);
	 abstract FruitSimple createFruitNull();

	 @Test
	 public void testGetPrix() 
	 {
	 	FruitSimple fn = createFruitNull();
	 	FruitSimple fs = createFruit(0.5, "France");
	 	double expectedPrice = 0.5;
	 	assertTrue( expectedPrice == fs.getPrix() );
	 	assertTrue( null == fn.getPrix() );
	 }

	 public void testGetOrigine()
	 {
	 	FruitSimple fn = createFruitNull();
	 	FruitSimple fs = createFruit(0.5, "France");
		double expectedCountry = "France";
		assertTrue( expectedCountry == fs.getOrigine() );
		assertTrue( null == fn.getOrigine() );
	 }

	 public void testEquals()
	 {

	 	FruitSimple[] fruits = new FruitSimple[] {
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