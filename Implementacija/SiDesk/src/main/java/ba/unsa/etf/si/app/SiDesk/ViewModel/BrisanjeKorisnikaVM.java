package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;

public class BrisanjeKorisnikaVM {

	public static void BrisiKorisnika(Session sesija, JList lista) {
		try {
			int selectedIndex = lista.getSelectedIndex();
			if (selectedIndex != -1) {
				Transaction t = sesija.beginTransaction();
				Korisnik k = new Korisnik();
				k = (Korisnik) lista.getSelectedValue();
				Korisnik k1 = PretragaKorisnikaJedinstvenaVM.pretraziKorisnikaJMBG(sesija, k.getJmbg());
				k1.setOperater_korisnik(null);
				k1.setTipkorisnika(null);
				sesija.delete(k1);
				DefaultListModel model = (DefaultListModel) lista.getModel();

				model.remove(selectedIndex);
				t.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
