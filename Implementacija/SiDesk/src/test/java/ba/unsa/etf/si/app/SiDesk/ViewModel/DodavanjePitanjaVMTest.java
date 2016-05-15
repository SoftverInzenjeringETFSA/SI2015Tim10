package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import junit.framework.TestCase;

public class DodavanjePitanjaVMTest extends TestCase 
{

	public void testDodajPitanje() 
	{
		// testiranje uspješnog dodavanja
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null);
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software");
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent);
		Pitanje p = new Pitanje("Kako otvoriti Control Panel?", "Start -> Control Panel");
		p.setKategorija_pitanja(TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office"));
		p.setPutanja("Software/MS Office/");
		boolean dodano = DodavanjePitanjaVM.dodajPitanje(p);
		assertTrue(dodano);
	}
	
	public void testPretraziPitanja()
	{
		// testiranje uspješne pretrage pitanja po ključnoj riječi na zadanoj putanji
		
		List<Pitanje> rezultatPretrage = DodavanjePitanjaVM.pretraziPitanja("Control", "Software/MS Office/" );
		assertEquals("Kako otvoriti Control Panel?", rezultatPretrage.get(0).getPitanje());
		assertEquals("Start -> Control Panel", rezultatPretrage.get(0).getOdgovor());
	}

}
