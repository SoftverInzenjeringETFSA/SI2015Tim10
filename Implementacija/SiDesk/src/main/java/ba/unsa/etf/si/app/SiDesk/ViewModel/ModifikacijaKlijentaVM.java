package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public class ModifikacijaKlijentaVM {
	final static Logger logger = Logger.getLogger(ModifikacijaKlijentaVM.class);


	public static List<Klijent> nadjiKlijenta(String ime, Session session){
		List<Klijent> listaKlijenta = null;
		try{
			
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Klijent.class).add(Restrictions.like("ime", ime, MatchMode.ANYWHERE).ignoreCase());
			listaKlijenta = criteria.list();		
			
			
		} catch(Exception e){
			logger.error("Došlo je do greške:", e);
			
		}
		return listaKlijenta;
	}
	
	public static List<Klijent> nadjiKlijenta1(String prezime, Session session){
		List<Klijent> listaKlijenta = null;
		try{
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Klijent.class).add(Restrictions.like("prezime", prezime, MatchMode.ANYWHERE).ignoreCase());
			listaKlijenta = criteria.list();		
			
			
		} catch(Exception e){
			logger.error("Došlo je do greške:", e);
		
		}
		return listaKlijenta;
	}
}
