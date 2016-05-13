package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DodavanjePitanjaVM {
	
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
			
			JOptionPane.showMessageDialog(null, "Pitanje je uspješno dodana.","Info", JOptionPane.INFORMATION_MESSAGE);	

		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public static List<Pitanje> pretraziPitanja(String kljucnaRijec) {
		
		List<Pitanje> lista= null;
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr =  session.beginTransaction();
			
	        Criteria criteria = session.createCriteria(Pitanje.class).add(Restrictions.like("pitanje", kljucnaRijec, MatchMode.ANYWHERE).ignoreCase());
		    lista = criteria.list();
			
			}
		
		
		catch (Exception e) {
			e.printStackTrace();
		
		}
		return (List<Pitanje>)lista;
		
	}
	
	

}
