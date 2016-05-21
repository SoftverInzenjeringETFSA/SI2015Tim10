package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import org.apache.log4j.Logger;
import org.hibernate.Session;
public class ModifikacijaPitanjaVM {
	final static Logger logger = Logger.getLogger(ModifikacijaPitanjaVM.class);

	private static Session session;
    
	public ModifikacijaPitanjaVM(Session s) {
		this.session = s;
	}
	
	public static boolean modifikacijaPitanja(Pitanje pitanje) {

		try {

		}

		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			
			return false;
		}
		
		return true;

	}

}
