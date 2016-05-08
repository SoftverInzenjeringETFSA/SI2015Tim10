package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;

public class DodavanjeKorisnikaVM {

	public static boolean dodajKorisnika(Korisnik korisnik) {

		try {
			/*for (Korisnik k : korisnici) {
				if(k.getJmbg().equals(korisnik.getJmbg()))
				return false;
				
			}
			
			korisnici.add(korisnik);*/
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
