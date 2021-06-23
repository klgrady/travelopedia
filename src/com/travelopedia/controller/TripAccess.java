package com.travelopedia.controller;

import com.travelopedia.model.Flight;
import com.travelopedia.model.Trip;
import com.travelopedia.model.data.TravelopediaData;

import java.time.LocalDateTime;
import java.util.*;

public class TripAccess {
    private static final int RESULT_LIMIT = 20;

    public static String[][] getAllCustomerTrips(Long customerID) {
        String[][] results = new String[RESULT_LIMIT][2];
        int index = 0;
        Map<Long, Trip> matchingTrips = TravelopediaData.getTripList();
        for (Map.Entry<Long, Trip> tripEntry : matchingTrips.entrySet()) {
            if (tripEntry.getValue().getCustomerId() == customerID) {
                results[index][0] = tripEntry.getValue().getCustomerId().toString();
                Collection<Flight> allFlights = tripEntry.getValue().getFlights();
                for (Flight tripFlight : allFlights) {
                    results[index] = FlightsAccess.pullItinerary(tripFlight.getId());
                }
                index++;
            }
        }
        return results;
    }

    public static Long bookNewTrip(Long customerID, Long[] flightID) {
        List<Long> flightsInTrip = Arrays.asList(flightID);
        return TravelopediaData.recordNewTrip(flightsInTrip, customerID);  // returns TripID as a Long
    }
}