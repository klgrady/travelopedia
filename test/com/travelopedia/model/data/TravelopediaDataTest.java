package com.travelopedia.model.data;

import com.travelopedia.controller.Travelopedia;
import com.travelopedia.model.Flight;
import com.travelopedia.model.Traveler;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class TravelopediaDataTest extends TestCase {

    public void testGetCustomerList() {
        try {
            TravelopediaData database = new TravelopediaData();
            for (Map.Entry<Long, Traveler> entry : database.getCustomerList().entrySet()) {
                System.out.println(entry.getValue().getId() + " " + entry.getValue().getLname());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void testGetFlightList() {
    }

    public void testGetTripList() {
    }

    @Test
    public void testWriteFlightData() {
        try {
            TravelopediaData database = new TravelopediaData();
            for (Map.Entry<Long, Flight> entry : database.getFlightList().entrySet()) {
                entry.getValue().dumpFlights();
            }
        } catch (IOException e) {
            System.out.println(e);
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