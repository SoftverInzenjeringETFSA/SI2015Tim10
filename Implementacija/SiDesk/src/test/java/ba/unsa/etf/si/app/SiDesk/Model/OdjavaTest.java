package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Date;
import junit.framework.TestCase;

public class OdjavaTest extends TestCase 
{

	public void testOdjava() 
	{
		// testiranje konstruktora sa jednim parametrom testirajući vrijednosti polja
		
		Date date = new Date();
		TipKorisnika tk = new TipKorisnika("Administrator");
		Operater o1 = new Operater("Mujo Alić", "Ferhadija bb");
		Korisnik k = new Korisnik("Mujo", "Alić", "032-556-632", "0512994192184", "25OEOO17A", "Ferhadija, Sarajevo", "mujo_alic@gmail.com", date, tk, "malic", o1, "1234");
	
		Odjava o = new Odjava(k);
		
		assertEquals("Mujo", o.getKorisnik().getIme());
		assertEquals("Alić", o.getKorisnik().getPrezime());
		assertEquals("032-556-632", o.getKorisnik().getBrojTelefona());
		assertEquals("0512994192184", o.getKorisnik().getJmbg());
		assertEquals("25OEOO17A", o.getKorisnik().getBrojLicneKarte());
		assertEquals("Ferhadija, Sarajevo", o.getKorisnik().getAdresa());
		assertEquals("mujo_alic@gmail.com", o.getKorisnik().getEmail());
		assertEquals(date, o.getKorisnik().getDatumZaposlenja());
		assertEquals("Administrator", o.getKorisnik().getTipkorisnika().getTipKorisnika());
		assertEquals("malic", o.getKorisnik().getKorisnickoIme());
		assertTrue(o.getKorisnik().getSifra() instanceof String);
		assertEquals("Mujo Alić", o.getKorisnik().getOperater_korisnik().getIme());
		assertEquals("Ferhadija bb", o.getKorisnik().getOperater_korisnik().getAdresa());
	}

}
