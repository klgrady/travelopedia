package com.travelopedia.controller;

import com.travelopedia.model.Flight;
import com.travelopedia.model.data.TravelopediaData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightsAccess {

    private static final int RESULTS_LIMIT = 20;

    public static String[][] getFlightsByDate(int year, int month, int day) {
        return matchingResults(LocalDateTime.of(year, month, day, 0, 0));
    }

    public static Map<Long, Flight> getListOfFlightsByDate(LocalDateTime travelDate) {
        return matchingResultsMap(travelDate);
    }

    public static String getFlightDetails(Flight flight) {
        return flight.returnFlightInfo();
    }

    public static String[] pullItinerary(Long flightID) {
        String[] results = new String[RESULTS_LIMIT];
        int i = 0;
        Map<Long, Flight> allFlights = new TravelopediaData().getFlightList();
        Map<LocalDateTime, List<String>> matchingFlights = allFlights.get(flightID).getItinerary();
        for (Map.Entry<LocalDateTime, List<String>> entry : matchingFlights.entrySet()) {
            for (String leg : entry.getValue()) {
                results[i++] = leg;
            }
        }
        return results;
    }

    public static String getPrintableItinerary(Long flightID) {
        Flight flight = new TravelopediaData().getFlightList().get(flightID);
        return flight.returnFlightInfo();
    }

    private static String[][] matchingResults(LocalDateTime flightDate) {
        String[][] results = new String[RESULTS_LIMIT][8];
        Map<Long, Flight> allFlights = new TravelopediaData().getFlightList();
        int index = 0;
        for (Map.Entry flightEntry : allFlights.entrySet()) {
            Flight flight = (Flight) flightEntry.getValue();
            if (flight.getDepartureDate().equals(flightDate)) {
                results[index++] = flightToString(flight);
            }
        }
        return results;
    }

    private static Map<Long, Flight> matchingResultsMap(LocalDateTime flightDate) {
        TravelopediaData database = new TravelopediaData();
        Map<Long,Flight> results = database.getFlightList();
        Map<Long,Flight> prunedResults = new HashMap<>();
        for (Map.Entry<Long,Flight> entry : results.entrySet()) {
            if (entry.getValue().getDepartureDate().getYear() == flightDate.getYear() &&
            entry.getValue().getDepartureDate().getMonthValue() == flightDate.getMonthValue()) {
                int departureDay = entry.getValue().getDepartureDate().getDayOfMonth();
                int flightDay = flightDate.getDayOfMonth();
                if (Math.abs(departureDay - flightDay) < 7) {
                    prunedResults.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return prunedResults;
    }

    private static String[] flightToString(Flight flight) {
        String[] returnElement = new String[9];
        Map<LocalDateTime, List<String>> flightMap = flight.getItinerary();
        for (Map.Entry<LocalDateTime, List<String>> mappedFlight : flightMap.entrySet()) {
            for (String individualFlight : mappedFlight.getValue()) {
                if (isSeatAvailable(individualFlight)) {   // there are seats available
                    returnElement = individualFlight.split(",");
                }
            }
        }
        return returnElement;
    }

    private static boolean isSeatAvailable(String line) {
        return !line.endsWith("0");
    }
}