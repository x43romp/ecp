package edu.occc.ecp;

/**
 * ThermoRoom
 */
public class ThermoRoom {

    private double temperature;

    public ThermoRoom(double temperature) {
        this.temperature = temperature;
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
