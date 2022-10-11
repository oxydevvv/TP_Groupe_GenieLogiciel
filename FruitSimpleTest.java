public abstract class FruitSimpleTest 
{

	static void assertTrue(boolean b)
	{
		if(b) {System.out.println("Success !");}
		else {System.out.println("Fail !");}
	}

	static void assertFalse(boolean b)
	{
		if(!b) {System.out.println("Success !");}
		else {System.out.println("Fail !");}
	}

	// the factory methods
	abstract Fruit createFruit(double prix, String origine);
	abstract Fruit createFruitNull();

	public void testGetPrix() 
	{
		System.out.println("\nTEST GET PRIX : \n");
		Fruit fs = createFruit(0.5, "France");
		double expectedPrice = 0.5;
		boolean b = expectedPrice == fs.getPrix();
		assertTrue( b );
	}

	public void testGetOrigine()
	{
		System.out.println("\nTEST GET ORIGINE : \n");
		Fruit fs = createFruit(0.5, "France");
		String expectedCountry = "France";
		boolean b = expectedCountry.equals(fs.getOrigine());
		assertTrue( b );
	}

	public void testEquals()
	{

		System.out.println("\nTEST EQUALS : \n");

		Fruit[] fruits = new Fruit[] {
	 	createFruit(0.5, "France"),
	 	createFruit(0.5, "France"),
	 	createFruit(0.35, "Maroc"),
	 	createFruit(0.5, "Italie"),
	 	createFruit(0.4, "Maroc")
		};

	 	assertTrue( true == ( fruits[0].equals(fruits[1]) ) );
	 	assertTrue( false == ( fruits[0].equals(fruits[2]) ) );
	 	assertTrue( false == ( fruits[0].equals(fruits[3]) ) );
	 	assertTrue( false == ( fruits[2].equals(fruits[4]) ) );
	 
	}

};