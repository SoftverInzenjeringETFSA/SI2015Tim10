package ba.unsa.etf.si.app.SiDesk.Model;

import javax.persistence.Entity;

@Entity
public class TipKorisnika implements java.io.Serializable{

	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	private String tipKorisnika;
	

	public String getTipKorisnika() {
		return tipKorisnika;
	}
	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	public TipKorisnika(String tipKorisnika) {
		postaviTipKorisnika(tipKorisnika);
	}
	
	private void postaviTipKorisnika(String tip) {
		if(tip.equals("m")) this.tipKorisnika="menadzer";
		if(tip.equals("a")) this.tipKorisnika="administrator";
		if(tip.equals("u")) this.tipKorisnika="uposlenik";
	}
}
