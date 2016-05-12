package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="operater")
public class Operater implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="operater")
	private Set<TelefonskiPoziv> telefonskiPozivi;
	public Set<TelefonskiPoziv> getTelefonskiPozivi() {
		return telefonskiPozivi;
	}

	public void setTelefonskiPozivi(Set<TelefonskiPoziv> telefonskiPozivi) {
		this.telefonskiPozivi = telefonskiPozivi;
	}
	
	@OneToMany(mappedBy="operater_korisnik")
	private Set<Korisnik> korisnici;
	

	private String ime;
	private String adresa;

	
	public Operater() {
		
	}
	
	public Operater(String ime, String adresa) {
		this.ime = ime;
		this.adresa = adresa;
	}
	
	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
		
	// ova metoda nam ne treba, jer mozemo rijesiti u jednom ifu ovo .get nesto
	
	/*public boolean validirajJedinstvenostJMBG(String jmbg) {
		
		for (Korisnik k : korisnici) {
			if(k.getJmbg().equals(jmbg)) return false;
		}
		
		return true;
		
	}*/
	
	// ova metoda nam ne treba, jer mozemo rijesiti u jednom ifu ovo .get nesto

	
	/*public boolean validirajJedinstvenostKorisnickoIme(String korisnickoIme) {
		
		for (Korisnik k : korisnici) {
			if(k.getKorisnickoIme().equals(korisnickoIme)) return false;
		}
		
		return true;
		
	}*/
	
	/* ovo nece biti potrebno ja mislim jer se ovo radi kroz modifikaciju korisnika
	 * 
	 * public boolean izmjenaPrivilegijaKorisnika(Korisnik korisnik, TipKorisnika noviTipKorisnika) {
		
	     for (Korisnik k : korisnici) {
		if(k.getJmbg().equals(korisnik.getJmbg()))
					{
						k.setTipKorisnika(noviTipKorisnika);
						return true;
					}
		}
	     
	     return false;
	}*/
	
	


	// ne znam trebaju li nam uopste ove klase, i metode 
	
	
	/*public Boolean dodajPrijavu(Prijava prijava) {
		prijave.add(prijava);
		return true;
	}
	
	public Boolean dodajOdjavu(Odjava odjava) {
		odjave.add(odjava);
		return true;
	}*/
	
	// a ni ove :)
	/*
	public void ucitajKorisnike() {
		// ovdje se valjda citaju iz baze
		korisnici = new ArrayList<Korisnik>();
	}
	
	public void ucitajKlijente() {
		// ovdje se valjda citaju iz baze
		klijenti = new ArrayList<Klijent>();
	}
	
	public void ucitajPrijave() {
		// ovdje se valjda citaju iz baze
		prijave = new ArrayList<Prijava>();
	}
	
	public void ucitajOdjave() {
		// ovdje se valjda citaju iz baze
		odjave = new ArrayList<Odjava>();
	} */

	


}
