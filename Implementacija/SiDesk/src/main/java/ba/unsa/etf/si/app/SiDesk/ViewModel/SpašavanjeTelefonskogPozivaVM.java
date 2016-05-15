package ba.unsa.etf.si.app.SiDesk.ViewModel;



import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;

public class SpašavanjeTelefonskogPozivaVM {

	public static boolean spasiPoziv(String opisniTekst,Klijent klijent_id ) {
		
		try {
			Session s2 = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = s2.beginTransaction();
	        
			
	        TelefonskiPoziv b = new TelefonskiPoziv();
	        b.setOpisniTekst(opisniTekst);
	        b.setKlijent(klijent_id);
	     //   b.setOperater(operater_id);
	       
	        	        
	        s2.save(b);
			tr.commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} 
	
/*	public static boolean spasiPitanje(Pitanje pitanje_id,TelefonskiPoziv poziv_id ) {
	/*	
		try {
			Session s2 = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = s2.beginTransaction();
	        		
			Pitanje a = new Pitanje();
	        TelefonskiPoziv b = new TelefonskiPoziv();
	        b.setId(poziv_id);
	    
	       
	        	        
	        s2.save(b);
	        s2.save(a);
			tr.commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} */
}

