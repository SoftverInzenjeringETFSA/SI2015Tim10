package ba.unsa.etf.si.app.SiDesk.Model;

import junit.framework.TestCase;

public class PitanjeTest extends TestCase 
{

	public void testPitanje1() 
	{
		// testiranje konstruktora sa dva parametra
		
		Pitanje p = new Pitanje("Kako otvoriti Control Panel?", "Start -> Control Panel");
		
		assertEquals("Kako otvoriti Control Panel?", p.getPitanje());
		assertEquals("Start -> Control Panel", p.getOdgovor());
	}

	public void testPitanje2() 
	{
		// testiranje konstruktora sa jednim parametrom
		
		Pitanje p = new Pitanje("Kako otvoriti Control Panel?");
		
		assertEquals("Kako otvoriti Control Panel?", p.getPitanje());
		assertEquals("", p.getOdgovor());
	}

}
