package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="tipKorisnika")
public class TipKorisnika implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4962677174902478990L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public void setTipKorisnika(String tipkorisnika) {
		postaviTipKorisnika(tipkorisnika);
	}
	public TipKorisnika(String tipkorisnika) {
		postaviTipKorisnika(tipkorisnika);
	}
	
	public TipKorisnika() {	}
	
	private void postaviTipKorisnika(String tip) {
		
		if(tip.equals("Menadzer"))
{
			
			this.tipKorisnika="Menadzer";
			
}
		if(tip.equals("Administrator")){
			this.tipKorisnika="Administrator";
		}
		if(tip.equals("Obicni korisnik"))
			{
			
			this.tipKorisnika="Obicni korisnik";
		
			}
	}
}
