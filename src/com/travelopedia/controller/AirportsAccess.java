package com.travelopedia.controller;

import com.travelopedia.model.Airport;

public class AirportsAccess {

    public static String[] getAirportLocations() {
        Airport[] locations = Airport.class.getEnumConstants();
        String[] result = new String[14];
        int i = 0;
        for (Airport location : locations) {
            result[i++] = location.toString();
        }
        return result;
    }

}