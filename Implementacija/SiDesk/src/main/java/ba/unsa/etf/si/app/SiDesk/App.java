package ba.unsa.etf.si.app.SiDesk;


import org.hibernate.*;


import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.View.Login;

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
        
        Login window = new Login(session);
        window.OtvoriFormu();

		
    	} catch (Exception e) {
    		System.out.println(e);
		}
        
    }
}
