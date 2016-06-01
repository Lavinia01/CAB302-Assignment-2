/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.Business;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;
import asgn2Passengers.Premium;

/**
 * @author James Hanford
 *
 */
public class PremiumTests {

	/**
	 * Test method for {@link asgn2Passengers.Premium#noSeatsMsg()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED METHOD
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Premium#upgrade()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgrade() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int DEPART_TIME = 3;
		
		//Create passenger of premium class
		Passenger p = new Premium(BOOK_TIME, DEPART_TIME); 
				
		assertTrue(p.upgrade() instanceof Business);
	}

	/**
	 * Test method for {@link asgn2Passengers.Premium#Premium(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testPremiumIntInt() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int DEPART_TIME = 3;
		
		//Create passenger of premium class
		Passenger p = new Premium(BOOK_TIME, DEPART_TIME); 
						
		assertTrue(p instanceof Premium);
	}

	/**
	 * Test method for {@link asgn2Passengers.Premium#Premium()}.
	 */
	//TESTING NOT REQUIRED PROTECTED
	@Test
	public void testPremium() {
		assertTrue(true);
	}

}
