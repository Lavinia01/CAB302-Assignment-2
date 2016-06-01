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
public class BusinessTest {
    
    public BusinessTest() {
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
     * Test of noSeatsMsg method, of class Business.
     */
    @Test
    public void testBusiness() throws PassengerException {
        int bookingTime = 0;
        int departureTime = 0;
        Business instance = new Business(bookingTime, departureTime);
        String string1 =  "J:0";
        assertTrue("Business testBusiness failed",string1.equals(instance.passID));
        }
    /**
     * Test of upgrade method, of class Business.
     */
    @Test
    public void testUpgrade() throws PassengerException {
        int bookingTime = 0;
        int departureTime = 0;
        Business instance = new Business(bookingTime, departureTime);
        assertTrue(instance.departureTime == departureTime);
        assertTrue(instance.departureTime == departureTime);
        assertTrue(instance.isNew());
        assertFalse(instance.isConfirmed());
        assertFalse(instance.isQueued());
        assertFalse(instance.isFlown());
        assertFalse(instance.isRefused());
        assertTrue(instance.getEnterQueueTime() == 0);
        assertTrue(instance.getExitQueueTime() == 0);
        assertTrue(instance.getConfirmationTime() == 0);
        assertTrue(instance.upgrade() instanceof Business);
    }
    
}





