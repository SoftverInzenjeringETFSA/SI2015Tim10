package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
import org.hibernate.Session;
public class BrisanjePitanjaVM {
	final static Logger logger = Logger.getLogger(BrisanjePitanjaVM.class);
    
	private static Session s;
    
	public BrisanjePitanjaVM(Session s) {
		this.s = s;
	}
	public static boolean obrisiPitanje(Pitanje pitanje) {
		
		try {
			
			//this.pitanja.remove(pitanje);
			// KOD ZA BRISANJE PITANJA
			
		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			
			return false;
		}
		
		return true;
	}

}
