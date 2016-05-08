package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;

public class BrisanjeKorisnikaVM {

	public static boolean brisanjeKorisnika(Korisnik korisnik) {
		
		try {
			
		/*	for (Korisnik k : korisnici) {
				if(k.getJmbg().equals(korisnik.getJmbg()))
						{
							korisnici.remove(k);
							return true;
						}
			}
		     
		     return false;*/
		}
			catch (Exception e) {
				e.printStackTrace();
				return false;
		}
		
		return true;
		   
	}
}
