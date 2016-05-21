package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class PretragaKorisnikaNejedinstvenaVM {
	final static Logger logger = Logger.getLogger(PretragaKorisnikaNejedinstvenaVM.class);

	public static List<Korisnik> pretraziKorisnikaPoImenu(Session sesija, String ime) {

		Transaction t = sesija.beginTransaction();

		Criteria criteria = sesija.createCriteria(Korisnik.class).add(Restrictions.like("ime", ime).ignoreCase());

		List<Korisnik> lista = criteria.list();
		t.commit();
		if (lista.isEmpty())
			return Collections.emptyList();
		return lista;

	}

	public static List<Korisnik> pretraziKorisnikaPoPrezimenu(Session sesija, String prezime) {

		Transaction t = sesija.beginTransaction();

		Criteria criteria = sesija.createCriteria(Korisnik.class)
				.add(Restrictions.like("prezime", prezime).ignoreCase());
		List<Korisnik> lista = criteria.list();
		// t.commit();
		if (lista.isEmpty())
			return Collections.emptyList();
		return lista;

	}

	public static List<Korisnik> pretraziKorisnikaPoTipu(Session sesija, String tip) {

		Transaction t = sesija.beginTransaction();

		TipKorisnika tipk = (TipKorisnika) sesija.createCriteria(TipKorisnika.class)
				.add(Restrictions.eq("tipKorisnika", tip)).uniqueResult();

		Criteria criteria1 = sesija.createCriteria(Korisnik.class).add(Restrictions.eq("tipkorisnika", tipk));
		List<Korisnik> lista = criteria1.list();

		// t.commit();
		if (lista.isEmpty())
			return Collections.emptyList();
		return lista;

	}
	
	public static Korisnik nadjiKorisnikaUsername(Session s, String username, String password){
		Korisnik k = null;
		try{
			Transaction t = s.beginTransaction();
			Criteria criteria = s.createCriteria(Korisnik.class)
					.add(Restrictions.like("korisnickoIme", username).ignoreCase())
					.add(Restrictions.like("sifra", password).ignoreCase());
			List<Korisnik> lista = criteria.list();
			if(lista.size() == 0) return null;
			k = lista.get(0);
		
			
		} catch (Exception e){
			logger.error("Došlo je do greške:", e);
		
		}
		return k;
	}

}
