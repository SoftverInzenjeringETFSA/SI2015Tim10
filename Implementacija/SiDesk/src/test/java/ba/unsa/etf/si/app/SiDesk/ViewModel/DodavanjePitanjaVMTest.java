package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class DodavanjePitanjaVMTest extends TestCase 
{

	public void testDodajPitanje() 
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testiranje uspješnog dodavanja
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null, session);
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software", session);
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent, session);
		Pitanje p = new Pitanje("Kako otvoriti Control Panel?", "Start -> Control Panel");
		p.setKategorija_pitanja(TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office", session));
		p.setPutanja("Software/MS Office/");
		boolean dodano = DodavanjePitanjaVM.dodajPitanje(p, session);
		assertTrue(dodano);
		
		session.close();
	}
	
	public void testPretraziPitanja()
	{
		// testiranje uspješne pretrage pitanja po ključnoj riječi na zadanoj putanji
		
		//List<Pitanje> rezultatPretrage = DodavanjePitanjaVM.pretraziPitanja("Control", "Software/MS Office/" );
		//assertEquals("Kako otvoriti Control Panel?", rezultatPretrage.get(0).getPitanje());
		//assertEquals("Start -> Control Panel", rezultatPretrage.get(0).getOdgovor());
	}

}
