package ba.unsa.etf.si.app.SiDesk.ViewModel;



import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class SpašavanjeTelefonskogPozivaVM {

		public static boolean sacuvajTelefonskiPoziv(TelefonskiPoziv tp) {
		
			try {
				
				/*Date sada=new Date();
				tp.trajanjePoziva= sada.getTime()-tp.poziv.getTime(); //milisekunde 
				
//			    long diffSeconds = diff / 1000 % 60;
//			    long diffMinutes = diff / (60 * 1000) % 60;
//			    long diffHours = diff / (60 * 60 * 1000);
				
				tp.opisniTekst=""; // nesto ce tu kontroler pokupiti za viewa
				
				// upis u bazuuuuuuu*/
				
	/*			Session s2 = (Session) HibernateUtil.getSessionFactory().openSession();
			       Transaction ta = s2.beginTransaction();
			        TelefonskiPoziv a= new TelefonskiPoziv ( ); 
			        s2.save(a);
			        ta.commit();
				*/
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
			
		}
}
