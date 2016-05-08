package ba.unsa.etf.si.app.SiDesk.Model;

public class IzvjestajStarosnaDob {
	
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

	public IzvjestajStarosnaDob() {
		
	}
	
	public IzvjestajStarosnaDob(Operater o) {
		this.operater=o;
		this.naziv="Izvještaj za starosnu dob klijenata";
	}
	
	public void generisiIzvjestaj() {
		
	}

}
