package ba.unsa.etf.si.app.SiDesk.ViewModel;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BrisanjeKategorijeVMTest.class);
		suite.addTestSuite(BrisanjeKlijentaVMTest.class);
		suite.addTestSuite(BrisanjeKorisnikaVMTest.class);
		suite.addTestSuite(BrisanjePitanjaVMTest.class);
		suite.addTestSuite(DodavanjeKategorijeVMTest.class);
		suite.addTestSuite(DodavanjeKlijentaVMTest.class);
		suite.addTestSuite(DodavanjeKorisnikaVMTest.class);
		suite.addTestSuite(DodavanjePitanjaVMTest.class);
		suite.addTestSuite(ModifikacijaKategorijeVMTest.class);
		suite.addTestSuite(ModifikacijaKlijentaVMTest.class);
		suite.addTestSuite(ModifikacijaKorisnikaVMTest.class);
		suite.addTestSuite(ModifikacijaPitanjaVMTest.class);
		suite.addTestSuite(SpašavanjeTelefonskogPozivaVMTest.class);
		//$JUnit-END$
		return suite;
	}

}
