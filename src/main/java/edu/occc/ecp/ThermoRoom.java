package edu.occc.ecp;

/**
 * ThermoRoom
 */
public class ThermoRoom {

    public static int STATUS_OFF = 0;
    public static int STATUS_ON = 1;

    private int status;
    private double temperature;

    public ThermoRoom(double temperature) {
        this.temperature = temperature;
    }

    // FUNCTIONS
    public void update(double target, int mode) {
        if (mode == ThermoHouse.MODE_AC && temperature > target) {
            temperature = temperature * 0.99f;
            temperature = Math.round(temperature);
            status = 1;
        } else if (mode == ThermoHouse.MODE_HEAT && temperature < target) {
            temperature = temperature * 1.01f;
            temperature = Math.round(temperature);
            status = 1;
        } else {
            status = 0;
        }
    }

    // GSET

    /**
     * Gets the status of the Room STATUS_OFF, STATUS_ON
     *
     * @return the status
     */
    public int getStatus() {
        return status;
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
