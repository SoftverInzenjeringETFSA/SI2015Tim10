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
	final static Logger logger = Logger.getLogger(PretragaPitanjaVM.class);


	
	public static List<Pitanje> nadjiPitanjaSaPutanjom(String putanja, Session session){
		List<Pitanje> listaPitanja = null;
		try{
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Pitanje.class).add(Restrictions.like("putanja", putanja, MatchMode.ANYWHERE).ignoreCase());
			listaPitanja = criteria.list();		 	
		} catch(Exception e){
			logger.error("Došlo je do greške:", e);
		
		}
		return listaPitanja;
	}

	public static Pitanje nadjiPitanje(String pitanje, String odgovor, Session session) {
		Pitanje p = null;
		try {
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Pitanje.class)
					.add(Restrictions.like("pitanje", pitanje).ignoreCase())
					.add(Restrictions.like("odgovor", odgovor).ignoreCase());
			p = (Pitanje) criteria.list().get(0);		
			
		} catch (Exception e){
			logger.error("Došlo je do greške:", e);
	
		}
		return p;
	}


}