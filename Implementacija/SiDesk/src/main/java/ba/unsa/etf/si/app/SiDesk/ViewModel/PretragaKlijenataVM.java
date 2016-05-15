package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class PretragaKlijenataVM {
	
	public static Klijent nadjiKlijenta(String ime, String prezime, String adresaIzTabele, String brojTelefonaIzTabele,int xd, String zaposlenjeIzTabele) {
		Criteria criteria = null;
		List<Klijent> lista = null;
		Klijent klijent1 = null;
	
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        
	        
		    criteria = session.createCriteria(Klijent.class)
		    		.add(Restrictions.like("ime", ime).ignoreCase())
		    		.add(Restrictions.like("prezime", prezime).ignoreCase())
		    		.add(Restrictions.like("adresa", adresaIzTabele).ignoreCase())
		    		.add(Restrictions.like("brojTelefona", brojTelefonaIzTabele))
		    		.add(Restrictions.like("starost", xd))
		    		.add(Restrictions.like("zaposlenje", zaposlenjeIzTabele).ignoreCase());
	        
	        lista = criteria.list();

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		klijent1 =lista.get(1);
		return klijent1;
	}
	
}
