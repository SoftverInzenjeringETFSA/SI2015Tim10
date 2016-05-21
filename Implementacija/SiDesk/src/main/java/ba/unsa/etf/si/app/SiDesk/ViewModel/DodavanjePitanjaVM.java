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
	

	

	public static Boolean dodajPitanje(Pitanje pitanje, Session sesija) {
		
		try {
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
			
			return false;
		}
		return true;
	}
	

	public static List<Pitanje> pretraziPitanja(String kljucnaRijec, String putanja, Session session) {
		
		List<Pitanje> lista= null;
		try {
	        Transaction tr =  session.beginTransaction();
			
	        Criteria criteria = session.createCriteria(Pitanje.class).add(Restrictions.like("pitanje", kljucnaRijec, MatchMode.ANYWHERE).ignoreCase()).add(Restrictions.like("putanja", putanja, MatchMode.ANYWHERE).ignoreCase());
		    lista = criteria.list();
			
			}
		
		
		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			
		
		}
		return (List<Pitanje>)lista;
		
	}
	
	

}
