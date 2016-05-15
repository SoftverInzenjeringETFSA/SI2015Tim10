package ba.unsa.etf.si.app.SiDesk.ViewModel;



import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class SpašavanjeTelefonskogPozivaVM {

	public static boolean spasiPoziv(String opisniTekst,Klijent klijent_id , Operater operater_id) {
		
		try {
			Session sesija = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = sesija.beginTransaction();
			
	        TelefonskiPoziv b = new TelefonskiPoziv();
	        b.setOpisniTekst(opisniTekst);
	        b.setKlijent(klijent_id);
	        b.setOperater(operater_id);
	       
	        	        
	        sesija.save(b);
			tr.commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	} 
}


