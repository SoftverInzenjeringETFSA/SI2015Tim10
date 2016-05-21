package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;


public class BrisanjeKategorijeVMTest extends TestCase 
{

	public void testObrisiKategoriju() 
	{
		// testiranj uspješnog brisanja kategorije, kad kategorija postoji
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null, session);
		boolean obrisana = BrisanjeKategorijeVM.obrisiKategoriju("", "Software", session);
		assertTrue(obrisana);
		
		
		// testiranje neuspješnog brisanja, jer kategorija ne postoji
		
		obrisana = BrisanjeKategorijeVM.obrisiKategoriju("", "Hardware", session);
		assertFalse(obrisana);
		
		
	}

}
