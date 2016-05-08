package ba.unsa.etf.si.app.SiDesk.ViewModel;



import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;

public class SpašavanjeTelefonskogPozivaVM {

		public static boolean sacuvajTelefonskiPoziv(TelefonskiPoziv tp) {
		
			try {
				
				/*Date sada=new Date();
				tp.trajanjePoziva= sada.getTime()-tp.poziv.getTime(); //milisekunde 
				
//			    long diffSeconds = diff / 1000 % 60;
//			    long diffMinutes = diff / (60 * 1000) % 60;
//			    long diffHours = diff / (60 * 60 * 1000);
				
				tp.opisniTekst=""; // nesto ce tu kontroler pokupiti za viewa
				
				// upis u bazuuuuuuu*/
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
			
		}
}
