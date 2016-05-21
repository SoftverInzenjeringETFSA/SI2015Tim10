package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
import org.hibernate.Session;
public class BrisanjeKlijentaVM {

	final static Logger logger = Logger.getLogger(BrisanjeKlijentaVM.class);
    
	private static Session s;
    
	public BrisanjeKlijentaVM(Session s) {
		this.s = s;
	}
	
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
			
			 return false;
		}
		
		return true;
		
	}
}
