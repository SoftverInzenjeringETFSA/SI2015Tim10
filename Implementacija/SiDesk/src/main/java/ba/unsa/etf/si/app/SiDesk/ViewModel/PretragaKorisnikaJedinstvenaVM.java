package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;

public class PretragaKorisnikaJedinstvenaVM {

	public static Korisnik pretraziKorisnikaJMBG(String jmbg) {

		Korisnik k = new Korisnik(); // nako stavila
		try {

			/*
			 * for (Korisnik k : korisnici) { if(k.getJmbg().equals(jmbg)) {
			 * return k; } }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			// ovo onako stavila
			return new Korisnik();
		}

		return k; // nako stavila

	}

}
