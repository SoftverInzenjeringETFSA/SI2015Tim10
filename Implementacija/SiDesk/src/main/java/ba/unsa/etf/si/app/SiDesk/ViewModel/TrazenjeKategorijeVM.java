package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class TrazenjeKategorijeVM {
	public static List<Kategorija> nadjiKategorije() {
		Criteria criteria = null;
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			criteria = session.createCriteria(Kategorija.class);
			return (List<Kategorija>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Kategorija>)criteria.list();
	}
	
}
