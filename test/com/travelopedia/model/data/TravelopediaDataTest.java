package com.travelopedia.model.data;

import com.travelopedia.model.Traveler;
import junit.framework.TestCase;

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
}