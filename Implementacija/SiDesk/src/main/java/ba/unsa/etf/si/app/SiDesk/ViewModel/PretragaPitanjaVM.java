package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public class PretragaPitanjaVM {
	public static List<Pitanje> nadjiPitanjaSaPutanjom(String putanja){
		List<Pitanje> listaPitanja = null;
		try{
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Pitanje.class).add(Restrictions.like("putanja", putanja, MatchMode.ANYWHERE).ignoreCase());
			listaPitanja = criteria.list();		
			
			session.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return listaPitanja;
	}

	public static Pitanje nadjiPitanje(String pitanje, String odgovor) {
		Pitanje p = null;
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Pitanje.class)
					.add(Restrictions.like("pitanje", pitanje).ignoreCase())
					.add(Restrictions.like("odgovor", odgovor).ignoreCase());
			p = (Pitanje) criteria.list().get(0);		
			
			session.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return p;
	}


}