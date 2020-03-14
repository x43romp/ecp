package edu.occc.ecp.GeoLocation;

import java.math.BigDecimal;

/**
 * GeoLocation
 */
public class GeoLocation {

    // private double lat;
    private BigDecimal lat;
    private BigDecimal lng;

    /**
     * Creates a GeoLocation object using the OCCC geolocation
     */
    public GeoLocation() {
        this(35.3873845, -97.57028780000002);
    }

    public GeoLocation(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public GeoLocation(double lat, double lng) {
        this.lat = new BigDecimal(lat);
        this.lng = new BigDecimal(lng);
    }

    /**
     * @return the latitude
     */
    public double getLat() {
        return this.lat.doubleValue();
    }

    /**
     * @param lat the latitude to set
     */
    public void setLat(double lat) {
        this.lat = new BigDecimal(lat);
    }

    /**
     * @param lat the latitude to set
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    /**
     * @return the longitude
     */
    public double getLng() {
        return this.lng.doubleValue();
    }

    /**
     * @param lng the longitude to set
     */
    public void setLng(double lng) {
        this.lng = new BigDecimal(lng);
    }

    /**
     * @param lng the longitude to set
     */
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

}
