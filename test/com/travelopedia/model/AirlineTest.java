package com.travelopedia.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AirlineTest {

    @Test
    public void airlineReturnsCorrectNames() {
        assertEquals("Average Airlines", Airline.AVERAGE.getName());
        assertEquals("Ultimate Airlines", Airline.ULTIMATE.getName());
        assertEquals("Serviceable Airlines", Airline.SERVICEABLE.getName());
        assertEquals("Best Airlines", Airline.BEST.getName());
        assertEquals("CheapSeats Airlines", Airline.CHEAP.getName());
    }

    @Test
    public void airlineReturnsCorrectCodes() {
        assertEquals("AA", Airline.AVERAGE.getCode());
        assertEquals("UA", Airline.ULTIMATE.getCode());
        assertEquals("SA", Airline.SERVICEABLE.getCode());
        assertEquals("BA", Airline.BEST.getCode());
        assertEquals("CA", Airline.CHEAP.getCode());
    }
}