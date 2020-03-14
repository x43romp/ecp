package edu.occc.ecp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ThermoRoomTest
 */
public class ThermoRoomTest {

    public ThermoRoomTest() {
    }

    @Test
    public void gsetTemperature() {

        // get
        ThermoRoom room = new ThermoRoom(43.3);
        assertEquals(room.getTemperature(), 43.3, 0.0);

        // set
        room.setTemperature(99.99);
        assertEquals(room.getTemperature(), 99.99, 0.0);

    }
}
