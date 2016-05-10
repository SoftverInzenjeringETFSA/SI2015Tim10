package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="odjava")
public class Odjava implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ODJAVA_ID")
	@GeneratedValue
	long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private Korisnik korisnik;

	private Date datumOdjave;   // cuva i datum i vrijeme
	



	public Odjava() {
	}
	
	public Odjava(Korisnik korisnik) {
		this.korisnik = korisnik;
		this.datumOdjave = new Date();
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Date getDatumOdjave() {
		return datumOdjave;
	}

	public void setDatumOdjave(Date datumOdjave) {
		this.datumOdjave = datumOdjave;
	}
}
