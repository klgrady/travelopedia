package com.travelopedia.controller;

import com.travelopedia.model.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportsAccess {

    public static List<String> getAirportLocations() {
        Airport[] locations = Airport.class.getEnumConstants();
        List<String> result = new ArrayList<>();
        int i = 0;
        for (Airport location : locations) {
            result.add(location.getAirportCode());
        }
        return result;
    }

}