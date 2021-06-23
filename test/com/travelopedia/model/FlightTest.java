package com.travelopedia.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FlightTest {
    public Flight flight1;
    public Map<LocalDateTime, List<String>> itinerary;

    @Before
    public void initialize() {
        flight1 = new Flight();
        flight1.addLeg(
                1L,
                LocalDateTime.of(2021, Month.MAY, 20, 17, 50),
                Airport.DEN,
                LocalDateTime.of(2021, Month.MAY, 20, 22, 15),
                Airport.CLE, Airline.SA,
                349.0,
                500,
                400,
                100);
        flight1.addLeg(
                2L,
                LocalDateTime.of(2021, Month.MAY, 22, 9, 15),
                Airport.CLE,
                LocalDateTime.of(2021, Month.MAY, 22, 14, 0),
                Airport.DEN,
                Airline.SA,
                150.0,
                400,
                200,
                200
        );

        itinerary = new TreeMap<>();
        List<String> leg1 = new ArrayList<>();
        List<String> leg2 = new ArrayList<>();

        leg1.add("1");
        leg1.add("2021-05-20T17:50");
        leg1.add("Denver International");
        leg1.add("2021-05-20T22:15");
        leg1.add("Cleveland Hopkins International");
        leg1.add("Serviceable Airlines");
        leg1.add("349.0");
        leg1.add("500");
        leg1.add("400");
        leg1.add("100");

        leg2.add("2");
        leg2.add("2021-05-22T09:15");
        leg2.add("Cleveland Hopkins International");
        leg2.add("2021-05-22T14:00");
        leg2.add("Denver International");
        leg2.add("Serviceable Airlines");
        leg2.add("150.0");
        leg2.add("400");
        leg2.add("200");
        leg2.add("200");


        itinerary.put(LocalDateTime.of(2021, Month.MAY, 20, 17, 50), leg1);
        itinerary.put(LocalDateTime.of(2021, Month.MAY, 22, 9, 15), leg2);
    }

    @Test
    public void flightContainsCorrectLegs() {
        assertEquals(itinerary, flight1.getItinerary());
    }
}