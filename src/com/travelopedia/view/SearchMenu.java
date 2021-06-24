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
            System.out.println(input + ": Incorrect date format. Please use YYYY-MM-DD, e.g. 2021-06-02");
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            callSearch(sc.next());
        }
        return results;
    }

    public void doMenu() {
        setMenuItems();
        displayMenu();
    }

    public String reRunSearch(Airport depart) {
        String input = getDate();
        getSearchInfo(input, depart);
        Scanner sc = new Scanner(System.in);
        if (sc.equals("x")) {
            return "";
        }
        return getFlightNumber(input, depart);
    }

    public void getSearchInfo(String input, Airport depart) {
        String choice = getFlightNumber(input, depart);
        if (choice.equals("d")) {
            choice = reRunSearch(depart);
        }
        if (choice == null || choice.equals("") || choice.equals("x") || choice.equals("s")) return;
        Long customerID = TravelerAccess.createCustomer();
        TripAccess.bookNewTrip(customerID, Long.parseLong(choice));
        System.out.println("Enjoy your trip to " + depart.getAirportCity() + "!");
    }

    public String getDepartureLoc() {
        System.out.println("Choose a departure location from: ");
        for (Airport location : Airport.values()) {
            System.out.println("(" + location.getAirportCode() + ")  " + location.getAirportCity());
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        return sc.next().toUpperCase();
    }

    private String getFlightNumber(String input, Airport depart) {
        Map<Long,Flight> results = callSearch(input);
        String choice = "";
        if (!(results == null) && !results.isEmpty()) {
            printResults(results, depart);
            System.out.println("Choose a (flight number) to purchase");
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            choice = sc.next();
        } else {
            System.out.println("Looks like we don't have any flights around that date. Please try a date within the next 30 days.");
            choice = "d";
        }
        return choice;
    }

    public String getDate() {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your departure date? Please use YYYY-MM-DD format (e.g. 2021-06-02)");
        System.out.print("> ");
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


