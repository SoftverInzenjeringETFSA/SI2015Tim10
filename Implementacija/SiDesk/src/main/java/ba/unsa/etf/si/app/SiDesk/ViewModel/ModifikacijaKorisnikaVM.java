package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;

public class ModifikacijaKorisnikaVM {
	final static Logger logger = Logger.getLogger(ModifikacijaKorisnikaVM.class);

	public static boolean modifikacijaKorisnika(Session s, Korisnik k, JList lista, String ime, String prezime,
			String jmbg, String brojTelefona, String email, String username, String password, String adresa,
			String brojLicne, Date datumZaposljenja, String tipkorisnika, String imeOperatera) {

		Transaction t = s.beginTransaction();

		try {
			Criteria criteria4 = s.createCriteria(Korisnik.class)
					.add(Restrictions.like("jmbg", k.getJmbg()).ignoreCase())
					.add(Restrictions.like("ime", k.getIme()).ignoreCase())
					.add(Restrictions.like("korisnickoIme", k.getKorisnickoIme()).ignoreCase());
			List<Korisnik> listaa2 = criteria4.list();
			Korisnik n = listaa2.get(0);
			s.delete(n);
			Korisnik novi = new Korisnik();
			Criteria criteria1 = s.createCriteria(Korisnik.class).add(Restrictions.like("jmbg", jmbg).ignoreCase());
			
			Criteria criteria2 = s.createCriteria(Korisnik.class).add(Restrictions.like("ime", ime).ignoreCase());
		
			Criteria criteria3 = s.createCriteria(Korisnik.class).add(Restrictions.like("korisnickoIme", username).ignoreCase());
			
			List<Korisnik> lista1 = criteria1.list();
			List<Korisnik> lista2 = criteria2.list();
			List<Korisnik> lista3 = criteria3.list();
	

			if (lista1.isEmpty() && lista2.isEmpty() && lista3.isEmpty()) {

				TipKorisnika tip = (TipKorisnika) s.createCriteria(TipKorisnika.class)
						.add(Restrictions.eq("tipKorisnika", tipkorisnika)).uniqueResult();
			
				Operater o = (Operater) s.createCriteria(Operater.class).add(Restrictions.eq("ime", imeOperatera))
						.uniqueResult();

				novi.setIme(ime);
				novi.setPrezime(prezime);
				novi.setJmbg(jmbg);
				novi.setBrojTelefona(brojTelefona);
				novi.setEmail(email);
				novi.setKorisnickoIme(username);
				novi.setSifra(password);
				novi.setAdresa(adresa);
				novi.setBrojLicneKarte(brojLicne);
				novi.setDatumZaposlenja(datumZaposljenja);
				novi.setOperater_korisnik(o);
				novi.setTipkorisnika(tip);

				s.save(novi);
				t.commit();
				s.close();
				JOptionPane.showMessageDialog(null, "Uspjesno modifikovan korisnik", "Info ",
						JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				s.save(k);
				JOptionPane.showMessageDialog(null, "Postoji takav korisnik", "Info ", JOptionPane.INFORMATION_MESSAGE);

				return false;

			}
		}

		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			
		}
		return false;

	}
}
