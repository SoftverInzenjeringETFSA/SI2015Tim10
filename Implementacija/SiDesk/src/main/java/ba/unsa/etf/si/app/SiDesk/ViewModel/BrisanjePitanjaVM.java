package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
public class BrisanjePitanjaVM {
	final static Logger logger = Logger.getLogger(BrisanjePitanjaVM.class);

	public static boolean obrisiPitanje(Pitanje pitanje) {
		
		try {
			
			//this.pitanja.remove(pitanje);
			// KOD ZA BRISANJE PITANJA
			
		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
