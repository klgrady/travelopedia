package com.travelopedia.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    @Test
    public void locationCodeReturnsCorrectLocations() {
        assertEquals("San Diego, CA", Airport.SAN.getAirportCity());
        assertEquals("Cleveland,OH", Airport.CLE.getAirportCity());
        assertEquals("Seattle, WA", Airport.SEA.getAirportCity());
        assertEquals("Newark, NJ", Airport.EWR.getAirportCity());
        assertEquals("Denver, CO", Airport.DEN.getAirportCity());
    }

    @Test
    public void LocationCodeReturnsCorrectNames() {
        assertEquals("PHX", Airport.PHX.getAirportCode());
        assertEquals("IAD", Airport.IAD.getAirportCode());
        assertEquals("SFO", Airport.SFO.getAirportCode());
        assertEquals("LAX", Airport.LAX.getAirportCode());
        assertEquals("MSP", Airport.MSP.getAirportCode());
    }
}