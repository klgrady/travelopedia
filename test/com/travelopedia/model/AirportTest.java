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
        assertEquals("Phoenix Sky Harbor International", Airport.PHX.getAirportCode());
        assertEquals("Washington Dulles International", Airport.IAD.getAirportCode());
        assertEquals("San Francisco International", Airport.SFO.getAirportCode());
        assertEquals("Los Angeles International", Airport.LAX.getAirportCode());
        assertEquals("Minneapolis St. Paul International", Airport.MSP.getAirportCode());
    }
}