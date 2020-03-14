package edu.occc.ecp;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import edu.occc.ecp.GeoLocation.GeoLocation;

/**
 * GeoLocationTest
 */
public class GeoLocationTest {
    final double TOLERANCE = 0.001;

    public GeoLocationTest() {
    }

    @Test
    public void constructor() {
        GeoLocation gh = new GeoLocation();

        double lat = gh.getLat();
        double lng = gh.getLng();

        assertEquals(lat, 35.3873845, this.TOLERANCE);
        assertEquals(lng, -97.57028780000002, this.TOLERANCE);
    }

    @Test
    public void constructorDouble() {
        double lat = 43.000;
        double lng = -99.99;
        GeoLocation gh = new GeoLocation(lat, lng);

        assertEquals(gh.getLat(), lat, this.TOLERANCE);
        assertEquals(gh.getLng(), lng, this.TOLERANCE);
    }

    @Test
    public void constructorBigDecimal() {
        double lat = 43.000;
        double lng = -99.99;
        GeoLocation gh = new GeoLocation(new BigDecimal(lat), new BigDecimal(lng));

        assertEquals(gh.getLat(), lat, this.TOLERANCE);
        assertEquals(gh.getLng(), lng, this.TOLERANCE);
    }

    @Test
    public void gsetLatLng() {
        GeoLocation gh = new GeoLocation(0.1, 0.1);

        double lat = 43.0;
        double lng = -99.9;

        gh.setLat(lat);
        gh.setLng(lng);

        assertEquals(gh.getLat(), lat, this.TOLERANCE);
        assertEquals(gh.getLng(), lng, this.TOLERANCE);
    }
}
