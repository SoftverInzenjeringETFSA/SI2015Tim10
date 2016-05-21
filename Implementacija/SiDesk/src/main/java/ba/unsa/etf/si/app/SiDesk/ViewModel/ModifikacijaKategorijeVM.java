package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public class ModifikacijaKategorijeVM {
	final static Logger logger = Logger.getLogger(ModifikacijaKategorijeVM.class);


	
	public static boolean modifikacijaKategorije(String putanja, String staroIme, String novoIme, Session session) {
		try {
			if(putanja == "") putanja = null;
			Kategorija k = TrazenjeKategorijeVM.nadjiKategoriju(putanja, staroIme, session);
	        Transaction t = session.beginTransaction();
	        k.setIme(novoIme);
	        session.update(k);
	        
	        //treba promijeniti i putanje svih koji imaju excel (pitanja i kategorije)
	        Criteria criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("putanja", putanja + staroIme, MatchMode.ANYWHERE).ignoreCase());
			List<Kategorija> listaKategorija = criteria.list();		
			for(int i = 0; i < listaKategorija.size(); i++){
				String novaPutanja = listaKategorija.get(i).getPutanja();
				novaPutanja = novaPutanja.replace(staroIme, novoIme);
				listaKategorija.get(i).setPutanja(novaPutanja);
				session.update(listaKategorija.get(i));
			}
			//isto za pitanja
			Criteria criteria2 = session.createCriteria(Pitanje.class).add(Restrictions.like("putanja", putanja + staroIme, MatchMode.ANYWHERE).ignoreCase());
			List<Pitanje> listaPitanja = criteria2.list();		
			for(int i = 0; i < listaPitanja.size(); i++){
				String novaPutanja = listaPitanja.get(i).getPutanja();
				novaPutanja = novaPutanja.replace(staroIme, novoIme);
				listaPitanja.get(i).setPutanja(novaPutanja);
				session.update(listaPitanja.get(i));
			}
			t.commit();
	        
			JOptionPane.showMessageDialog(null, "Kategorija je uspješno modifikovana.","Info", JOptionPane.INFORMATION_MESSAGE);	

		}
		catch (Exception e) {
			logger.error("Došlo je do greške:", e);
			
			return false;
		}
		
		return true;
	}
}
