package ba.unsa.etf.si.app.SiDesk.ViewModel;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public static void spasiPoziv(Klijent klijent, Pitanje pitanje, Operater operater, Date kal) {
		try {
			Session s2 = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = s2.beginTransaction();
	        
	        TelefonskiPoziv t = new TelefonskiPoziv(klijent, pitanje, operater, kal);
	        Set<Pitanje> pitanja = new HashSet<Pitanje>();
	        pitanja.add(pitanje);
	        t.setPitanja(pitanja);
	        pitanje.getTelefonski_pozivi().add(t);
	        
	        s2.save(t);
	        s2.save(pitanje);
	        tr.commit();	
	      	}
		catch (Exception e) {
			e.printStackTrace();
		}
	} 
}

