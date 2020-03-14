package edu.occc.ecp;

import java.util.ArrayList;
import java.util.List;

/**
 * ThermoHouse
 */
public class ThermoHouse {

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
        this.rooms.add(room);
    }

    /**
     * Create a ThermoHouse with multiple rooms using temperatures
     *
     * @param temperatures
     */
    public ThermoHouse(double[] temperatures) {
        for (double temperature : temperatures)
            this.rooms.add(new ThermoRoom(temperature));
    }

    /**
     * Create a ThermoHouse with one room using temperature
     *
     * @param temperature
     */
    public ThermoHouse(double temperature) {
        this.rooms.add(new ThermoRoom(temperature));
    }

    /**
     * Get all rooms
     * @return the rooms
     */
    public List<ThermoRoom> getRooms() {
        return this.rooms;
    }

    /**
     * Set all rooms
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
}
