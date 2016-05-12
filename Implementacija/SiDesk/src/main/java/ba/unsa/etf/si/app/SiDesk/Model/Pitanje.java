package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pitanje")
public class Pitanje implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="kategorija_id")
	private Kategorija kategorija_pitanja;

	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "pitanje_poziv", joinColumns = { @JoinColumn(name = "pitanje_id") }, inverseJoinColumns = { @JoinColumn(name = "poziv_id") })
	private Set<TelefonskiPoziv> telefonski_pozivi= new HashSet<TelefonskiPoziv>();
	
	private String pitanje;
	private String odgovor;
	private String putanja;
	
	public Pitanje() {
		
	}
	
	public Pitanje(String pitanje, String odgovor) {
		this.pitanje = pitanje;
		this.odgovor = odgovor;

		// putanja se valjda mora postavljati na osnovu bazeeeeeeee.
	}
	
	
	/* getteri i setteri -  nisam stavila setter za putanju 
	jer mislim da se to moze postaviti samo na osnovu podataka iz baze - provjeriti */
	
	public Pitanje(String pitanje) {
		this.pitanje = pitanje;
		this.odgovor = "";
	}
	
	public Kategorija getKategorija_pitanja() {
		return kategorija_pitanja;
	}

	public void setKategorija_pitanja(Kategorija kategorija_pitanja) {
		this.kategorija_pitanja = kategorija_pitanja;
	}

	public Set<TelefonskiPoziv> getTelefonski_pozivi() {
		return telefonski_pozivi;
	}

	public void setTelefonski_pozivi(Set<TelefonskiPoziv> telefonski_pozivi) {
		this.telefonski_pozivi = telefonski_pozivi;
	}

	public String getPitanje() {
		return pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	public String getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public String getPutanja() {
		return putanja;
	}

	public void setPutanja(String putanja) {
		this.putanja = putanja;
	}
	
	
	
}
