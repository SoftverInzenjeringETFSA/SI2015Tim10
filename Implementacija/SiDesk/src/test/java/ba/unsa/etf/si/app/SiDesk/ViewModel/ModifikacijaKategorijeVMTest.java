package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class ModifikacijaKategorijeVMTest extends TestCase 
{

	public void testModifikacijaKategorije() 
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testiranje uspješne modifikacije kategorije
		
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null, session);	
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software", session);
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent, session);
		boolean modificirana = ModifikacijaKategorijeVM.modifikacijaKategorije("Software/", "MS Office", "Office alati", session);
		Kategorija pronadjena = TrazenjeKategorijeVM.nadjiKategoriju("Software/", "Office alati", session);
		assertEquals("Office alati", pronadjena.getIme());
		assertEquals("Software/", pronadjena.getPutanja());
		assertTrue(modificirana);
		
		session.close();
		
	}

}
