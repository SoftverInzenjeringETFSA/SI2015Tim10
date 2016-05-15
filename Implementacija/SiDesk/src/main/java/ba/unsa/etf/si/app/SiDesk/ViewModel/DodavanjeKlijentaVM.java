
package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class DodavanjeKlijentaVM {

	public static Klijent dodajKlijenta(String ime, String prezime, String Adresa, String brojTelefona, int starost,
			String zaposlenje) {
		Klijent k = null;
		try {

			Session s1 = (Session) HibernateUtil.getSessionFactory().openSession();
			Transaction tt = s1.beginTransaction();
			k = new Klijent(ime, prezime, Adresa, brojTelefona, starost, zaposlenje);
			s1.save(k);
			tt.commit();
		}

		catch (Exception e) {
		}
		return k;
	}
}
