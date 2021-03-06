package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.Date;

import javax.swing.JList;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class BrisanjeKorisnikaVMTest extends TestCase 
{

	public void testBrisanjeKorisnika() 
	{
		// test uspješnog brisanja korisnika
		
		Session s = (Session) HibernateUtil.getSessionFactory().openSession();
		Date date = new Date();
		TipKorisnika tk = new TipKorisnika("Administrator");
		Operater o1 = new Operater("Mujo Alić", "Ferhadija bb");	
		
		Korisnik[] listdata = new Korisnik[1];
		listdata[0] = new Korisnik("Mujo", "Alić", "032-556-632", "0518994152184", "25OEOO17A", "Ferhadija bb", "mujo_alic@gmail.com", date, tk, "malic", o1, "1234");
		JList lista = new JList(listdata);
		
		DodavanjeKorisnikaVM.DodajKorisnika(s, "Mujo", "Alić", "0518994152184", "032-556-632", "mujo_alic@gmail.com", "malic", "1234", "Ferhadija bb", "25OEOO17A", date, tk.getTipKorisnika().toString(), o1.getIme(), "1234");
		BrisanjeKorisnikaVM.BrisiKorisnika(s, lista);
		
	}

}
