public class BananeTest extends FruitSimpleTest
{

	// implementation of the abstract factory methods
	Fruit createFruit(double prix, String origine) 
	{
		return new Banane(prix, origine);
	}

	Fruit createFruitNull()
	{
		return null;
	}

	void testIsSeedless()
	{
		System.out.println("\nTEST IS SEEDLESS : \n");
		Banane o = new Banane(0.5, "France");
		assertTrue( o.isSeedless() );
	}

	void testToString()
	{
		System.out.println("\nTEST TO STRING : \n");
		Banane o = new Banane(0.5, "France");
		String s = "Banane de France a 0.5 euros";
		assertTrue( s.equals(o.toString()) );
	}

}