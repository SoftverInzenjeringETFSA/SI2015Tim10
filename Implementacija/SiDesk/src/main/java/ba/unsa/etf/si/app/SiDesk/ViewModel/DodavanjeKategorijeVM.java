package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.Date;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class DodavanjeKategorijeVM {
	
	public static boolean dodajKategoriju(String putanja, String kategorija) {
		try {
		
			Session sesija = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = sesija.beginTransaction();
			
	        Kategorija k= new Kategorija();
	        k.setIme(kategorija);
	        k.setPutanja(putanja);
	      //  k.setParentId();
	        
	        
	        
	        sesija.save(k);
			tr.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
