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
		
			//pretraga djece cvora, djecu ne mora imati
			Criteria children = session.createCriteria(Kategorija.class).add(Restrictions.like("putanja", putanja + ime, MatchMode.ANYWHERE));
			List<Kategorija> listaDjece = null;
			if(children.list().size() != 0) 
				listaDjece = children.list();
			
			//pretraga pitanja povezanih sa kategorijom i podkategorijama, pitanja ne mora naci
			List<Pitanje> listaPitanja = PretragaPitanjaVM.nadjiPitanjaSaPutanjom(putanja + ime);
						
			for(int i = 0; i < listaPitanja.size(); i++)
			{
				listaPitanja.get(i).setKategorija_pitanja(null);
				session.delete(listaPitanja.get(i));
			}
			
			if(listaDjece != null)
			{
				//brise se od kraja radi parent id
				for(int i = listaDjece.size()-1; i >= 0; i--)
				{
						listaDjece.get(i).setParentId(null);
						session.delete(listaDjece.get(i));
				}
			}
			
			k.setParentId(null);
			session.delete(k);
			
			JOptionPane.showMessageDialog(null, "Kategorija je uspješno obrisana.","Info", JOptionPane.INFORMATION_MESSAGE);	
			t.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
