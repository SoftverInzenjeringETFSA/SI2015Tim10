package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.ArrayList;

public class Kategorija {

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
