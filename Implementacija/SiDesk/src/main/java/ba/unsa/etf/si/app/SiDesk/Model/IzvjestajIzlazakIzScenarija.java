package ba.unsa.etf.si.app.SiDesk.Model;

public class IzvjestajIzlazakIzScenarija {
	private String naziv;
	private Operater operater;
	/* private int starost;
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

	public IzvjestajIzlazakIzScenarija() {
		
	}
	
	public IzvjestajIzlazakIzScenarija(Operater o) {
		this.operater=o;
		this.naziv="Izvještaj za izlaske iz predefinisanog scenarija";
	}
	
	public void generisiIzvjestaj() {
		
	}
}
