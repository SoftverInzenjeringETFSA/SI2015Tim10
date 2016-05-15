package ba.unsa.etf.si.app.SiDesk.ViewModel;

import junit.framework.TestCase;


public class BrisanjeKategorijeVMTest extends TestCase 
{

	public void testObrisiKategoriju() 
	{
		// testiranj uspješnog brisanja kategorije, kad kategorija postoji
		
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null);
		boolean obrisana = BrisanjeKategorijeVM.obrisiKategoriju("", "Software");
		assertTrue(obrisana);
		
		
		// testiranje neuspješnog brisanja, jer kategorija ne postoji
		
		obrisana = BrisanjeKategorijeVM.obrisiKategoriju("", "Hardware");
		assertFalse(obrisana);
		
	}

}
