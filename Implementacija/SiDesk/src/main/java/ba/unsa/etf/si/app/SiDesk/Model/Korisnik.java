package ba.unsa.etf.si.app.SiDesk.Model;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;

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
@Table(name="korisnik")
public class Korisnik implements java.io.Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -9013585257542864310L;

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
	@JoinColumn(name="tipkorisnika_id")
	private TipKorisnika tipkorisnika;
	
	@ManyToOne
	@JoinColumn(name="operater_id")
	private Operater operater_korisnik;
	
	@OneToMany(mappedBy="korisnik")
	private Set<Odjava> odjave;
	
	@OneToMany(mappedBy="korisnik")
	private Set<Odjava> prijave;
	
	private String ime;
	private String prezime;
	private String brojTelefona;
	private String jmbg;
	private String brojLicneKarte;
	private String adresa;
	private String email;
	private Date datumZaposlenja;
	private String korisnickoIme;
	private String sifra;

	public Korisnik() {
		
	}
	
	public Korisnik(String  ime, String prezime, String brojTelefona, 
			        String jmbg, String brojLicneKarte, String adresa,
			        String email, Date datumZaposlenja, TipKorisnika tk,
			        String korisnickoIme, Operater o, String pw) {
		
		
		this.ime=ime;
		this.prezime=prezime;
		this.brojTelefona=brojTelefona;
		this.jmbg=jmbg;
		this.brojLicneKarte=brojLicneKarte;
		this.adresa=adresa;
		this.email=email;
		this.datumZaposlenja=datumZaposlenja;
		this.setTipkorisnika(tk);        
		this.korisnickoIme=korisnickoIme;
		this.sifra=pw;// jedinstven ili ne, baza
		this.operater_korisnik=o;
		
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatumZaposlenja() {
		return datumZaposlenja;
	}

	public void setDatumZaposlenja(Date datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}


	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	//nisam sigurna
	public String getSifra() {
		return sifra;
	}
	
	// logika za password treba biti u ovoj klasi ovo je ideja

	public Operater getOperater_korisnik() {
		return operater_korisnik;
	}

	public void setOperater_korisnik(Operater operater_korisnik) {
		this.operater_korisnik = operater_korisnik;
	}

	public Set<Odjava> getOdjave() {
		return odjave;
	}

	public void setOdjave(Set<Odjava> odjave) {
		this.odjave = odjave;
	}

	public Set<Odjava> getPrijave() {
		return prijave;
	}

	public void setPrijave(Set<Odjava> prijave) {
		this.prijave = prijave;
	}

	public String toString() {
		return this.getIme()+" "+this.getPrezime();
	}

	public TipKorisnika getTipkorisnika() {
		return tipkorisnika;
	}

	public void setTipkorisnika(TipKorisnika tipkorisnika) {
		this.tipkorisnika = tipkorisnika;
	}
	

}
