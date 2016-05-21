package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import junit.framework.TestCase;

public class TrazenjeKategorijeVMTest extends TestCase 
{
	public void testNadjiKategoriju()
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testiranje uspješnog pronalaska kategorije
		
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null, session);
		Kategorija pronadjena = TrazenjeKategorijeVM.nadjiKategoriju("", "Software", session);
		assertEquals("Software", pronadjena.getIme());
		assertEquals("", pronadjena.getPutanja());
		
		//testiranje pronalaska podkategorije
		
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software", session);
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent, session);
		pronadjena = TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office", session);
		assertEquals("MS Office", pronadjena.getIme());
		assertEquals("Software/", pronadjena.getPutanja());
		
		session.close();
		
	}
	
	public void testNadjiKategorije()
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testiranje uspješnog pronalaska kategorija 
		
		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorije(session);
		assertEquals("Software", kategorije.get(0).getIme());
		assertEquals("", kategorije.get(0).getPutanja());
		
		session.close();
	}
	
	public void testNadjiKategorijeSaPutanjom()
	{
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();

		// testrianje uspješnog pronalaska kategorija sa zadanom putanjom
		
		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorijeSaPutanjom("Software/", session);
		assertEquals("MS Office", kategorije.get(0).getIme());
		assertEquals("Software/", kategorije.get(0).getPutanja());
		
		session.close();
	}
	
	
}
