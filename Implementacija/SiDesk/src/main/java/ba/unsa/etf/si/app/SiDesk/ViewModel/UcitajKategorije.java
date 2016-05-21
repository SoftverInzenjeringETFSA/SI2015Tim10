package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public class UcitajKategorije {
	final static Logger logger = Logger.getLogger(UcitajKategorije.class);
	

	public static List<Kategorija> ucitajKategorije(Session session) {
		
		Transaction t = session.beginTransaction();
		
		Criteria criteria_kategorija = session.createCriteria(Kategorija.class);
		List<Kategorija> kategorije = criteria_kategorija.list();
		
		return kategorije;
		
		

	}

}
