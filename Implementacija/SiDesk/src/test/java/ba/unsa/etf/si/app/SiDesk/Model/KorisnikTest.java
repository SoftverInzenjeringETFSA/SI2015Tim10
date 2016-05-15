package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Date;
import junit.framework.TestCase;

public class KorisnikTest extends TestCase 
{

	public void testKorisnik() 
	{
		// testiranje konstruktora sa jednim parametrom testirajući vrijednosti polja
		
		Date date = new Date();
		TipKorisnika tk = new TipKorisnika("Administrator");
		Operater o1 = new Operater("Mujo Alić", "Ferhadija bb");
		Korisnik k = new Korisnik("Mujo", "Alić", "032-556-632", "0512994192184", "25OEOO17A", "Ferhadija, Sarajevo", "mujo_alic@gmail.com", date, tk, "malic", o1, "1234");
		
		assertEquals("Mujo", k.getIme());
		assertEquals("Alić", k.getPrezime());
		assertEquals("032-556-632", k.getBrojTelefona());
		assertEquals("0512994192184", k.getJmbg());
		assertEquals("25OEOO17A", k.getBrojLicneKarte());
		assertEquals("Ferhadija, Sarajevo", k.getAdresa());
		assertEquals("mujo_alic@gmail.com", k.getEmail());
		assertEquals(date, k.getDatumZaposlenja());
		assertEquals("Administrator", k.getTipkorisnika().getTipKorisnika());
		assertEquals("malic", k.getKorisnickoIme());
		assertTrue(k.getSifra() instanceof String);
		assertEquals("Mujo Alić", k.getOperater_korisnik().getIme());
		assertEquals("Ferhadija bb", k.getOperater_korisnik().getAdresa());
		
	}

}
