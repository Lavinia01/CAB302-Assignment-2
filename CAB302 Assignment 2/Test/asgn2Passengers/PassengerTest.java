/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asgn2Passengers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Charles
 */
public class PassengerTest {
    
    public PassengerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPassenger() throws Exception {
        int bookingTime = 0;
        int departureTime = 0;
        Passenger instance = new Economy(bookingTime, departureTime);
        assertTrue(instance.isNew());
        assertTrue(instance.getBookingTime() == bookingTime);
        assertTrue(instance.getDepartureTime() == departureTime);
        assertFalse(instance.confirmed);
        assertFalse(instance.isQueued());
        assertFalse(instance.isFlown());
        assertFalse(instance.isRefused());
        assertTrue(instance.getEnterQueueTime() == 0);
        assertTrue(instance.getExitQueueTime() == 0);
        assertTrue(instance.getConfirmationTime() == 0);
        

    }

    /**
     * Test of cancelSeat method, of class Passenger.
     */
    @Test
    public void testEconomy() throws Exception {
        int cancellationTime = 0;
        int bookingTime = 0;
        Passenger instance = new Economy(bookingTime, cancellationTime);
        instance.cancelSeat(cancellationTime);
        assertFalse(instance.isConfirmed());
        assertTrue(instance.isNew());
        assertTrue(instance.getBookingTime() == cancellationTime);

    }

    /**
     * Test of confirmSeat method, of class Passenger.
     */
    @Test
    public void testConfirmSeat() throws Exception {
        int confirmationTime = 0;
        int departureTime = 0;
        int bookingTime = 0;
        Passenger instance = new Economy(bookingTime, departureTime);
        instance.confirmSeat(confirmationTime, departureTime);
        assertFalse(instance.isNew());
        assertFalse(instance.isQueued());
        assertTrue(instance.isConfirmed());
        assertTrue(instance.getDepartureTime() == departureTime);
        assertTrue(instance.getConfirmationTime() == confirmationTime);
    }

    /**
     * Test of flyPassenger method, of class Passenger.
     */
    @Test
    public void testFlyPassenger() throws Exception {
        int confirmationTime =0;
        int departureTime = 0;
        Passenger instance = new Economy(confirmationTime, departureTime);
        instance.flyPassenger(departureTime);
        assertFalse(instance.isConfirmed());
        assertTrue(instance.isFlown());
        assertTrue(instance.getDepartureTime() == departureTime);

    }


    /**
     * Test of queuePassenger method, of class Passenger.
     */
    @Test
    public void testQueuePassenger() throws Exception {
        int queueTime = 0;
        int departureTime = 0;
        Passenger instance = new Economy(queueTime, departureTime);
        instance.queuePassenger(queueTime, departureTime);
        assertFalse(instance.isNew());
        assertTrue(instance.isQueued());
        assertTrue(instance.getEnterQueueTime() == queueTime);
        assertTrue(instance.getDepartureTime() == departureTime);

    }

    /**
     * Test of refusePassenger method, of class Passenger.
     */
    @Test
    public void testRefusePassenger() throws Exception {
        int refusalTime = 0;
        int bookingTime = 0;
        Passenger instance = new Economy(bookingTime,refusalTime);
        instance.refusePassenger(refusalTime);
        assertFalse(instance.isNew());
        assertFalse(instance.isQueued());
        assertTrue(instance.isRefused());

    }

}

