package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import org.apache.log4j.Logger;
public class ModifikacijaPitanjaVM {
	final static Logger logger = Logger.getLogger(ModifikacijaPitanjaVM.class);

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
