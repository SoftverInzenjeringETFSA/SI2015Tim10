package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
