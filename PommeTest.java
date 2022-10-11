public class PommeTest extends FruitSimpleTest
{

	// implementation of the abstract factory methods
	Fruit createFruit(double prix, String origine) 
	{
		return new Pomme(prix, origine);
	}

	Fruit createFruitNull()
	{
		return null;
	}

	void testIsSeedless()
	{
		System.out.println("\nTEST IS SEEDLESS : \n");
		Pomme o = new Pomme(0.5, "France");
		assertTrue( true == o.isSeedless() );
	}

	void testToString()
	{
		System.out.println("\nTEST TO STRING : \n");
		Pomme o = new Pomme(0.5, "France");
		String s = "Pomme de France a 0.5 euros";
		assertTrue( s.equals(o.toString()) );
	}

}