package ba.unsa.etf.si.app.SiDesk.Model;

public class TipKorisnika {

	private String tipKorisnika;
	

	public String getTipKorisnika() {
		return tipKorisnika;
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
