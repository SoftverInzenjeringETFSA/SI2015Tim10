package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class BrisanjeKlijentaVMTest extends TestCase 
{

	public void testBrisanjeKlijenta() 
	{
		// testiranje uspješnog brisanja klijenta
		
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		
		DodavanjeKlijentaVM.dodajKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar");
		Klijent k = PretragaKlijenataVM.nadjiKlijenta("Mujo", "Alić", "Ferhadija bb", "032-556-632", 25, "pekar", session);
		
		boolean obrisan = BrisanjeKlijentaVM.brisanjeKlijenta(k);
		
		assertTrue(obrisan);
		
	}

}
