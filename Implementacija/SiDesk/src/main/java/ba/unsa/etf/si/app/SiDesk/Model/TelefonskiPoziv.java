package ba.unsa.etf.si.app.SiDesk.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefonskipoziv")
public class TelefonskiPoziv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="klijent_id")
	private Klijent klijent;
	
	@ManyToMany(mappedBy="telefonski_pozivi")
	private Set<Pitanje> pitanja = new HashSet<Pitanje>();
	public Set<Pitanje> getPitanja() {
		return pitanja;
	}

	public void setPitanja(Set<Pitanje> pitanja) {
		this.pitanja = pitanja;
	}

	
	@ManyToOne
	@JoinColumn(name="operater_id")
	private Operater operater;
	public Operater getOperater() {
		return operater;
	}

	public void setOperater(Operater operater) {
		this.operater = operater;
	}
	
	private Date poziv;
	private double trajanjePoziva;
	private String opisniTekst;
	
	public TelefonskiPoziv(Klijent klijent, Pitanje pitanje, Operater operater, Date poziv) {
		poziv = new Date(); 
		this.klijent = klijent;
		this.pitanja.add(pitanje);
		this.operater = operater;
		this.poziv = poziv;
	}

	public TelefonskiPoziv() {
		poziv = new Date(); 
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
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
