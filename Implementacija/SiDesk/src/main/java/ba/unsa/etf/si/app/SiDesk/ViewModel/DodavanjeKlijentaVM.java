
package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
public class DodavanjeKlijentaVM {
	final static Logger logger = Logger.getLogger(DodavanjeKlijentaVM.class);
    
	private static Session s1;
    
	public DodavanjeKlijentaVM(Session s) {
		this.s1 = s;
	}
	public static Klijent dodajKlijenta(String ime, String prezime, String Adresa, String brojTelefona, int starost,
			String zaposlenje) {
		Klijent k = null;
		try {

			Transaction tt = s1.beginTransaction();
			k = new Klijent(ime, prezime, Adresa, brojTelefona, starost, zaposlenje);
			s1.save(k);
			tt.commit();
		}

		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
		}
		return k;
	}
}
