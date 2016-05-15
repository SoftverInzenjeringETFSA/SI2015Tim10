package ba.unsa.etf.si.app.SiDesk.Model;

import junit.framework.TestCase;

public class KategorijaTest extends TestCase 
{

	public void testKategorija() 
	{
		// testiranje konstruktora sa jednim parametrom testirajući ime
		
		Kategorija k = new Kategorija("MS Office");
		assertEquals("MS Office", k.getIme());
	}

}
