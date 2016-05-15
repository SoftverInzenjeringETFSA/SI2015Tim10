package ba.unsa.etf.si.app.SiDesk.Validation;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.hibernate.type.CalendarDateType;

public class ValidatorTest extends TestCase 
{
	
	public void testValidairajJMBG() 
	{
		
		// testiranje validnog matičnog broja
		
		String jmbg = "0512994192184";
		assertTrue(Validator.validairajJMBG(jmbg));
		
		// testiranje matičnog broja koji nije validan
		
		jmbg = "0512994";
		assertFalse(Validator.validairajJMBG(jmbg));
	}

	public void testValidirajBrojTelefona() 
	{
		// testiranje validnog broja telefona
		
		//patern 1
		String brojTelefona = "062-256-542";
		assertTrue(Validator.validirajBrojTelefona(brojTelefona));
		
		//patern 2
		brojTelefona = "062/256-542";
		assertTrue(Validator.validirajBrojTelefona(brojTelefona));
		
		// testiranje broja telefona koji nije validan
		
		brojTelefona = "062256542";
		assertFalse(Validator.validirajBrojTelefona(brojTelefona));
	}

	public void testValidirajStarost() 
	{
		// testiranje validne starosti
		
		assertTrue(Validator.validirajStarost(20));
		
		// testiranje starosti koja nije validna
		
		assertFalse(Validator.validirajStarost(0));
		assertFalse(Validator.validirajStarost(-5 ));
	}

	public void testValidirajBrojLicneKarte() 
	{
		// testiranje validnog broja lične karte
		
		String brojLicneKarte = "B25475ADF";
		assertTrue(Validator.validirajBrojLicneKarte(brojLicneKarte));
		
		// testiranje broja lične karte koji nije validan
		
		brojLicneKarte = "B254DF";
		assertFalse(Validator.validirajBrojLicneKarte(brojLicneKarte));
	}

	public void testValidirajEmail() 
	{
		// testiranje validnog emaila
		
		String email = "mujoalic@gmail.com";
	    assertTrue(Validator.validirajEmail(email));
		
		// testiranje emaila koji nije validan
	    
	    email = "mujoalicgmail.com";
	    assertFalse(Validator.validirajEmail(email));
	}

	public void testValidirajDatumZaposlenja() 
	{
		// testiranje validnog datuma zaposlenja
		
		// vrijeme prije trenutka provjere
		Date datum = new Date();
		assertTrue(Validator.validirajDatumZaposlenja(datum));
		
		// vrijeme u momentu provjere
		assertTrue(Validator.validirajDatumZaposlenja(new Date()));
		
	    // testiranje datuma zaposlenja koji nije validan
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2025);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		datum = cal.getTime();
		assertFalse(Validator.validirajDatumZaposlenja(datum));
	}

	public void testValidirajSifru() 
	{
		// testiranje validne šifre
		
		String sifra = "aB25asd22";
		assertTrue(Validator.validirajSifru(sifra));
		
		// testiranje šifre koja nije validna
		
		//nema broj
		sifra = "aBpkolahaaaa";
		assertFalse(Validator.validirajSifru(sifra));
		
		//broj znakova manji od 8
		sifra = "aB7a";
		assertFalse(Validator.validirajSifru(sifra));
		
		//nema veliko slovo
		sifra = "akortlshdzd7a";
		assertFalse(Validator.validirajSifru(sifra));
	}
	
	public void testValidirajIme() 
	{
		// testiranje validnog imena
		
		//velika i mala slova
		String ime = "Mujo";
		assertTrue(Validator.validirajIme(ime));
		
		//slova i brojevi
		ime = "mujo1";
		assertTrue(Validator.validirajIme(ime));
		
	    // testiranje imena koje nije validno
		
		ime = "mujo1_/";
		assertFalse(Validator.validirajIme(ime));
	}

	public void testValidirajPrezime() 
	{
		//velika i mala slova
		String prezime = "Alic";
		assertTrue(Validator.validirajIme(prezime));
		
		//slova i brojevi
		prezime = "alic1";
		assertTrue(Validator.validirajIme(prezime));
		
	    // testiranje imena koje nije validno
		
		prezime = "alic_/";
		assertFalse(Validator.validirajIme(prezime));
	}

}
