package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.sql.Connection;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public class ModifikacijaKorisnikaVM {
	
		
		
		
			
			public static void modifikacijaKorisnika(JList lista,String ime, String prezime, String jmbg, 
					String brojTelefona, String email, String username, String password, 
					String adresa,String brojLicne,Date datumZaposljenja, String tipkorisnika, String imeOperatera)
				{
				try{
				Session s= HibernateUtil.getSessionFactory().openSession();	
				  Transaction t = s.beginTransaction();
				  Korisnik neko=new Korisnik();
				  neko=(Korisnik)lista.getSelectedValue();
				  Korisnik novi=new Korisnik();
				  novi = (Korisnik) s.createCriteria(Korisnik.class).add(Restrictions.eq("jmbg", jmbg)).uniqueResult();
				 TipKorisnika tip = (TipKorisnika) s.createCriteria(TipKorisnika.class).add(Restrictions.eq("tipKorisnika", tipkorisnika)).uniqueResult();
					Operater o=(Operater) s.createCriteria(Operater.class).add(Restrictions.eq("imeOperatera", imeOperatera)).uniqueResult();
					
				novi.setIme(ime);
				novi.setPrezime(prezime);
				novi.setJmbg(jmbg);
				novi.setBrojTelefona(brojTelefona);
				novi.setEmail(email);
				novi.setKorisnickoIme(username);
				novi.setSifra(password);
				novi.setAdresa(adresa);
				novi.setBrojLicneKarte(brojLicne);
				novi.setDatumZaposlenja(datumZaposljenja);
				novi.setOperater_korisnik(o);
				novi.setTipkorisnika(tip);
		
				
				s.update(novi);
				t.commit();
				System.out.println();
				s.close();
				int selectedIndex = lista.getSelectedIndex();
				DefaultListModel model = (DefaultListModel) lista.getModel();
				
			    model.remove(selectedIndex);
			    model.addElement(novi);
				
				JOptionPane.showMessageDialog(null,"Uspjesno modifikovan korisnik", "Info " + "Error", JOptionPane.INFORMATION_MESSAGE);		
				}
				catch (Exception e) {
					e.printStackTrace();
				
				}
			
				/*
				Transaction t = session.beginTransaction();
				
				Skladiste s = (Skladiste) App.session.get(Skladiste.class, id);
				
				for(Dokument d:s.get_dokumenti()) {
					String hql = "DELETE from Dokument WHERE dokument_id = :id";
					Query query = App.session.createQuery(hql);
					query.setParameter("id", d.getId());
					 t.commit();
						System.out.println("Uspjesno dodan korisnik");
						s.close();
					
					int result = query.executeUpdate();
				}
			}

				    Statement stmt = null;
				    String query =
				        "select COF_NAME, SUP_ID, PRICE, " +
				        "SALES, TOTAL " +
				        "from " + dbName + ".COFFEES";

				    try {
				        stmt = con.createStatement();
				        ResultSet rs = stmt.executeQuery(query);
				        while (rs.next()) {
				            String coffeeName = rs.getString("COF_NAME");
				            int supplierID = rs.getInt("SUP_ID");
				            float price = rs.getFloat("PRICE");
				            int sales = rs.getInt("SALES");
				            int total = rs.getInt("TOTAL");
				            System.out.println(coffeeName + "\t" + supplierID +
				                               "\t" + price + "\t" + sales +
				                               "\t" + total);
				        }
				    } catch (SQLException e ) {
				        JDBCTutorialUtilities.printSQLException(e);
				    } finally {
				        if (stmt != null) { stmt.close(); }
				    }
		//	updateInformation(korisnik);
//			this.setJmbg(korisnik.jmbg);
//			this.setBrojLicneKarte(korisnik.brojLicneKarte);
//			this.setAdresa(korisnik.adresa);
//			this.setEmail(korisnik.email);
//			this.setDatumZaposlenja(korisnik.datumZaposlenja);
//			this.setTipKorisnika(korisnik.tipKorisnika);
//			this.setKorisnickoIme(korisnik.korisnickoIme);
//			
//			// ne znam sta cu za passworde
//			//if(this.jmbg.equals(korisnik.jmbg)) - ovo dodati negdje gdje ce se citati lista korisnika iz baze i nazvati je modifikacijaKorisnika
		
			// NEKI KOD, ovo gore je samo koncept
			 */
			}
}
