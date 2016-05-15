package ba.unsa.etf.si.app.SiDesk.Model;

import junit.framework.TestCase;

public class KlijentTest extends TestCase 
{

	public void testKlijent() 
	{
		// testiranje konstruktora sa jednim parametrom testirajući vrijednosti polja
		
		Klijent k = new Klijent("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar");
		assertEquals("Mujo", k.getIme());
		assertEquals("Alić", k.getPrezime());
		assertEquals("Ferhadija bb", k.getAdresa());
		assertEquals("032-556-632", k.getBrojTelefona());
		assertEquals(25, k.getStarost());
		assertEquals("pekar", k.getZaposlenje());
	}

}
