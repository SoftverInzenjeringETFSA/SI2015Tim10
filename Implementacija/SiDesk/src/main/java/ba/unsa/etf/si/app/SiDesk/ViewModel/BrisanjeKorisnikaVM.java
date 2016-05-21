package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
public class BrisanjeKorisnikaVM {
	final static Logger logger = Logger.getLogger(BrisanjeKorisnikaVM.class);
	
	
	public static void BrisiKorisnika(Session sesija, JList lista) {
		try {
			int selectedIndex = lista.getSelectedIndex();
			if (selectedIndex != -1) {
				Transaction t = sesija.beginTransaction();
				Korisnik k = new Korisnik();
				k = (Korisnik) lista.getSelectedValue();
				k= (Korisnik)sesija.createCriteria(Korisnik.class).add(Restrictions.eq("jmbg", k.getJmbg())).uniqueResult();
				//Korisnik k1 = PretragaKorisnikaJedinstvenaVM.pretraziKorisnikaJMBG(sesija, k.getJmbg());
				//k1.setOperater_korisnik(null);
			//k1.setTipkorisnika(null);
				//k=k1;
				sesija.delete(k);
				DefaultListModel model = (DefaultListModel) lista.getModel();

				model.remove(selectedIndex);
				t.commit();
			}

		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			

		}

	}
}
