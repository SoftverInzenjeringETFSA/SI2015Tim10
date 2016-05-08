package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Date;

public class Prijava {

// zzzzzzzzzdumati treba li nam uopste ova klasa
	private Korisnik korisnik;
	private Date datumPrijave;   // cuva i datum i vrijeme
	
	public Prijava() {
	}
	
	public Prijava(Korisnik korisnik) {
		this.korisnik = korisnik;
		this.datumPrijave = new Date();
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}

	public Date getDatumPrijave() {
		return datumPrijave;
	}
}
