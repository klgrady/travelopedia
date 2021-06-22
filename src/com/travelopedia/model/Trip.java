package com.travelopedia.model;

import java.util.ArrayList;
import java.util.Collection;

public class Trip {
    Long tripId = Long.valueOf(0);
    Collection<Flight> flights;
    // Hotel reservations TBD

    public Trip(long id) {
        setTripId(Long.valueOf(id));
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = Long.valueOf(tripId);
    }

    public Collection<Flight> getFlights() {
        return this.flights;
    }

    public void setFlightIds(Collection<Flight> flightIds) {
        this.flights = flights;
    }
}