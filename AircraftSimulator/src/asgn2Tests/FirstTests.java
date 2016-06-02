/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.First;
import asgn2Passengers.Passenger;
import asgn2Passengers.PassengerException;

/**
 * @author James Hanford
 *
 */
public class FirstTests {

	/**
	 * Test method for {@link asgn2Passengers.First#noSeatsMsg()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED METHOD
	@Test
	public void testNoSeatsMsg() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.First#upgrade()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testUpgrade() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int DEPART_TIME = 3;
		
		//Create passenger of First class
		Passenger p = new First(BOOK_TIME, DEPART_TIME);  
		
		//No change as first is highest class
		assertTrue(p.upgrade() == p);
		
	}

	/**
	 * Test method for {@link asgn2Passengers.First#First(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testFirstIntInt() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int DEPART_TIME = 3;
		
		//Create passenger of first class
		Passenger p = new First(BOOK_TIME, DEPART_TIME); 
						
		assertTrue(p instanceof First);
	}

	/**
	 * Test method for {@link asgn2Passengers.First#First()}.
	 */
	//TESTING NOT REQUIRED PROTECTED
	@Test
	public void testFirst() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#Passenger(int, int)}.
	 * @throws PassengerException 
	 */
	@Test(expected = PassengerException.class)
	public void testPassengerIntIntIncorrectBookingValue() throws PassengerException {
		
		final int BOOK_TIME = -1;
		final int DEPART_TIME = 3;
		
		//Create passenger of first class
		Passenger p = new First(BOOK_TIME, DEPART_TIME);
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#Passenger(int, int)}.
	 * @throws PassengerException 
	 */
	@Test(expected = PassengerException.class)
	public void testPassengerIntIntIncorrectDepartValue() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int DEPART_TIME = 0;
		
		//Create passenger of first class
		Passenger p = new First(BOOK_TIME, DEPART_TIME);
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#Passenger(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testPassengerIntIntTrue() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int DEPART_TIME = 3;
		
		//Create passenger of first class
		Passenger p = new First(BOOK_TIME, DEPART_TIME);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#Passenger()}.
	 */
	//TESTING NOT REQUIRED PROTECTED
	@Test
	public void testPassenger() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#cancelSeat(int, int)}.
	 */
	@Test
    public void testCancelSeatTrue() throws PassengerException {
        
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 1;
		final int CANCEL_TIME = 2;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        assertTrue(p.isConfirmed() && !p.isNew() && p.getBookingTime() == BOOK_TIME);
        
        //Set state of passenger cancelled
        p.cancelSeat(CANCEL_TIME);
        
        assertTrue(!p.isConfirmed() && p.isNew() && p.getBookingTime() == CANCEL_TIME);

    }
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#cancelSeat(int, int)}.
	 */
	@Test(expected = PassengerException.class)
    public void testCancelSeatNotConfirmed() throws PassengerException {
        
		final int BOOK_TIME = 0;;
		final int CANCEL_TIME = 2;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger cancelled
        p.cancelSeat(CANCEL_TIME);
    }

	/**
	 * Test method for {@link asgn2Passengers.Passenger#confirmSeat(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testConfirmSeatNewPassenger() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 1;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        assertTrue(p.isConfirmed() && !p.isNew() && p.getBookingTime() == BOOK_TIME);
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#confirmSeat(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testConfirmSeatQueuedPassenger() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int QUEUE_TIME = 1;
		final int CONFIRM_TIME = 2;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set passenger queued
        p.queuePassenger(QUEUE_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        assertTrue(p.isConfirmed() && !p.isQueued() && p.getExitQueueTime() == CONFIRM_TIME && p.getBookingTime() == BOOK_TIME);
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#confirmSeat(int, int)}.
	 * @throws PassengerException 
	 */
	@Test(expected = PassengerException.class)
	public void testConfirmSeatDoubleConfirm() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 1;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#flyPassenger(int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testFlyPassengerTrue() throws PassengerException {

		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 1;
		final int DEPART_TIME = 3;
		final int NEW_DEPART_TIME = 4;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        //Attempt to fly passenger
        p.flyPassenger(NEW_DEPART_TIME);
        
        assertTrue(p.isFlown() && p.getDepartureTime() == NEW_DEPART_TIME && !p.isConfirmed());
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#flyPassenger(int)}.
	 * @throws PassengerException 
	 */
	@Test(expected = PassengerException.class)
	public void testFlyPassengerNotConfirmed() throws PassengerException {

		final int BOOK_TIME = 0;
		final int DEPART_TIME = 3;
		final int NEW_DEPART_TIME = 4;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Attempt to fly passenger
        p.flyPassenger(NEW_DEPART_TIME);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getBookingTime()}.
	 */
	//TESTING NOT REQUIRED SIMPLE GETTER
	@Test
	public void testGetBookingTime() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getConfirmationTime()}.
	 */
	//TESTING NOT REQUIRED SIMPLE GETTER
	@Test
	public void testGetConfirmationTime() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getDepartureTime()}.
	 */
	//TESTING NOT REQUIRED SIMPLE GETTER
	@Test
	public void testGetDepartureTime() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getEnterQueueTime()}.
	 */
	//TESTING NOT REQUIRED SIMPLE GETTER
	@Test
	public void testGetEnterQueueTime() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getExitQueueTime()}.
	 */
	//TESTING NOT REQUIRED SIMPLE GETTER
	@Test
	public void testGetExitQueueTime() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#getPassID()}.
	 */
	//TESTING NOT REQUIRED SIMPLE GETTER
	@Test
	public void testGetPassID() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isConfirmed()}.
	 */
	//TESTING NOT REQUIRED SIMPLE STATE GETTER
	@Test
	public void testIsConfirmed() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isFlown()}.
	 */
	//TESTING NOT REQUIRED SIMPLE STATE GETTER
	@Test
	public void testIsFlown() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isNew()}.
	 */
	//TESTING NOT REQUIRED SIMPLE STATE GETTER
	@Test
	public void testIsNew() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isQueued()}.
	 */
	//TESTING NOT REQUIRED SIMPLE STATE GETTER
	@Test
	public void testIsQueued() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#isRefused()}.
	 */
	//TESTING NOT REQUIRED SIMPLE STATE GETTER
	@Test
	public void testIsRefused() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#queuePassenger(int, int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testQueuePassengerTrue() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int QUEUE_TIME = 1;
		final int DEPART_TIME = 3;
		final int NEW_DEPART_TIME = 5;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Attempt queue passenger
        p.queuePassenger(QUEUE_TIME, NEW_DEPART_TIME);
        
        assertTrue(p.isQueued() && !p.isNew() && p.getEnterQueueTime() == QUEUE_TIME && p.getDepartureTime() == NEW_DEPART_TIME);
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#queuePassenger(int, int)}.
	 * @throws PassengerException 
	 */
	@Test(expected = PassengerException.class)
	public void testQueuePassengerAlreadyConfirmed() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 1;
		final int QUEUE_TIME = 1;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        //Attempt queue passenger
        p.queuePassenger(QUEUE_TIME, DEPART_TIME); 
    }

	/**
	 * Test method for {@link asgn2Passengers.Passenger#refusePassenger(int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testRefusePassengerNewState() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int REFUSAL_TIME = 1;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Attempt refuse passenger
        p.refusePassenger(REFUSAL_TIME);
        
        assert(!p.isNew() && p.isRefused());
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#refusePassenger(int)}.
	 * @throws PassengerException 
	 */
	@Test
	public void testRefusePassengerQueuedState() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int QUEUE_TIME = 2;
		final int REFUSAL_TIME = 2;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Queue passenger
        p.queuePassenger(QUEUE_TIME, DEPART_TIME);
        
        //Attempt refuse passenger
        p.refusePassenger(REFUSAL_TIME);
        
        assert(p.isRefused() && !p.isQueued() && p.getExitQueueTime() == REFUSAL_TIME);
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#refusePassenger(int)}.
	 * @throws PassengerException 
	 */
	@Test(expected = PassengerException.class)
	public void testRefusePassengerInvalidPassenger() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 2;
		final int REFUSAL_TIME = 2;
		final int DEPART_TIME = 3;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        //Attempt refuse passenger
        p.refusePassenger(REFUSAL_TIME);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#toString()}.
	 */
	//TESTING NOT REQUIRED SUPPLIED
	@Test
	public void testToString() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasConfirmed()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testWasConfirmedTrue() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 2;
		final int CANCEL_TIME = 3;
		final int DEPART_TIME = 4;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        //Remove state of passenger confirmed
        p.cancelSeat(CANCEL_TIME);
        
        assertTrue(!p.isConfirmed() && p.wasConfirmed());
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasConfirmed()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testWasConfirmedFalse() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int CONFIRM_TIME = 2;
		final int DEPART_TIME = 4;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Set state of passenger confirmed
        p.confirmSeat(CONFIRM_TIME, DEPART_TIME);
        
        assertTrue(p.isConfirmed() && !p.wasConfirmed());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasQueued()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testWasQueuedTrue() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int QUEUE_TIME = 2;
		final int REFUSAL_TIME = 3;
		final int DEPART_TIME = 4;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Queue passenger
        p.queuePassenger(QUEUE_TIME, DEPART_TIME);
        
        //Attempt refuse passenger
        p.refusePassenger(REFUSAL_TIME);
        
        assertTrue(p.wasQueued() && !p.isQueued());
	}
	
	/**
	 * Test method for {@link asgn2Passengers.Passenger#wasQueued()}.
	 * @throws PassengerException 
	 */
	@Test
	public void testWasQueuedFalse() throws PassengerException {
		
		final int BOOK_TIME = 0;
		final int REFUSAL_TIME = 3;
		final int DEPART_TIME = 4;
        
		//Create passenger object
        Passenger p = new First(BOOK_TIME, DEPART_TIME);
        
        //Attempt refuse passenger
        p.refusePassenger(REFUSAL_TIME);
        
        assertFalse(p.wasQueued());
	}

	/**
	 * Test method for {@link asgn2Passengers.Passenger#copyPassengerState(asgn2Passengers.Passenger)}.
	 * @throws PassengerException 
	 */
	//TESTING NOT REQUIRED
	@Test
	public void testCopyPassengerState() throws PassengerException {
		assertTrue(true);
	}

}
