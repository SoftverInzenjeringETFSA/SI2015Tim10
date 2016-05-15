package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import junit.framework.TestCase;

public class TrazenjeKategorijeVMTest extends TestCase 
{
	public void testNadjiKategoriju()
	{
		// testiranje uspješnog pronalaska kategorije
		
		DodavanjeKategorijeVM.dodajKategoriju("", "Software", null);
		Kategorija pronadjena = TrazenjeKategorijeVM.nadjiKategoriju("", "Software");
		assertEquals("Software", pronadjena.getIme());
		assertEquals("", pronadjena.getPutanja());
		
		//testiranje pronalaska podkategorije
		
		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju("", "Software");
		DodavanjeKategorijeVM.dodajKategoriju("Software/", "MS Office", parent);
		pronadjena = TrazenjeKategorijeVM.nadjiKategoriju("Software/", "MS Office");
		assertEquals("MS Office", pronadjena.getIme());
		assertEquals("Software/", pronadjena.getPutanja());
		
	}
	
	public void testNadjiKategorije()
	{
		// testiranje uspješnog pronalaska kategorija 
		
		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorije();
		assertEquals("Software", kategorije.get(0).getIme());
		assertEquals("", kategorije.get(0).getPutanja());
	}
	
	public void testNadjiKategorijeSaPutanjom()
	{
		// testrianje uspješnog pronalaska kategorija sa zadanom putanjom
		
		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorijeSaPutanjom("Software/");
		assertEquals("MS Office", kategorije.get(0).getIme());
		assertEquals("Software/", kategorije.get(0).getPutanja());
	}
	
	
}
