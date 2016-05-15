package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger;
public class DodavanjePitanjaVM {
	final static Logger logger = Logger.getLogger(DodavanjePitanjaVM.class);

	public static Boolean dodajPitanje(Pitanje pitanje) {
		
		try {
			Session sesija =  HibernateUtil.getSessionFactory().openSession();
	        Transaction tr =  sesija.beginTransaction();

	        Pitanje p= new Pitanje();
	        p.setPitanje(pitanje.getPitanje());
	        p.setOdgovor(pitanje.getOdgovor());
	        p.setPutanja(pitanje.getPutanja());
	        p.setKategorija_pitanja(pitanje.getKategorija_pitanja());
	        
	        sesija.save(p);
			tr.commit();
			
			JOptionPane.showMessageDialog(null, "Pitanje je uspješno dodano.","Info", JOptionPane.INFORMATION_MESSAGE);	

		}
		
		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public static List<Pitanje> pretraziPitanja(String kljucnaRijec, String putanja) {
		
		List<Pitanje> lista= null;
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr =  session.beginTransaction();
			
	        Criteria criteria = session.createCriteria(Pitanje.class).add(Restrictions.like("pitanje", kljucnaRijec, MatchMode.ANYWHERE).ignoreCase()).add(Restrictions.like("putanja", putanja, MatchMode.ANYWHERE).ignoreCase());
		    lista = criteria.list();
			
			}
		
		
		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			e.printStackTrace();
		
		}
		return (List<Pitanje>)lista;
		
	}
	
	

}
