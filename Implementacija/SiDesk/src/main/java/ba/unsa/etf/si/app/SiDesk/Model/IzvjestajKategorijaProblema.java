package ba.unsa.etf.si.app.SiDesk.Model;

public class IzvjestajKategorijaProblema {
	private String naziv;
	private Operater operater;
	/* Kategorija kategorija;
	*/ //ne znam jos sta za izvjestaje
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Operater getOperater() {
		return operater;
	}

	public void setOperater(Operater operater) {
		this.operater = operater;
	}

	public IzvjestajKategorijaProblema() {
		
	}
	
	public IzvjestajKategorijaProblema(Operater o) {
		this.operater=o;
		this.naziv="Izvještaj za kategorije problema";
	}
	
	public void generisiIzvjestaj() {
		
	}
}
