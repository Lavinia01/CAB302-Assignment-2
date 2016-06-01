/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import asgn2Aircraft.A380;
import asgn2Aircraft.Aircraft;
import asgn2Aircraft.AircraftException;
import asgn2Aircraft.Bookings;
import asgn2Passengers.Economy;
import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;
import asgn2Passengers.Premium;

/**
 * @author James Hanford
 *
 */
public class A380Tests {

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException
	 */
	@Test(expected = AircraftException.class)
	public void testAircraftNullFlightCode() throws AircraftException {
		Aircraft io = new A380(null, 1);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#Aircraft(java.lang.String, int, int, int, int, int)}.
	 * @throws AircraftException
	 */
	@Test(expected = AircraftException.class)
	public void testAircraftEmptyFlightCode() throws AircraftException {
		Aircraft io = new A380("", 1);
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testCancelBookingTrue() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5);
		
		//Create passenger 
		Passenger p = new Economy(0,5);
		
		//Book passenger seat
		io.confirmBooking(p, 0);

		assertTrue(io.getPassengers().size() == 1 && io.getNumEconomy() == 1 && p.isConfirmed());
		
		//Attempt cancel booking 
		io.cancelBooking(p, 0);
		
		assertTrue(io.getPassengers().size() == 0 && io.getNumEconomy() == 0 && !p.isConfirmed());		
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#cancelBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test(expected = AircraftException.class)
	public void testCancelInvalidPassenger() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5);
		
		//Create passenger 
		Passenger p = new Economy(0,5);
		
		//Attempt cancel booking 
		io.cancelBooking(p, 0);		
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test(expected = AircraftException.class)
	public void testConfirmBookingDoubleUse() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5);
				
		//Create passenger 
		Passenger p = new Economy(0,5);
		
		//Attempt book passenger twice
		io.confirmBooking(p, 0);
		io.confirmBooking(p, 0);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#confirmBooking(asgn2Passengers.Passenger, int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testConfirmBookingTrue() throws AircraftException, PassengerException {
		//Create the plane with one seat
		Aircraft io = new A380("1234", 5);
				
		//Create passenger 
		Passenger p = new Economy(0,5);
		
		assertTrue(io.getPassengers().size() == 0);
		
		//Book passenger seat
		io.confirmBooking(p, 0);
		
		assertTrue(io.getPassengers().size() == 1 && io.getNumEconomy() == 1 && p.isConfirmed());
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
	 * @throws AircraftException 
	 */
	@Test
	public void testFlightEmptyTrue() throws AircraftException {
		//Create the plane with one seat
		Aircraft io = new A380("1234", 5, 0,0,0,1);
		
		assertTrue(io.flightEmpty());
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightEmpty()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testFlightEmptyFalse() throws AircraftException, PassengerException {
		//Create the plane with one seat
		Aircraft io = new A380("1234", 5, 0,0,0,1);
		
		//Create passenger 
		Passenger p = new Economy(0,5);
				
		//Book passenger for seat
		io.confirmBooking(p, 0);
		
		assertFalse(io.flightEmpty());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightFull()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testFlightFullTrue() throws AircraftException, PassengerException {
		//Create the plane with one seat
		Aircraft io = new A380("1234", 5, 0,0,0,1);
		
		//Create passenger 
		Passenger p = new Economy(0,5);
		
		//Book passengers seat
		io.confirmBooking(p, 0);
		
		assertTrue(io.flightFull());
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flightFull()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testFlightFullFalse() throws AircraftException, PassengerException {
		//Create the plane with two seats
		Aircraft io = new A380("1234", 5, 0,0,1,1);
		
		//Create passenger 
		Passenger p = new Economy(0,5);
		
		//Book passengers seat
		io.confirmBooking(p, 0);
		
		assertFalse(io.flightFull());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#flyPassengers(int)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testFlyPassengers() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5);
		
		//Create passengers 
		Passenger p = new Economy(0,5);
		
		//Book passengers seats
		io.confirmBooking(p, 0);
		
		assertFalse(p.isFlown());
		
		//Fly the passengers
		io.flyPassengers(5);
		
		assertTrue(p.isFlown());
	}

	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#getBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testGetBookings() throws AircraftException, PassengerException {
		
		final int EXPECTED_FIRST = 0;
		final int EXPECTED_BUSINESS = 0;
		final int EXPECTED_PREMIUM = 1;
		final int EXPECTED_ECONOMY = 1;
		final int EXPECTED_TOTAL = 2;
		
		//Create the plane with two seats
		Aircraft io = new A380("1234", 5, 0,0,1,1);
				
		//Create passengers 
		Passenger p1 = new Economy(0,5);
		Passenger p2 = new Premium(0,5);
				
		//Book passengers seats
		io.confirmBooking(p1, 0);
		io.confirmBooking(p2, 0);
		
		//Save booking to variable for assertion
		Bookings b = io.getBookings();
		
		assertTrue(b.getNumFirst() ==  EXPECTED_FIRST && b.getNumBusiness() == EXPECTED_BUSINESS && 
				b.getNumPremium() == EXPECTED_PREMIUM && b.getNumEconomy() == EXPECTED_ECONOMY && 
				b.getTotal() == EXPECTED_TOTAL);
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
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	//TESTING NOT REQUIRED GETTER
	@Test
	public void testGetPassengers() throws AircraftException, PassengerException {
		
		//Create mock seats list
		List<Passenger> expectedList = new ArrayList<Passenger>();
		
		//Create the plane
		Aircraft io = new A380("1234", 5);
						
		//Create the passenger 
		Passenger p1 = new Economy(0,5);
		Passenger p2 = new First(0,5);
		
		expectedList.add(p1);
		expectedList.add(p2);
		
		//Book Passengers and "fake" seats list
		io.confirmBooking(p1, 0);
		io.confirmBooking(p2, 0);
		
		//Retrieve copy of seats list via getPassengers
		List<Passenger> actualList = io.getPassengers();
		
		assertTrue(actualList.get(0) == expectedList.get(0) && actualList.get(1) == expectedList.get(1));
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
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testHasPassengerTrue() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5, 0,0,0,1);
				
		//Create the passenger 
		Passenger p = new Economy(0,5);
		
		//Book Passenger
		io.confirmBooking(p, 1);
		
		assertTrue(io.hasPassenger(p));
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#hasPassenger(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testHasPassengerFalse() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5, 0,0,0,1);
				
		//Create the passenger 
		Passenger p = new Economy(0,5);
		
		assertFalse(io.hasPassenger(p));
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
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testSeatsAvailableTrue() throws AircraftException, PassengerException {
		//Create the plane with Economy seat
		Aircraft io = new A380("1234", 5, 0,0,0,1);
						
		//Create the Economy passenger 
		Passenger p = new Economy(0,5);
		
		assertTrue(io.seatsAvailable(p));
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#seatsAvailable(asgn2Passengers.Passenger)}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testSeatsAvailableFalse() throws AircraftException, PassengerException {
		//Create the plane with Economy seat
		Aircraft io = new A380("1234", 5, 0,0,0,1);
						
		//Create the First passenger 
		Passenger p = new First(0,5);
		
		assertFalse(io.seatsAvailable(p));
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
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgradeBookingsSingle() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5, 0,1,1,0);
								
		//Create the Premium passenger 
		Passenger p = new Premium(0,5);
		
		//Book passenger
		io.confirmBooking(p, 1);
		
		//Run upgrades
		io.upgradeBookings();
		
		assertTrue(io.getNumPremium() == 0 && io.getNumBusiness() == 1);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgradeBookingsMultiple() throws AircraftException, PassengerException {
		//Create the plane
		Aircraft io = new A380("1234", 5, 0,1,1,1);
								
		//Create the Premium and Economy passengers 
		Passenger p1 = new Premium(0,5);
		Passenger p2 = new Economy(0,5);
		
		//Book passengers
		io.confirmBooking(p1, 1);
		io.confirmBooking(p2, 1);
		
		//Run upgrades
		io.upgradeBookings();
		
		assertTrue(io.getNumEconomy() == 0 && io.getNumPremium() == 1 && io.getNumBusiness() == 1);
	}
	
	/**
	 * Test method for {@link asgn2Aircraft.Aircraft#upgradeBookings()}.
	 * @throws AircraftException 
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgradeBookingsInvalid() throws AircraftException, PassengerException {
		//Create the plane with Economy and Premium seat
		Aircraft io = new A380("1234", 5, 0,0,1,1);
								
		//Create the Economy and Premium passengers 
		Passenger p1 = new Economy(0,5);
		Passenger p2 = new Premium(0,5);
		
		//Book passengers seats
		io.confirmBooking(p1, 1);
		io.confirmBooking(p2, 1);
		
		//Run upgrades
		io.upgradeBookings();
		
		assertTrue(io.getNumEconomy() == 1 && io.getNumPremium() == 1);
	}

}