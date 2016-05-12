package ba.unsa.etf.si.app.SiDesk.Model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Klijent implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@OneToMany(mappedBy="klijent")
	private Set<TelefonskiPoziv> pozivi;
	
	
	
	
	
	public Set<TelefonskiPoziv> getPozivi() {
		return pozivi;
	}

	public void setPozivi(Set<TelefonskiPoziv> pozivi) {
		this.pozivi = pozivi;
	}

	private String ime;
	private String prezime;
	private String brojTelefona;
	private int starost;
	private String zaposlenje;

	
	public Klijent() {
		
	}
	
	public Klijent(String ime, String prezime, String brojTelefona, int starost, String zaposlenje) {
		this.ime=ime;
		this.prezime=prezime;
		this.brojTelefona=brojTelefona;
		this.starost=starost;
		this.zaposlenje=zaposlenje;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public String getZaposlenje() {
		return zaposlenje;
	}

	public void setZaposlenje(String zaposlenje) {
		this.zaposlenje = zaposlenje;
	}
	
	

	
	
}
