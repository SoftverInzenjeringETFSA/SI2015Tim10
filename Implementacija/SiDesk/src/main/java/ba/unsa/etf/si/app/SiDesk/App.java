package ba.unsa.etf.si.app.SiDesk;


import javax.transaction.Transaction;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			
		
    	Session session = (Session) HibernateUtil.getSessionFactory().openSession();
        System.out.println( "Hello World!" );
        Transaction t = (Transaction) session.beginTransaction();
        
    	//session.save(new Kategorija());
		t.commit();
		
    	} catch (Exception e) {
    		System.out.println(e);
		}
        
    }
}
