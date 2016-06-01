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

/**
 * @author James Hanford
 *
 */
public class BusinessTests {

	/**
	 * Test method for {@link asgn2Passengers.Business#noSeatsMsg()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#upgrade()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgrade() throws PassengerException {
		
		//Create passenger of business class
		Passenger p = new Business(0,1); 
		
		assertTrue(p.upgrade() instanceof First);
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#Business(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testBusinessIntInt() throws PassengerException {
		
		//Create passenger of business class
		Passenger p = new Business(0,1); 
				
		assertTrue(p instanceof Business);
	}

	/**
	 * Test method for {@link asgn2Passengers.Business#Business()}.
	 */
	//TESTING NOT REQUIRED PROTECTED
	@Test
	public void testBusiness() {
		assertTrue(true); 
	}

}
