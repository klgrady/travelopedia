package com.travelopedia.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    @Test
    public void locationCodeReturnsCorrectLocations() {
        assertEquals("San Diego, CA", Airport.SAN.getLocation());
        assertEquals("Cleveland,OH", Airport.CLE.getLocation());
        assertEquals("Seattle, WA", Airport.SEA.getLocation());
        assertEquals("Newark, NJ", Airport.EWR.getLocation());
        assertEquals("Denver, CO", Airport.DEN.getLocation());
    }

    @Test
    public void LocationCodeReturnsCorrectNames() {
        assertEquals("Phoenix Sky Harbor International", Airport.PHX.getName());
        assertEquals("Washington Dulles International", Airport.IAD.getName());
        assertEquals("San Francisco International", Airport.SFO.getName());
        assertEquals("Los Angeles International", Airport.LAX.getName());
        assertEquals("Minneapolis St. Paul International", Airport.MSP.getName());
    }
}