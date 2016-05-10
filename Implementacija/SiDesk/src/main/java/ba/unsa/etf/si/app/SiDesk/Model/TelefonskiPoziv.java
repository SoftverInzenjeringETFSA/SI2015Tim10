package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefonskipoziv")
public class TelefonskiPoziv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	long id;
	
	private Date poziv;
	private double trajanjePoziva;
	private String opisniTekst;
	
	public TelefonskiPoziv() {
		poziv = new Date(); 
	}

	// getteri i setteri
	public Date getPoziv() {
		return poziv;
	}
	public void setPoziv(Date poziv) {
		this.poziv = poziv;
	}
	public double getTrajanjePoziva() {
		return trajanjePoziva;
	}
	public void setTrajanjePoziva(double trajanjePoziva) {
		this.trajanjePoziva = trajanjePoziva;
	}
	public String getOpisniTekst() {
		return opisniTekst;
	}
	public void setOpisniTekst(String opisniTekst) {
		this.opisniTekst = opisniTekst;
	}
	
	
	
}
