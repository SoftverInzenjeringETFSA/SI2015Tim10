package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class BrisanjeKategorijeVM {

	public static boolean obrisiKategoriju(String putanja, String ime) {
		try {
			Session session = (Session) HibernateUtil.getSessionFactory().openSession();
	        Transaction t = session.beginTransaction();
			//brisanje pitanja povezanih sa kategorijom	        
	        
	        //kategoriju mora naci
			Criteria criteria = session.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase());
			List<Kategorija> lista = criteria.list();		
			if(lista.size() == 0) return false; 
			Kategorija k = lista.get(0);
			
			//pretraga pitanja povezanih sa kategorijom, pitanja ne mora naci
			Criteria pitanjaCriteria = session.createCriteria(Pitanje.class).add(Restrictions.like("kategorija_pitanja", k));
			List<Pitanje> listaPitanja = null;
			if(pitanjaCriteria.list().size() != 0) {
				listaPitanja = pitanjaCriteria.list();
			}
			
			//pretraga djece cvora, djecu ne mora imati
			Criteria children = session.createCriteria(Kategorija.class).add(Restrictions.like("putanja", putanja + ime, MatchMode.ANYWHERE));
			List<Kategorija> listaDjece = null;
			if(children.list().get(0) != null) 
				listaDjece = children.list();
			for(int i = 0; i < listaDjece.size(); i++)
			{
				//pretraga pitanja djece	
				//session.delete(listaDjece.get(i));
				children = session.createCriteria(Pitanje.class).add(Restrictions.like("kategorija_pitanja", listaDjece.get(i)));
				if(children.list().size() != 0) 
				{
					listaPitanja.addAll(children.list());
				}
			}
			
			for(int i = 0; i < listaPitanja.size(); i++)
			{
				session.delete(listaPitanja.get(i));
			}
			
			for(int i = 0; i < listaDjece.size(); i++)
			{
				session.delete(listaDjece.get(i));
			}
			k.setParentId(null);
			session.delete(k);
			
			System.out.println("Uspjesno obrisano");
			t.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
