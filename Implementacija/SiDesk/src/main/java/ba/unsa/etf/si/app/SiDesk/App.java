package ba.unsa.etf.si.app.SiDesk;


import org.hibernate.*;


import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.View.Login;
import ba.unsa.etf.si.app.SiDesk.View.*;
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
        Transaction t = session.beginTransaction();
        
    //	session.save(new Operater());
		//t.commit();
        Login window = new Login();
		window.frmSidesklogin.setVisible(true);
		
    	} catch (Exception e) {
    		System.out.println(e);
		}
        
    }
}
