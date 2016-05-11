package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class BrisanjeKategorijeVM {

	public static boolean obrisiKategoriju(String putanja, String ime) {
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase());
			List<Kategorija> lista = criteria.list();
			Kategorija k = lista.get(0);
			k.setParentId(null);
			session.delete(k);
			System.out.println("Uspjesno obrisano");
			t.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
