package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class ModifikacijaKlijentaVM {
	public static List<Klijent> nadjiKlijenta(String ime){
		List<Klijent> listaKlijenta = null;
		try{
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Klijent.class).add(Restrictions.like("ime", ime, MatchMode.ANYWHERE).ignoreCase());
			listaKlijenta = criteria.list();		
			
			session.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return listaKlijenta;
	}
	
	public static List<Klijent> nadjiKlijenta1(String prezime){
		List<Klijent> listaKlijenta = null;
		try{
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Klijent.class).add(Restrictions.like("prezime", prezime, MatchMode.ANYWHERE).ignoreCase());
			listaKlijenta = criteria.list();		
			
			session.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return listaKlijenta;
	}
}
