package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.ArrayList;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;

public class PretragaKorisnikaNejedinstvenaVM {
	
public static ArrayList<Korisnik> pretraziKorisnikaImePrezimeTip(String ime, String prezime, TipKorisnika tip) {
		
		ArrayList<Korisnik> rezultatPretrage = new ArrayList<Korisnik>();
		
		try {
			/*for (Korisnik k : korisnici) {
				if(k.getIme().equals(ime) || k.getPrezime().equals(prezime) || k.getTipKorisnika().equals(tip))
					rezultatPretrage.add(k);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			// vraca praznu listu?
		}
		
		
		return rezultatPretrage;
	}
	

}
