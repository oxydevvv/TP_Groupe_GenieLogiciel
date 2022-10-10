public class OrangeTest extends FruitSimpleTest
{

	 // implementation of the abstract factory methods
	 FruitSimple createFruit(double prix, String origine) 
	 {
	 	return new Orange(prix, origine);
	 }

	 FruitSimple createFruitNull()
	 {
	 	return null;
	 }

	 void testIsSeedless()
	 {
	 	Orange o = new Orange(0.5, "France");
	 	assertTrue( true == o.isSeedless());
	 }

	 void testToString()
	 {
	 	Orange o = new Orange(0.5, "France");
	 	String s = "Orange de France a 0.5 euros";
	 	assertTrue( s == o.toString() );
	 }

}