package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
public class DodavanjeKategorijeVM {
	final static Logger logger = Logger.getLogger(BrisanjeKategorijeVM.class);

	public static boolean dodajKategoriju(String putanja, String kategorija, Kategorija parent) {
		try {
		
			Session sesija = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction tr = sesija.beginTransaction();
			
	        Kategorija k= new Kategorija();
	        k.setIme(kategorija);
	        k.setPutanja(putanja);
	        k.setParentId(parent);
	        	        
	        sesija.save(k);
			tr.commit();		
			
			JOptionPane.showMessageDialog(null, "Kategorija je uspješno dodana.","Info", JOptionPane.INFORMATION_MESSAGE);	

		}
		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			
			return false;
		}
		
		return true;
	}

}
