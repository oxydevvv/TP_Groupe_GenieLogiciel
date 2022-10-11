public class OrangeTest extends FruitSimpleTest
{

	// implementation of the abstract factory methods
	Fruit createFruit(double prix, String origine) 
	{
		return new Orange(prix, origine);
	}

	Fruit createFruitNull()
	{
		return null;
	}

	void testIsSeedless()
	{
		System.out.println("\nTEST IS SEEDLESS : \n");
		Orange o = new Orange(0.5, "France");
		assertTrue( false == o.isSeedless() );
	}

	void testToString()
	{
		System.out.println("\nTEST TO STRING : \n");
		Orange o = new Orange(0.5, "France");
		String s = "Orange de France a 0.5 euros";
		assertTrue( s.equals(o.toString()) );
	}

}