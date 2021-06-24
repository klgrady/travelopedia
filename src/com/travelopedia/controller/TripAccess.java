package com.travelopedia.controller;

import com.travelopedia.model.Flight;
import com.travelopedia.model.Trip;
import com.travelopedia.model.data.TravelopediaData;

import java.util.*;

public class TripAccess {
    private static final int RESULT_LIMIT = 20;
    private static TravelopediaData database = new TravelopediaData();

    public static List<Flight> getAllCustomerTripsList(Long customerID) {
        List<Flight> results = new ArrayList<>();
        Map<Long, Trip> matchingTrips = database.getTripList();
        for (Map.Entry<Long, Trip> tripEntry : matchingTrips.entrySet()) {
            if (tripEntry.getValue().getCustomerId().equals(customerID)) {
                Collection<Flight> allFlights = tripEntry.getValue().getFlights();
                for (Flight flight : allFlights) {
                    results.add(flight);
                }
            }
        }
        return results;
    }
    public static String[][] getAllCustomerTrips(Long customerID) {
        String[][] results = new String[RESULT_LIMIT][2];
        int index = 0;
        Map<Long, Trip> matchingTrips = database.getTripList();
        for (Map.Entry<Long, Trip> tripEntry : matchingTrips.entrySet()) {
            if (tripEntry.getValue().getCustomerId().equals(customerID)) {
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

    public static Long bookNewTrip(Long customerID, Long flightID) {
        return database.recordNewTrip(flightID, customerID);  // returns TripID as a Long
    }
}