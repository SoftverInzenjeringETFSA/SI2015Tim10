package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import junit.framework.TestCase;

public class ModifikacijaKategorijeVMTest extends TestCase 
{

	public void testModifikacijaKategorije() 
	{
		// testiranje uspješne modifikacije kategorije
		
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null);	
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software");
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent);
		boolean modificirana = ModifikacijaKategorijeVM.modifikacijaKategorije("Software/", "MS Office", "Office alati");
		Kategorija pronadjena = TrazenjeKategorijeVM.nadjiKategoriju("Software/", "Office alati");
		assertEquals("Office alati", pronadjena.getIme());
		assertEquals("Software/", pronadjena.getPutanja());
		assertTrue(modificirana);
		
	}

}
