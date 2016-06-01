/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Aircraft.Aircraft;
import asgn2Aircraft.AircraftException;
import asgn2Aircraft.B747;
import asgn2Passengers.Passenger;

/**
 * @author Development
 *
 */
public class AircraftTests {

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException
	 */
	@Test(expected = AircraftException.class)
	public void testAircraftNullFlightCode() throws AircraftException {
		Aircraft io = new B747(null, 0100);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException
	 */
	@Test(expected = AircraftException.class)
	public void testAircraftEmptyFlightCode() throws AircraftException {
		Aircraft io = new B747("", 0100);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 */
	@Test
	public void testCancelBooking() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 */
	@Test
	public void testConfirmBooking() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#finalState()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED
	@Test
	public void testFinalState() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightEmpty()}.
	 */
	@Test
	public void testFlightEmpty() {
		//TODO: Requires passenger object
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightFull()}.
	 * @throws AircraftException 
	 */
	@Test
	public void testFlightFullTrue() throws AircraftException {
		Aircraft io = new B747("1234", 0100, 0,0,0,1);
		//TODO: Requires passenger object
		//io.confirmBooking(, 0100);
		assertTrue(io.flightFull());
		//
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flyPassengers(int)}.
	 */
	@Test
	public void testFlyPassengers() {
		//TODO: Requires passenger object
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getBookings()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetBookings() {
		//UNSURE ABOUT TESTING AS IT ISNT A SIMPLE GETTER
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumBusiness()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetNumBusiness() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumEconomy()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetNumEconomy() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumFirst()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetNumFirst() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumPassengers()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetNumPassengers() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getNumPremium()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetNumPremium() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getPassengers()}.
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetPassengers() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getStatus(int)}.
	 */
	//TESTING NOT REQUIRED SUPPLIED
	@Test
	public void testGetStatus() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#hasPassenger(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testHasPassenger() {
		//TODO:Requires passenger object
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#initialState()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED
	@Test
	public void testInitialState() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 */
	@Test
	public void testSeatsAvailable() {
		//TODO:Requires passenger object
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#toString()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED
	@Test
	public void testToString() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 */
	@Test
	public void testUpgradeBookings() {
		//TODO:Requires passenger object
		fail("Not yet implemented");
	}

}
