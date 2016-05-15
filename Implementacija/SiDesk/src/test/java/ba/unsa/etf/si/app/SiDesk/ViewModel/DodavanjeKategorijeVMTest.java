package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import junit.framework.TestCase;

public class DodavanjeKategorijeVMTest extends TestCase 
{

	public void testDodajKategoriju() 
	{
		// testiranje ispravnog dodavanja kategorije
		
		//dodavanje početne kategorije (nema putanje, ni parenta)
		boolean dodana = DodavanjeKategorijeVM.dodajKategoriju("", "Software", null);
		assertTrue(dodana);
		
		//dodavanje podkategorije
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software");
		dodana = DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent);
		assertTrue(dodana);
		
		//dodavanje podkategorije unutar podkategorije
		parent = TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office");
		dodana = DodavanjeKategorijeVM.dodajKategoriju("Software/Ms Office/", "Word", parent);
		assertTrue(dodana);
	}

}
