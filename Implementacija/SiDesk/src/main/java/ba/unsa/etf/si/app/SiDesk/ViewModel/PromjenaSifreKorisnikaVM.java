package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import org.apache.log4j.Logger;
public class PromjenaSifreKorisnikaVM {
	final static Logger logger = Logger.getLogger(PromjenaSifreKorisnikaVM.class);

	public static boolean promijeniSifruKorisnika(Korisnik korisnik, String novaSifra, String staraSifra) {
		try {
			
			/*for (Korisnik k : korisnici) {
				if (k.getJmbg().equals(korisnik.getJmbg())) {
					if (k.getSifra() == staraSifra) {
						k.setSifra(novaSifra);
						
					}
				}
			}*/

			
		} catch (Exception e) {
			logger.error("Došlo je do greške:", e);
		
			return false;
		}
		
		return true;
		
	}
	

}
