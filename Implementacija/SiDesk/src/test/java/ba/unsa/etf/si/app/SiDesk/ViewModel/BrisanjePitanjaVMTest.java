package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class BrisanjePitanjaVMTest extends TestCase 
{

	public void testObrisiPitanje() 
	{
		
		// testiranje uspješnog brisanja pitanja
		
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null, session);
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software", session);
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent, session);
		Pitanje p = new Pitanje("Kako otvoriti Control Panel?", "Start -> Control Panel");
		p.setKategorija_pitanja(TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office", session));
		p.setPutanja("Software/MS Office/");
		DodavanjePitanjaVM.dodajPitanje(p, session);
		
		boolean obrisano = BrisanjePitanjaVM.obrisiPitanje(p);
		assertTrue(obrisano);
		

		
	}

}
