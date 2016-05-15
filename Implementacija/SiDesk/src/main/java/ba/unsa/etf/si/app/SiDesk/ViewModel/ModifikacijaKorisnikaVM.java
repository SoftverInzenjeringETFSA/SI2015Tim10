package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.sql.Connection;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

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

	public static void modifikacijaKorisnika(Session s, JList lista, String ime, String prezime, String jmbg, String brojTelefona,
			String email, String username, String password, String adresa, String brojLicne, Date datumZaposljenja,
			String tipkorisnika, String imeOperatera) {
		try {
			Korisnik neko = new Korisnik();
			neko = (Korisnik) lista.getSelectedValue();

				Korisnik novi = new Korisnik();
				Transaction t = s.beginTransaction();

				
			novi = (Korisnik) s.createCriteria(Korisnik.class).add(Restrictions.eq("jmbg", neko.getJmbg())).uniqueResult();
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
			neko=novi;

			s.update(neko);
			t.commit();
			System.out.println();
			s.close();
			int selectedIndex = lista.getSelectedIndex();
			DefaultListModel model = (DefaultListModel) lista.getModel();

			model.remove(selectedIndex);
			model.addElement(neko);

			JOptionPane.showMessageDialog(null, "Uspjesno modifikovan korisnik", "Info ",
					JOptionPane.INFORMATION_MESSAGE);


		
			
			
		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			e.printStackTrace();

		}

	}
}
