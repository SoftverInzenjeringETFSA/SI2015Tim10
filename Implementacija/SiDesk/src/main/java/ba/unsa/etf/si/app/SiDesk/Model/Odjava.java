package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Date;

public class Odjava {
	
	// zzzzzzdumati treba li nam uopšte ova klasa
 
	private Korisnik korisnik;
	private Date datumOdjave;   // cuva i datum i vrijeme
	
	public Odjava() {
	}
	
	public Odjava(Korisnik korisnik) {
		this.korisnik = korisnik;
		this.datumOdjave = new Date();
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}

	public Date getDatumPrijave() {
		return datumOdjave;
	}
}
