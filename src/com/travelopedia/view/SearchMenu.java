package com.travelopedia.view;

import com.travelopedia.controller.FlightsAccess;
import com.travelopedia.controller.TravelerAccess;
import com.travelopedia.controller.TripAccess;
import com.travelopedia.model.Airport;
import com.travelopedia.model.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchMenu extends TravelopediaMenu {

    public SearchMenu() {
        menuItems = new LinkedHashMap<>();
    }

    public void setMenuItems() {
        menuItems.clear();
        menuItems.put("d", "Search by travel date (best results within the next 30 days)");
        menuItems.put("m", "Return to the main menu");
        menuItems.put("x", "Exit Travelopedia");
    }

    public Map<String,String> getMenuItems() {
        return menuItems;
    }

    Map<Long, Flight> callSearch (String input) {
        Map<Long,Flight> results = null;
        try {
            LocalDateTime travelDate = LocalDateTime.parse(input.trim() + "T00:00:00");
            results = FlightsAccess.getListOfFlightsByDate(travelDate);
            if (results == null) {
                System.out.println("There are no matching results for that date.");
            }
        } catch (DateTimeParseException e) {
            System.out.println(input + ": Incorrect date format. Please use YYYY-MM-DD, e.g. 2021-06-02\n> ");
            Scanner sc = new Scanner(System.in);
            callSearch(sc.next());
        }
        return results;
    }

    public void doMenu() {
        setMenuItems();
        displayMenu();
    }

    public void getSearchInfo(String input, Airport depart) {
        String choice = getFlightNumber(input, depart);
        if (choice == null || choice.equals("x") || choice.equals("s")) return;
        Long customerID = TravelerAccess.createCustomer();
        TripAccess.bookNewTrip(customerID, Long.parseLong(choice));
        System.out.println("Enjoy your trip to " + depart.getAirportCity() + "!");
        System.out.println("\n\n");
    }

    public String getDepartureLoc() {
        System.out.println("Choose a departure location from: ");
        for (Airport location : Airport.values()) {
            System.out.println("(" + location.getAirportCode() + ")  " + location.getAirportCity());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("> ");
        return sc.next().toUpperCase();
    }

    private String getFlightNumber(String input, Airport depart) {
        Map<Long,Flight> results = callSearch(input);
        printResults(results, depart);
        System.out.println("Choose a (flight number) to purchase\n> ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        return choice;
    }

    public String getDate() {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your departure date? Please use YYYY-MM-DD format (e.g. 2021-06-02)\n> ");
        input = sc.next();
        return input;
    }

    public void printResults(Map<Long,Flight> flights, Airport depart) {
        for (Map.Entry<Long,Flight> flight : flights.entrySet()) {
            Long key = flight.getKey();
            Flight value = flight.getValue();
            if (value.getDepartureLocation().equals(depart)) {
                System.out.println("(" + key + ")" + "     " + FlightsAccess.getFlightDetails(flight.getValue()));
            }
        }
        System.out.println("(x) to Exit Travelopedia");
    }
}


