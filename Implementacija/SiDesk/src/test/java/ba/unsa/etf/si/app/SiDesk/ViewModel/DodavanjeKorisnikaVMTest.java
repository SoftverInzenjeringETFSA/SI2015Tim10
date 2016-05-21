package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;
import junit.framework.TestCase;

public class DodavanjeKorisnikaVMTest extends TestCase 
{

	public void testDodajKorisnika() 
	{
		// test uspješnog dodavanja korisnika
		Session s = null;
		Date date = new Date();
		TipKorisnika tk = new TipKorisnika("Administrator");
		Operater o1 = new Operater("Mujo Alić", "Ferhadija bb");
		boolean dodan = DodavanjeKorisnikaVM.DodajKorisnika(s, "Mujo", "Alić", "0518994152184", "032-556-632", "mujo_alic@gmail.com", "malic", "1234", "Ferhadija bb", "25OEOO17A", date, tk.getTipKorisnika().toString(), o1.getIme(), "1234");
		assertTrue(dodan);
	}

}
