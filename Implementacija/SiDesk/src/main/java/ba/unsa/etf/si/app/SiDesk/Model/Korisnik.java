package ba.unsa.etf.si.app.SiDesk.Model;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

public class Korisnik {

	private String ime;
	private String prezime;
	private String brojTelefona;
	private String jmbg;
	private String brojLicneKarte;
	private String adresa;
	private String email;
	private Date datumZaposlenja;
	private TipKorisnika tipKorisnika;
	private String korisnickoIme;
	private String sifra;
	
	

	public Korisnik() {
		
	}
	
	public Korisnik(String  ime, String prezime, String brojTelefona, 
			        String jmbg, String brojLicneKarte, String adresa,
			        String email, Date datumZaposlenja, TipKorisnika tipKorisnika,
			        String korisnickoIme) {
		
		this.ime=ime;
		this.prezime=prezime;
		this.brojTelefona=brojTelefona;
		this.jmbg=jmbg;
		this.brojLicneKarte=brojLicneKarte;
		this.adresa=adresa;
		this.email=email;
		this.datumZaposlenja=datumZaposlenja;
		this.tipKorisnika=tipKorisnika;
		this.korisnickoIme=korisnickoIme;
		this.sifra=generisiLozinku(); // jedinstven ili ne, baza
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatumZaposlenja() {
		return datumZaposlenja;
	}

	public void setDatumZaposlenja(Date datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	//nisam sigurna
	public String getSifra() {
		return sifra;
	}
	
	// logika za password treba biti u ovoj klasi ovo je ideja

	private String generisiLozinku() {
		Random random = new SecureRandom();
		char[] result = new char[15];
		char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		
		return new String(result);
	}
	

}
