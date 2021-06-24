package com.travelopedia.model.data;

import com.travelopedia.model.Flight;
import com.travelopedia.model.Traveler;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class TravelopediaDataTest extends TestCase {

    public void testGetCustomerList() {
        TravelopediaData database = new TravelopediaData();
        for (Map.Entry<Long, Traveler> entry : database.getCustomerList().entrySet()) {
            System.out.println(entry.getValue().getId() + " " + entry.getValue().getLname());
        }
    }

    public void testGetFlightList() {
    }

    public void testGetTripList() {
    }

    @Test
    public void testWriteFlightData() {
        TravelopediaData database = new TravelopediaData();
        for (Map.Entry<Long, Flight> entry : database.getFlightList().entrySet()) {
            entry.getValue().dumpFlights();
        }
    }

    @Test
    public void testWriteCustomerData() {
        try {
            TravelopediaData database = new TravelopediaData();
            database.writeCustomerData();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}