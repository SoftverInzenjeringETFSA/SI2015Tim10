package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Date;

import junit.framework.TestCase;

public class PrijavaTest extends TestCase 
{

	public void testPrijava() 
	{
		// testiranje konstruktora sa jednim parametrom
		
		Date date = new Date();
		TipKorisnika tk = new TipKorisnika("Administrator");
		Operater o = new Operater("Mujo Alić", "Ferhadija bb");
		Korisnik k = new Korisnik("Mujo", "Alić", "032-556-632", "0512994192184", "25OEOO17A", "Ferhadija, Sarajevo", "mujo_alic@gmail.com", date, tk, "malic", o, "1234");
	
		Prijava p = new Prijava(k);
		
		assertEquals("Mujo", p.getKorisnik().getIme());
		assertEquals("Alić", p.getKorisnik().getPrezime());
		assertEquals("032-556-632", p.getKorisnik().getBrojTelefona());
		assertEquals("0512994192184", p.getKorisnik().getJmbg());
		assertEquals("25OEOO17A", p.getKorisnik().getBrojLicneKarte());
		assertEquals("Ferhadija, Sarajevo", p.getKorisnik().getAdresa());
		assertEquals("mujo_alic@gmail.com", p.getKorisnik().getEmail());
		assertEquals(date, p.getKorisnik().getDatumZaposlenja());
		assertEquals("Administrator", p.getKorisnik().getTipkorisnika().getTipKorisnika());
		assertEquals("malic", p.getKorisnik().getKorisnickoIme());
		assertTrue(p.getKorisnik().getSifra() instanceof String);
		assertEquals("Mujo Alić", p.getKorisnik().getOperater_korisnik().getIme());
		assertEquals("Ferhadija bb", p.getKorisnik().getOperater_korisnik().getAdresa());
	}

}
