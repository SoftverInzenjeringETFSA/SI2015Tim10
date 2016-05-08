package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;

public class BrisanjePitanjaVM {
	
	public static boolean obrisiPitanje(Pitanje pitanje) {
		
		try {
			
			//this.pitanja.remove(pitanje);
			// KOD ZA BRISANJE PITANJA
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
