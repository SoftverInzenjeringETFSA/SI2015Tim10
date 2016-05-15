package ba.unsa.etf.si.app.SiDesk.Model;

import junit.framework.TestCase;

public class OperaterTest extends TestCase 
{

	public void testOperater() 
	{
		// testiranje konstruktora sa jednim parametrom testirajući vrijednosti polja
		
		Operater o = new Operater("Mujo Alić", "Ferhadija bb");
		
		assertEquals("Mujo Alić", o.getIme());
		assertEquals("Ferhadija bb", o.getAdresa());
	}

}
