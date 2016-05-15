package ba.unsa.etf.si.app.SiDesk.Validation;

import java.util.Date;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

// posebno implementirati validacije za jedinstvenost
public class Validator {
	
	private static final int brojZnakovaJmbg = 13;
	private static final int minBrojZnakovaLicnaKarta = 9;
	private static final String Telefon_PATTERN1 = "([06]{2}[0-6]{1}[-]{1}[0-9]{3}[-]{1}[0-9]{3,})";
	private static final String Telefon_PATTERN2 = "([06]{2}[0-6]{1}[/]{1}[0-9]{3}[-]{1}[0-9]{3,})";
	private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9 ]*$";
//	private static final String NUMERIC_PATTERN = "^[0-9]*$";
	
	public static Boolean validairajJMBG(String jmbg) {
		
		if (jmbg.length() != brojZnakovaJmbg)
			return false;
		return true;
	}
	
	public static Boolean validirajBrojTelefona(String brojTelefona)
	{
		Pattern patern1 = Pattern.compile(Telefon_PATTERN1);
		Pattern patern2 = Pattern.compile(Telefon_PATTERN2);

		if (patern1.matcher(brojTelefona).matches() || patern2.matcher(brojTelefona).matches())
			return true;

		return false;
	}
	
	public static Boolean validirajStarost(int starost) {
		if (starost > 0)
			return true;
		
		return false;
	}
	
	public static Boolean validirajBrojLicneKarte(String brojLicneKarte) {
		if (brojLicneKarte.length() >= minBrojZnakovaLicnaKarta)
			return true;

		return false;
	}
	
	public static Boolean validirajEmail(String email) {
		if(email.contains("@"))
		return true;
		
		return false;
	}
	
	public static Boolean validirajDatumZaposlenja(Date datum) {
		
		Date danasnjiDatum = new Date();
		

		  if (danasnjiDatum.compareTo(datum)<0)
		 	return false;
		
		return true;
	}
	
	
	// validacija kad se postavlja sifra tj mijenja izgenerisana
	// barem jedan broj, veliko slovo i broj znakova veci od 8

	public static Boolean validirajSifru(String sifra) {
		
		boolean ima = false;
		char[] niz = sifra.toCharArray();
		for (int i = 0; i < sifra.length(); i++) {
			if (Character.isUpperCase(niz[i])) {
				ima = true;
				break;
			}
		}
		if (sifra.matches(".*\\d+.*") && sifra.length() >= 8 && ima)
			return true;

		return false;
	}
	
	
	public static Boolean validirajIme(String ime) {
		Pattern patern = Pattern.compile(ALPHANUMERIC_PATTERN);
		
		if(patern.matcher(ime).matches()) return true;
		return false;
	}
	
	public static Boolean validirajPrezime(String prezime) {
		Pattern patern = Pattern.compile(ALPHANUMERIC_PATTERN);
		
		if(patern.matcher(prezime).matches()) return true;
		return false;
	}

}
