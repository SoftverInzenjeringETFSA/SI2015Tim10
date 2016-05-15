package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;

public class PretragaKorisnikaJedinstvenaVM {

	public static Korisnik pretraziKorisnikaJMBG(Session s, String jmbg) {

		Transaction t = s.beginTransaction();
		Criteria criteria = s.createCriteria(Korisnik.class).add(Restrictions.like("jmbg", jmbg).ignoreCase());

		List<Korisnik> lista = criteria.list();
			

		Korisnik k = lista.get(0);
		t.commit();
		return k;

		// TODO Auto-generated method stub

	}
	public static boolean provjeriDaLiPostoji(Session s, String jmbg) {

		Transaction t = s.beginTransaction();
		Criteria criteria = s.createCriteria(Korisnik.class).add(Restrictions.like("jmbg", jmbg).ignoreCase());

		List<Korisnik> lista = criteria.list();
		if(lista.isEmpty())return false;
		return true;


		// TODO Auto-generated method stub

	}
	public static boolean pretraziKorisnikaPoImenu(Session s, String ime) {

		Transaction t = s.beginTransaction();
		Criteria criteria = s.createCriteria(Korisnik.class).add(Restrictions.like("ime", ime).ignoreCase());

		List<Korisnik> lista = criteria.list();
if(lista.isEmpty())return false;
return true;

		// TODO Auto-generated method stub

	}
	

}
