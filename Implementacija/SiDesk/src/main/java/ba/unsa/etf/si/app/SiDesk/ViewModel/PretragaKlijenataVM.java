package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.ArrayList;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;

public class PretragaKlijenataVM {
	
	public ArrayList<Klijent> pretraziKlijente(String ime, String prezime, int starost, String zaposlenje) {
	    ArrayList<Klijent> rezultatPretrage = new ArrayList<Klijent>();
		try {
			
			/*for (Klijent k : klijenti) {
				if (k.getIme().equals(ime) || k.getPrezime().equals(prezime) || k.getStarost()==starost || k.getZaposlenje().equals(zaposlenje)) {
					rezultatPretrage.add(k);
				}
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			// vratiti praznu listu?
		}
		
		return rezultatPretrage;
	}
}
