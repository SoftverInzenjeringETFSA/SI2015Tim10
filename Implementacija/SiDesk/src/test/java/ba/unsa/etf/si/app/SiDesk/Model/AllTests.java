package ba.unsa.etf.si.app.SiDesk.Model;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(IzvjestajTest.class);
		suite.addTestSuite(KategorijaTest.class);
		suite.addTestSuite(KlijentTest.class);
		suite.addTestSuite(KorisnikTest.class);
		suite.addTestSuite(OdjavaTest.class);
		suite.addTestSuite(OperaterTest.class);
		suite.addTestSuite(PitanjeTest.class);
		suite.addTestSuite(PrijavaTest.class);
		suite.addTestSuite(TelefonskiPozivTest.class);
		suite.addTestSuite(TipKorisnikaTest.class);
		//$JUnit-END$
		return suite;
	}

}
