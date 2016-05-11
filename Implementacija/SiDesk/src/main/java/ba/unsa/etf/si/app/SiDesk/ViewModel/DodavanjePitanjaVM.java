package ba.unsa.etf.si.app.SiDesk.ViewModel;

import javax.transaction.Transaction;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class DodavanjePitanjaVM {
	
	public static Boolean dodajPitanje(Pitanje pitanje) {
		
		try {
			Session sesija = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = (Transaction) sesija.beginTransaction();
			
	        Pitanje p= new Pitanje();
	        p.setPitanje(pitanje.getPitanje());
	        p.setOdgovor(pitanje.getOdgovor());
	        p.setPutanja(pitanje.getPutanja());
	        p.setKategorija_pitanja(pitanje.getKategorija_pitanja());
	        
	        
	        
	        sesija.save(p);
			tr.commit();
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

}
