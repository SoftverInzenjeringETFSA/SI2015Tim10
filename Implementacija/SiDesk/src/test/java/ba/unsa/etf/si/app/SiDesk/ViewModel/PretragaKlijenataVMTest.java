package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import junit.framework.TestCase;

public class PretragaKlijenataVMTest extends TestCase 
{
	public void testNadjiKlijenta()
	{
		// testiranje uspješnog pronalaska klijenta
		
		DodavanjeKlijentaVM.dodajKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar");
		Klijent k = PretragaKlijenataVM.nadjiKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar");
		assertEquals("Mujo", k.getIme());
		assertEquals("Alić", k.getPrezime());
		assertEquals("Ferhadija bb", k.getAdresa());
		assertEquals("032-556-632", k.getBrojTelefona());
		assertEquals(25, k.getStarost());
		assertEquals("pekar", k.getZaposlenje());
	}
}