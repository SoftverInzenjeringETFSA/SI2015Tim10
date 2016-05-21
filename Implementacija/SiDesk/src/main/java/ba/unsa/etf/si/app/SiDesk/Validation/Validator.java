package ba.unsa.etf.si.app.SiDesk.Validation;

import java.util.Date;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;

// posebno implementirati validacije za jedinstvenost
public class Validator {
	
	private static final int brojZnakovaJmbg = 13;
	private static final int minBrojZnakovaLicnaKarta = 9;
	private static final String Telefon_PATTERN1 = "([06]{2}[0-6]{1}[-]{1}[0-9]{3}[-]{1}[0-9]{3,})";
	private static final String Telefon_PATTERN2 = "([06]{2}[0-6]{1}[/]{1}[0-9]{3}[-]{1}[0-9]{3,})";
	private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9 ]*$";
	
//	private static final String NUMERIC_PATTERN = "^[0-9]*$";
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static Boolean validairajJMBG(String jmbg) {
		
		if (jmbg.length() != brojZnakovaJmbg)
		{
			JOptionPane.showMessageDialog(null, "Ne ispravan jmbg, jmbg mora imati 13 brojeva!", "Info", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		return true;
	}
	
	public static Boolean validirajBrojTelefona(String brojTelefona)
	{
		Pattern patern1 = Pattern.compile(Telefon_PATTERN1);
		Pattern patern2 = Pattern.compile(Telefon_PATTERN2);

		if (patern1.matcher(brojTelefona).matches() || patern2.matcher(brojTelefona).matches() || brojTelefona.equals(""))
			return true;
		else
		{
			JOptionPane.showMessageDialog(null, "Ne ispravan broj telefona.Primjeri ispravnih brojeva telefona: 061-111-111 ili 062-222-2222!", "Info", JOptionPane.ERROR_MESSAGE);
			
			
		return false;
		}
	}
	
	public static Boolean validirajStarost(int starost) {
		if (starost > 0)
			return true;
		
		return false;
	}
	
	public static Boolean validirajBrojLicneKarte(String brojLicneKarte) {
		if(brojLicneKarte.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Unesite broj licne karte. Broj mora imati bar 9 simbola!", "Info", JOptionPane.ERROR_MESSAGE);
		return false;	
			
		}
		if (brojLicneKarte.length() >= minBrojZnakovaLicnaKarta)
			return true;
		else
		{
			JOptionPane.showMessageDialog(null, "Ne ispravan broj licne karte. Broj mora imati bar 9 simbola!", "Info", JOptionPane.ERROR_MESSAGE);
			
		return false;
		}
	}
	
	public static Boolean validirajEmail(String email) {

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
			if(pattern.matcher(email).matches() )
			return true;
		
		else 
			{
			JOptionPane.showMessageDialog(null, "Ne ispravan email. Primjer ispravnog maila Korisnik@Koricnikovic.ba!", "Info", JOptionPane.ERROR_MESSAGE);
			
			return false;
			
			}
	}
	
	public static Boolean validirajDatumZaposlenja(Date datum) {
		
		Date danasnjiDatum = new Date();
		

		  if (danasnjiDatum.compareTo(datum)<0)
		  {
				JOptionPane.showMessageDialog(null, "Odabrani datum treba biti prije danasnjeg datuma!", "Info", JOptionPane.ERROR_MESSAGE);
					  
		 	return false;
		  }
		return true;
	}
	
	
	// validacija kad se postavlja sifra tj mijenja izgenerisana
	// barem jedan broj, veliko slovo i broj znakova veci od 8

	public static Boolean validirajSifru(String sifra) {
		
		if(sifra.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Unesite  lozinku, unosenjem alfanumericke simbole, ili klikom na button Generiši lozinku!", "Info", JOptionPane.ERROR_MESSAGE);
			return false;
		}
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
	
	public static Boolean KorisnickoIme(String korisnicko)
	{
		if(korisnicko.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Unesite korisnicko ime. Korisnicko ime treba sadrzavati bar 1 alfanumericki simbol!", "Info", JOptionPane.ERROR_MESSAGE);
		return false;	
			
		}
	
		return true;
	}
	public static Boolean validirajIme(String ime) {
		Pattern patern = Pattern.compile(ALPHANUMERIC_PATTERN);
		if(ime.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Unesite ime, ime treba sadrzavati bar 1 alfanumericki simbol!", "Info", JOptionPane.ERROR_MESSAGE);
		return false;	
			
		}
		if(patern.matcher(ime).matches()) return true;
		return false;
	}
	
	public static Boolean validirajPrezime(String prezime) {
		if(prezime.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Unesite prezime. Prezime treba sadrzavati bar 1 alfanumericki simbol!", "Info", JOptionPane.ERROR_MESSAGE);
		return false;	
			
		}
		Pattern patern = Pattern.compile(ALPHANUMERIC_PATTERN);
		
		if(patern.matcher(prezime).matches()) return true;
		return false;
	}

}
