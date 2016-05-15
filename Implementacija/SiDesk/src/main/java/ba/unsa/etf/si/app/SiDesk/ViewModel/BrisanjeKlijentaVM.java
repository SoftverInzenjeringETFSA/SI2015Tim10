package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
public class BrisanjeKlijentaVM {

	final static Logger logger = Logger.getLogger(BrisanjeKlijentaVM.class);

	public static boolean brisanjeKlijenta(Klijent klijent) {
		
		 try {
			
			/* for (Klijent k : klijenti) {
					if(k.equals(klijent))
							{
								klijenti.remove(k);
								return true;
							}
				}
			     
			     return false;*/
		}
		 
		 catch (Exception e) {
			 logger.error("Došlo je do greške:", e);
			 e.printStackTrace();
			 return false;
		}
		
		return true;
		
	}
}
