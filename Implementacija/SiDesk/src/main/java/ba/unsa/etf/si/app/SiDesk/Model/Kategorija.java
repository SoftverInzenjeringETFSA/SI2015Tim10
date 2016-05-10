package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kategorija")
public class Kategorija implements Serializable{

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
	
	@OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="parentKategorija")
	
	Kategorija parentKategorija;

	private String ime;
	private String putanja;

	@OneToMany(mappedBy="kategorija_pitanja")
	ArrayList<Pitanje> pitanja;
	
	public Kategorija() {
		
	}
	
	public Kategorija(String ime) {
		this.ime=ime;
		// putanja na osnovu baze?
	}
	
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPutanja() {
		return putanja;
	}

	public void setPutanja(String putanja) {
		this.putanja = putanja;
	}

	public ArrayList<Pitanje> getPitanja() {
		return pitanja;
		
		// ovdje neka logika dobavljanja pitanja iz baze za kategoriju
	}

	public void setPitanja(ArrayList<Pitanje> pitanja) {
		this.pitanja = pitanja;
	}
	
	public Kategorija getParentId() {
		return parentKategorija;
	}

	public void setParentId(Kategorija parentId) {
		this.parentKategorija = parentId;
	}


}
