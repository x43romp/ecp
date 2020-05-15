package edu.occc.ecp;

import java.util.ArrayList;
import java.util.List;

/**
 * ThermoHouse
 */
public class ThermoHouse {

    static int MODE_OFF = 0;
    static int MODE_AC = 1;
    static int MODE_HEAT = 2;

    private int mode;
    private double temperature;
    private double tolerance;

    private List<ThermoRoom> rooms = new ArrayList<ThermoRoom>();

    /**
     * Create a ThermoHouse with multiple rooms
     *
     * @param rooms array of ThermoRooms
     */
    public ThermoHouse(ThermoRoom[] rooms) {
        for (ThermoRoom room : rooms)
            this.rooms.add(room);
    }

    /**
     * Create a ThermoHouse with one room
     *
     * @param room ThermoRoom
     */
    public ThermoHouse(ThermoRoom room) {
        this(new ThermoRoom[] { room });
    }

    /**
     * Create a ThermoHouse with multiple rooms using temperatures
     *
     * @param temperatures
     */
    public ThermoHouse(double[] temperatures) {
        for (double temperature : temperatures) {
            this.rooms.add(new ThermoRoom(temperature));
        }
    }

    /**
     * Create a ThermoHouse with one room using temperature
     *
     * @param temperature
     */
    public ThermoHouse(double temperature) {
        this(new double[] { temperature });
    }

    // FUNCTIONS
    public void update() {
        // set mode by getting average
        double sum = 0;
        for (ThermoRoom room : rooms) {
            sum += room.getTemperature();
        }
        double average = sum / rooms.size();
        mode = (average < temperature) ? MODE_HEAT : //
                (average > temperature) ? MODE_AC : //
                        MODE_OFF;

        for (ThermoRoom room : rooms) {
            double target = temperature;
            target = (mode == MODE_AC) ? temperature - tolerance : target;
            target = (mode == MODE_HEAT) ? temperature + tolerance : target;
            room.update(target, mode);
        }
    }

    // GSET

    /**
     * Get all rooms
     *
     * @return the rooms
     */
    public List<ThermoRoom> getRooms() {
        return this.rooms;
    }

    /**
     * Set all rooms
     *
     * @param rooms the rooms to set
     */
    public void setRooms(List<ThermoRoom> roomList) {
        this.rooms.clear();
        for (ThermoRoom room : roomList) {
            this.rooms.add(room);
        }
    }

    /**
     * Get one room by index
     *
     * @param index the index of the room
     * @return returns room at an index
     */
    public ThermoRoom getRoom(int index) {
        return this.rooms.get(index);
    }

    /**
     * Sets one room by index
     *
     * @param index the index of the room
     * @param room  ThermoRoom
     */
    public void setRoom(int index, ThermoRoom room) {
        this.rooms.set(index, room);
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
