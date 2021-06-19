package com.travelopedia.model;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationCodeTest {
    @Test
    public void locationCodeReturnsCorrectLocations() {
        assertEquals("San Diego, CA", LocationCode.SAN.getLocation());
        assertEquals("Cleveland,OH", LocationCode.CLE.getLocation());
        assertEquals("Seattle, WA", LocationCode.SEA.getLocation());
        assertEquals("Newark, NJ", LocationCode.EWR.getLocation());
        assertEquals("Denver, CO", LocationCode.DEN.getLocation());
    }

    @Test
    public void LocationCodeReturnsCorrectNames() {
        assertEquals("Phoenix Sky Harbor International", LocationCode.PHX.getName());
        assertEquals("Washington Dulles International", LocationCode.IAD.getName());
        assertEquals("San Francisco International", LocationCode.SFO.getName());
        assertEquals("Los Angeles International", LocationCode.LAX.getName());
        assertEquals("Minneapolis St. Paul International", LocationCode.MSP.getName());
    }
}