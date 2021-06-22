package com.travelopedia.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AirlineTest {

    @Test
    public void airlineReturnsCorrectNames() {
        assertEquals("Average Airlines", Airline.AA.getName());
        assertEquals("Ultimate Airlines", Airline.UA.getName());
        assertEquals("Serviceable Airlines", Airline.SA.getName());
        assertEquals("Best Airlines", Airline.BA.getName());
        assertEquals("CheapSeats Airlines", Airline.CA.getName());
    }

    @Test
    public void airlineReturnsCorrectCodes() {
        assertEquals("AA", Airline.AA.getCode());
        assertEquals("UA", Airline.UA.getCode());
        assertEquals("SA", Airline.SA.getCode());
        assertEquals("BA", Airline.BA.getCode());
        assertEquals("CA", Airline.CA.getCode());
    }
}