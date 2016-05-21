package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;
import java.util.List;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class ModifikacijaKlijentaVMTest extends TestCase 
{

	public void testModifikacijaKlijenta() 
	{
		// test uspješne modifikacije klijenta 
		
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		DodavanjeKlijentaVM.dodajKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar", session);
		List<Klijent> nadjeni = ModifikacijaKlijentaVM.nadjiKlijenta("Mujo", session);
		
		assertEquals(nadjeni.get(0).getIme(), "Mujo");
		
		nadjeni = ModifikacijaKlijentaVM.nadjiKlijenta1("Alić", session);
		
		assertEquals(nadjeni.get(0).getPrezime(), "Alić");
	}

}
