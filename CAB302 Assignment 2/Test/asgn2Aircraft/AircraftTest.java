/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asgn2Aircraft;

import asgn2Passengers.Passenger;
import java.util.List;
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
public class AircraftTest {
    
    public AircraftTest() {
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

    /**
     * Test of cancelBooking method, of class Aircraft.
     */
    @Test
    public void testCancelBooking() throws Exception {
        System.out.println("cancelBooking");
        Passenger p = null;
        int cancellationTime = 0;
        Aircraft instance = null;
        instance.cancelBooking(p, cancellationTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmBooking method, of class Aircraft.
     */
    @Test
    public void testConfirmBooking() throws Exception {
        System.out.println("confirmBooking");
        Passenger p = null;
        int confirmationTime = 0;
        Aircraft instance = null;
        instance.confirmBooking(p, confirmationTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalState method, of class Aircraft.
     */
    @Test
    public void testFinalState() {
		assertTrue(true);
    }

    /**
     * Test of flightEmpty method, of class Aircraft.
     */
    @Test
    public void testFlightEmpty() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }

        
        System.out.println("flightEmpty");
        Aircraft instance = null;
        boolean expResult = false;
        boolean result = instance.flightEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flightFull method, of class Aircraft.
     */
    @Test
    public void testFlightFull() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("flightFull");
        Aircraft instance = null;
        boolean expResult = false;
        boolean result = instance.flightFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flyPassengers method, of class Aircraft.
     */
    @Test
    public void testFlyPassengers() throws Exception {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("flyPassengers");
        int departureTime = 0;
        Aircraft instance = null;
        instance.flyPassengers(departureTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookings method, of class Aircraft.
     */
    @Test
    public void testGetBookings() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getBookings");
        Aircraft instance = null;
        Bookings expResult = null;
        Bookings result = instance.getBookings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumBusiness method, of class Aircraft.
     */
    @Test
    public void testGetNumBusiness() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getNumBusiness");
        Aircraft instance = null;
        int expResult = 0;
        int result = instance.getNumBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumEconomy method, of class Aircraft.
     */
    @Test
    public void testGetNumEconomy() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getNumEconomy");
        Aircraft instance = null;
        int expResult = 0;
        int result = instance.getNumEconomy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumFirst method, of class Aircraft.
     */
    @Test
    public void testGetNumFirst() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        
        System.out.println("getNumFirst");
        Aircraft instance = null;
        int expResult = 0;
        int result = instance.getNumFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPassengers method, of class Aircraft.
     */
    @Test
    public void testGetNumPassengers() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getNumPassengers");
        Aircraft instance = null;
        int expResult = 0;
        int result = instance.getNumPassengers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPremium method, of class Aircraft.
     */
    @Test
    public void testGetNumPremium() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getNumPremium");
        Aircraft instance = null;
        int expResult = 0;
        int result = instance.getNumPremium();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassengers method, of class Aircraft.
     */
    @Test
    public void testGetPassengers() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getPassengers");
        Aircraft instance = null;
        List<Passenger> expResult = null;
        List<Passenger> result = instance.getPassengers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Aircraft.
     */
    @Test
    public void testGetStatus() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("getStatus");
        int time = 0;
        Aircraft instance = null;
        String expResult = "";
        String result = instance.getStatus(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasPassenger method, of class Aircraft.
     */
    @Test
    public void testHasPassenger() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("hasPassenger");
        Passenger p = null;
        Aircraft instance = null;
        boolean expResult = false;
        boolean result = instance.hasPassenger(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialState method, of class Aircraft.
     */
    @Test
    public void testInitialState() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("initialState");
        Aircraft instance = null;
        String expResult = "";
        String result = instance.initialState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seatsAvailable method, of class Aircraft.
     */
    @Test
    public void testSeatsAvailable() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("seatsAvailable");
        Passenger p = null;
        Aircraft instance = null;
        boolean expResult = false;
        boolean result = instance.seatsAvailable(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Aircraft.
     */
    @Test
    public void testToString() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("toString");
        Aircraft instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of upgradeBookings method, of class Aircraft.
     */
    @Test
    public void testUpgradeBookings() {
        try {
            A380 flightEmpty = new A380("A380", 1600, 0, 0, 0, 0);
        } catch (AircraftException e) {
            
        }
        
        System.out.println("upgradeBookings");
        Aircraft instance = null;
        instance.upgradeBookings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AircraftImpl extends Aircraft {

        public AircraftImpl() throws Exception {
            super("", 0, 0, 0, 0, 0);
        }
    }
    
}
