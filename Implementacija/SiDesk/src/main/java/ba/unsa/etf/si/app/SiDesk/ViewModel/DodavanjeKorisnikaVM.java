package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger;

public class DodavanjeKorisnikaVM {
	final static Logger logger = Logger.getLogger(DodavanjeKorisnikaVM.class);

	
			public static  boolean DodajKorisnika(Session s,String ime, String prezime, String jmbg, 
				String brojTelefona, String email, String username, String password, 
				String adresa,String brojLicne,Date datumZaposljenja, String tipkorisnika, String imeOperatera, String pw) {
	
			try{
				TipKorisnika tip = new TipKorisnika();
				tip = (TipKorisnika) s.createCriteria(TipKorisnika.class).add(Restrictions.eq("tipKorisnika", tipkorisnika)).uniqueResult();
				Operater o=(Operater) s.createCriteria(Operater.class).add(Restrictions.eq("ime", imeOperatera)).uniqueResult();
				
				
				if(s.createCriteria(Korisnik.class).add(Restrictions.eq("korisnickoIme", username)).uniqueResult()==null && s.createCriteria(Korisnik.class).add(Restrictions.eq("jmbg", jmbg)).uniqueResult()==null && s.createCriteria(Korisnik.class).add(Restrictions.eq("ime", ime)).uniqueResult()==null && s.createCriteria(Korisnik.class).add(Restrictions.eq("brojLicneKarte", brojLicne)).uniqueResult()==null )
				{
				  
				
		        Transaction t = s.beginTransaction();
		        Korisnik k= new Korisnik (ime, prezime, brojTelefona, jmbg, brojLicne, adresa, email, datumZaposljenja,
		        		tip, username,o, pw);
		        s.save(k);
		        t.commit();
				
				JOptionPane.showMessageDialog(null, "Korisnik je uspješno dodan", "Info",
						JOptionPane.INFORMATION_MESSAGE);
				return true;

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Postoji takav korisnik", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				return false;
				}
				
			} catch (Exception e) {
				logger.error("Došlo je do greške:", e);
				
			
			}
			return true;
			
		}
	
}
