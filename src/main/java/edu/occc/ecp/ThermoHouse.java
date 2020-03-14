package edu.occc.ecp;

import java.util.ArrayList;
import java.util.List;

import edu.occc.ecp.GeoLocation.GeoLocation;

/**
 * ThermoHouse
 */
public class ThermoHouse {

    private List<ThermoRoom> rooms = new ArrayList<ThermoRoom>();
    private GeoLocation location = new GeoLocation();

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
        for (double temperature : temperatures)
            this.rooms.add(new ThermoRoom(temperature));
    }

    /**
     * Create a ThermoHouse with one room using temperature
     *
     * @param temperature
     */
    public ThermoHouse(double temperature) {
        this(new double[] { temperature });
    }

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
     * @return the location
     */
    public GeoLocation getLocation() {
        return location;
    }

    /**
     * set the latitude and longitude using GeoLocation
     *
     * @param location the location to set
     */
    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    /**
     * set the latitude and longitude using doubles
     *
     * @param lat latitude to set
     * @param lng longitude to set
     */
    public void setLocation(double lat, double lng) {
        this.location = new GeoLocation(lat, lng);
    }
}
