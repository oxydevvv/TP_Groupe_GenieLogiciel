public class DurianTest extends FruitSimpleTest
{

	// implementation of the abstract factory methods
	Fruit createFruit(double prix, String origine) 
	{
		return new Durian(prix, origine);
	}

	Fruit createFruitNull()
	{
		return null;
	}

	void testIsSeedless()
	{
		System.out.println("\nTEST IS SEEDLESS : \n");
		Durian o = new Durian(0.5, "France");
		assertFalse( o.isSeedless() );
	}

	void testToString()
	{
		System.out.println("\nTEST TO STRING : \n");
		Durian o = new Durian(0.5, "France");
		String s = "Durian de France a 0.5 euros";
		assertTrue( s.equals(o.toString()) );
	}

}