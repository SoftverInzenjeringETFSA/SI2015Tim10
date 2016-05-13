package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class TrazenjeKategorijeVM {
	
	public static Kategorija  nadjiKategoriju(String putanja, String ime) {
		Criteria criteria = null;
		List<Kategorija> lista=null;
	
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
	        if(putanja != null)
		    criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase()).add(Restrictions.like("putanja", putanja).ignoreCase());
	        else if(ime != null)criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase());
	        else return null;
	        lista = criteria.list();

			t.commit();	
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista.get(0);
	}
	
	public static List<Kategorija> nadjiKategorije() {
		Criteria criteria = null;
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			criteria = session.createCriteria(Kategorija.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Kategorija>)criteria.list();
	}



	
	
}
