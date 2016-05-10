package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipkorisnika")
public class TipKorisnika implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4962677174902478990L;
	@Id
	@GeneratedValue
	long id;
	
	@OneToMany(mappedBy = "tipkorisnika")
	private Set<Korisnik> korisnici;
	
	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}
	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
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
	
	public TipKorisnika() {	}
	
	private void postaviTipKorisnika(String tip) {
		if(tip.equals("m")) this.tipKorisnika="menadzer";
		if(tip.equals("a")) this.tipKorisnika="administrator";
		if(tip.equals("u")) this.tipKorisnika="uposlenik";
	}
}
