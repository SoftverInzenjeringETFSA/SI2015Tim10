package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
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
	
	@OneToOne
	@JoinColumn(name="parent_id")
	private Kategorija kategorija;
	
	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	@OneToOne(mappedBy="kategorija")
	
	
	

	private String ime;
	private String putanja;
	// nisam sigurna trebam li praviti instancu Kategorija
	
	private int parentId;
	
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
	
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


}
