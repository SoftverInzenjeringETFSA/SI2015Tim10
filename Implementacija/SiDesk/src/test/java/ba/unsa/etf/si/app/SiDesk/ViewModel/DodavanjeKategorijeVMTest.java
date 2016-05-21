package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class DodavanjeKategorijeVMTest extends TestCase 
{

	public void testDodajKategoriju() 
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testiranje ispravnog dodavanja kategorije
		
		//dodavanje početne kategorije (nema putanje, ni parenta)
		boolean dodana = DodavanjeKategorijeVM.dodajKategoriju("", "Software", null, session);
		assertTrue(dodana);
		
		//dodavanje podkategorije
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software", session);
		dodana = DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent, session);
		assertTrue(dodana);
		
		//dodavanje podkategorije unutar podkategorije
		parent = TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office", session);
		dodana = DodavanjeKategorijeVM.dodajKategoriju("Software/Ms Office/", "Word", parent, session);
		assertTrue(dodana);
		
		session.close();
	}

}
