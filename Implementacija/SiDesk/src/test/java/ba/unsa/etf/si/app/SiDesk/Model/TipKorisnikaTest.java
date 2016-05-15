package ba.unsa.etf.si.app.SiDesk.Model;

import junit.framework.TestCase;

public class TipKorisnikaTest extends TestCase 
{

	public void testTipKorisnika() 
	{
		// testiranje konstruktora s jednim parametrom i privatne metode postaviTipKorisnika u njemu
		
		TipKorisnika tk = new TipKorisnika("Administrator");
		
		assertEquals("Administrator", tk.getTipKorisnika());
	}
	
	public void testSetTipKorisnika()
	{
		// testrianje metode setTipKorisnika koja poziva metodu postaviTipKorisnika
		
		TipKorisnika tk = new TipKorisnika();
		tk.setTipKorisnika("Administrator");
		
		assertEquals("Administrator", tk.getTipKorisnika());
	}

}
