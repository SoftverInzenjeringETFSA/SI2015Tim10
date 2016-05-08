package ba.unsa.etf.si.app.SiDesk.Model;

public class Pitanje {
	
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
	
	
	
}
