package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class PretragaKlijenataVMTest extends TestCase 
{
	public void testNadjiKlijenta()
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testiranje uspješnog pronalaska klijenta
		
		DodavanjeKlijentaVM.dodajKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar", session);
		Klijent k = PretragaKlijenataVM.nadjiKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar", session);
		assertEquals("Mujo", k.getIme());
		assertEquals("Alić", k.getPrezime());
		assertEquals("Ferhadija bb", k.getAdresa());
		assertEquals("032-556-632", k.getBrojTelefona());
		assertEquals(25, k.getStarost());
		assertEquals("pekar", k.getZaposlenje());
		
		session.close();
	}
}
