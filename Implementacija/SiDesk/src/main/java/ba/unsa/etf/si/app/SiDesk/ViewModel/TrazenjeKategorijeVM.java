package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public class TrazenjeKategorijeVM {
	final static Logger logger = Logger.getLogger(TrazenjeKategorijeVM.class);


	
	public static Kategorija  nadjiKategoriju(String putanja, String ime, Session session) {
		Criteria criteria = null;
		List<Kategorija> lista=null;
	
		try {
	        Transaction t = session.beginTransaction();
	        if(putanja != null)
		    criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase()).add(Restrictions.like("putanja", putanja).ignoreCase());
	        else if(ime != null)criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase());
	        else return null;
	        lista = criteria.list();
	        if(lista.size() == 0) return null;
			t.commit();	
		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
	
		}
		
		return lista.get(0);
	}
	
	public static List<Kategorija> nadjiKategorije(Session session) {
		Criteria criteria = null;
		try {
	        Transaction t = session.beginTransaction();
			criteria = session.createCriteria(Kategorija.class);
			
		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
	
		}
		return (List<Kategorija>)criteria.list();
	}
	
	//putanja = putanja + ime kategorije
	public static List<Kategorija> nadjiKategorijeSaPutanjom(String putanja, Session session){
		List<Kategorija> listaKategorija = null;
		try{
	        Transaction t = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("putanja", putanja, MatchMode.ANYWHERE).ignoreCase());
			listaKategorija = criteria.list();		
			
		} catch(Exception e){
			logger.error("Došlo je do greške:", e);
		
		}
		return listaKategorija;
	}
	
}
