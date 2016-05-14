package ba.unsa.etf.si.app.SiDesk.ViewModel;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class ModifikacijaKlijentaVM {
	
	public static boolean modifikacijaKlijenta(Klijent klijent) {
		
		try {
			Session s2 = (Session) HibernateUtil.getSessionFactory().openSession();
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	
	}	

}
