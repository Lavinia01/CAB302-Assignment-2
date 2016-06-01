/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.Business;
import asgn2Passengers.Economy;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;
import asgn2Passengers.Premium;

/**
 * @author James Hanford
 *
 */
public class EconomyTests {

	/**
	 * Test method for {@link asgn2Passengers.Economy#noSeatsMsg()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED METHOD
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Economy#upgrade()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgrade() throws PassengerException {
		
		//Create passenger of business class
		Passenger p = new Economy(0,1); 
				
		assertTrue(p.upgrade() instanceof Premium);
	}

	/**
	 * Test method for {@link asgn2Passengers.Economy#Economy(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testEconomy() throws PassengerException {
		
		//Create passenger of business class
		Passenger p = new Economy(0,1); 
						
		assertTrue(p instanceof Economy);
	}

}
