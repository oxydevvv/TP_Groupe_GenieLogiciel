public class CeriseTest extends FruitSimpleTest
{

	// implementation of the abstract factory methods
	Fruit createFruit(double prix, String origine) 
	{
		return new Cerise(prix, origine);
	}

	Fruit createFruitNull()
	{
		return null;
	}

	void testIsSeedless()
	{
		System.out.println("\nTEST IS SEEDLESS : \n");
		Cerise o = new Cerise(0.5, "France");
		assertFalse( o.isSeedless() );
	}

	void testToString()
	{
		System.out.println("\nTEST TO STRING : \n");
		Cerise o = new Cerise(0.5, "France");
		String s = "Cerise de France a 0.5 euros";
		assertTrue( s.equals(o.toString()) );
	}

}