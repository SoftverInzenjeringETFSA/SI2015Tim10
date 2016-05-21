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
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;

import org.apache.log4j.Logger;
public class BrisanjeKategorijeVM {
	final static Logger logger = Logger.getLogger(BrisanjeKategorijeVM.class);
	
	public static boolean obrisiKategoriju(String putanja, String ime, Session s) {
		if(!s.isOpen()){
			s = (Session) HibernateUtil.getSessionFactory().openSession();
		}
		
		try {
	        Transaction t = s.beginTransaction();
			//brisanje pitanja povezanih sa kategorijom	        
	        
	        //kategoriju mora naci
			Criteria criteria = s.createCriteria(Kategorija.class).add(Restrictions.like("ime", ime).ignoreCase());
			List<Kategorija> lista = criteria.list();		
			if(lista.size() == 0) {
				JOptionPane.showMessageDialog(null, "Nije prona�ena kategorija.","Info", JOptionPane.INFORMATION_MESSAGE);	
				return false; 
			}
			Kategorija k = lista.get(0);
		
			//pretraga djece cvora, djecu ne mora imati
			Criteria children = s.createCriteria(Kategorija.class).add(Restrictions.like("putanja", putanja + ime, MatchMode.ANYWHERE));
			List<Kategorija> listaDjece = null;
			if(children.list().size() != 0) 
				listaDjece = children.list();
			
			//pretraga pitanja povezanih sa kategorijom i podkategorijama, pitanja ne mora naci
			List<Pitanje> listaPitanja = PretragaPitanjaVM.nadjiPitanjaSaPutanjom(putanja + ime, s);
						
			for(int i = 0; i < listaPitanja.size(); i++)
			{
				listaPitanja.get(i).setKategorija_pitanja(null);
				s.delete(listaPitanja.get(i));
			}
			
			if(listaDjece != null)
			{
				//brise se od kraja radi parent id
				for(int i = listaDjece.size()-1; i >= 0; i--)
				{
						listaDjece.get(i).setParentId(null);
						s.delete(listaDjece.get(i));
				}
			}
			
			k.setParentId(null);
			s.delete(k);
			
			JOptionPane.showMessageDialog(null, "Kategorija je uspje�no obrisana.","Info", JOptionPane.INFORMATION_MESSAGE);	
			t.commit();
		} 
		 catch (Exception e) {
			logger.error("Do�lo je do gre�ke:", e);
			
			return false;
		}
		
		return true;
	}
}
