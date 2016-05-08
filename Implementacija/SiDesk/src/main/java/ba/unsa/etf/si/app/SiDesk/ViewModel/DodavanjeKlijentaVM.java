package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;

public class DodavanjeKlijentaVM {

	public static boolean dodajKlijenta(Klijent klijent) {
		
		try {
			// ovdje bi moglo po telefonskom idu
			//klijenti.add(klijent);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
