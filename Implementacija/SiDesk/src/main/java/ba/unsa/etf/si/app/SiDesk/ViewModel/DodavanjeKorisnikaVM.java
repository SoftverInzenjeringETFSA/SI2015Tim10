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


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class DodavanjeKorisnikaVM {
	
	
			public static  void DodajKorisnika(Session s,String ime, String prezime, String jmbg, 
				String brojTelefona, String email, String username, String password, 
				String adresa,String brojLicne,Date datumZaposljenja, String tipkorisnika, String imeOperatera) {
	
			try{
				//naci tip korisnika preko imena
				TipKorisnika tip = new TipKorisnika();
				tip = (TipKorisnika) s.createCriteria(TipKorisnika.class).add(Restrictions.eq("tipKorisnika", tipkorisnika)).uniqueResult();
				Operater o=(Operater) s.createCriteria(Operater.class).add(Restrictions.eq("ime", imeOperatera)).uniqueResult();
				
				
				  
				
		        Transaction t = s.beginTransaction();
		        Korisnik k= new Korisnik (ime, prezime, brojTelefona, jmbg, brojLicne, adresa, email, datumZaposljenja,
		        		tip, username,o);
		        s.save(k);
		        t.commit();
				System.out.println("Uspjesno dodan korisnik");
				s.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			
		}
	
}
