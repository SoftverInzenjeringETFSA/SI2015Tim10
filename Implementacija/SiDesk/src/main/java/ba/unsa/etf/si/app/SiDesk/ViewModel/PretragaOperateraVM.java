package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public class PretragaOperateraVM {
	final static Logger logger = Logger.getLogger(PretragaOperateraVM.class);


	public static Operater nadjiOperatera(String username, Session s) {
		Operater o = null;
		try{
			Transaction t = s.beginTransaction();
			Criteria criteria = s.createCriteria(Korisnik.class).add(Restrictions.like("korisnickoIme", username).ignoreCase());
			List<Korisnik> lista = criteria.list();
			Korisnik k = lista.get(0);
			
			criteria = s.createCriteria(Operater.class).add(Restrictions.like("id", k.getOperater_korisnik().getId()));
			o = (Operater) criteria.list().get(0);
			
			
		} catch (Exception e){
			logger.error("Došlo je do greške:", e);
		
		}
		return o;
	}

}
