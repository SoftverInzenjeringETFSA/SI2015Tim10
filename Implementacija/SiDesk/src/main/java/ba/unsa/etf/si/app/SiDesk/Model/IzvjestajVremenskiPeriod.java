package ba.unsa.etf.si.app.SiDesk.Model;

// import java.util.Date;

public class IzvjestajVremenskiPeriod implements Izvjestaj{

	private String naziv;
	private Operater operater;
	/*private Date pocetniDatum;
	private Date krajnjiDatum;
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

	public IzvjestajVremenskiPeriod() {
		
	}
	
	public IzvjestajVremenskiPeriod(Operater o) {
		this.operater=o;
		this.naziv="Izvjestaj za odredjeni vremenski period";
	}
	
	public void generisiIzvjestaj() {
		
	}
}
