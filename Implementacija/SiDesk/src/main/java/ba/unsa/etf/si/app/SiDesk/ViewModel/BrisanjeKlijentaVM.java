package ba.unsa.etf.si.app.SiDesk.ViewModel;

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;

public class BrisanjeKlijentaVM {

	
	public static boolean brisanjeKlijenta(Klijent klijent) {
		
		 try {
			
			/* for (Klijent k : klijenti) {
					if(k.equals(klijent))
							{
								klijenti.remove(k);
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
