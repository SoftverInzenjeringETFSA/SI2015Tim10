package ba.unsa.etf.si.app.SiDesk.Validation;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ValidatorTest.class);
		//$JUnit-END$
		return suite;
	}

}
