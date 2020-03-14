package edu.occc.ecp;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ThermoTest
 */
public class ThermoHouseTest {

    public void testHouse() {
    }

    @Test
    public void gsetRoom() {

        // get
        ThermoHouse house = new ThermoHouse(43.3);
        assertEquals(house.getRoom(0).getTemperature(), 43.3, 0.0);

        // set
        house.setRoom(0, new ThermoRoom(99.99));
        assertEquals(house.getRoom(0).getTemperature(), 99.99, 0.0);
    }

    @Test
    public void gsetRooms() {

        // array tests
        double[] temps1 = { 43, 99.99 };
        double[] temps2 = { 23.204, 32.00 };

        // get
        ThermoHouse house = new ThermoHouse(temps1);
        List<ThermoRoom> rooms = house.getRooms();
        for (int i = 0; i < temps1.length; i++) {
            double roomTemp = rooms.get(i).getTemperature();
            assertEquals(roomTemp, temps1[i], 0.0);
        }

        // set
        rooms = new ArrayList<ThermoRoom>();
        for (double temp : temps2)
            rooms.add(new ThermoRoom(temp));

        house.setRooms(rooms);
        rooms.clear();
        rooms = house.getRooms();

        for (int i = 0; i < temps2.length; i++) {
            double roomTemp = rooms.get(i).getTemperature();
            assertEquals(roomTemp, temps2[i], 0.0);
        }

    }
}
