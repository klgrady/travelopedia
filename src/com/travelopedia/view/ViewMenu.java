package com.travelopedia.view;

import com.travelopedia.model.Flight;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ViewMenu extends TravelopediaMenu {

    public ViewMenu() {
        menuItems = new LinkedHashMap<>();
    }

    void setMenuItems() {
        menuItems.clear();
        menuItems.put("e", "Locate all flights associated with your email address");
        menuItems.put("i", "View a flight's full itinerary");
        menuItems.put("m", "Return to the main menu");
        menuItems.put("x", "Exit Travelopedia");
    }

    public void doMenu() {
        setMenuItems();
        displayMenu();
    }

    public Long chooseFlight(List<Flight> flights) {
        Long result = 0L;
        if (flights.isEmpty()) {
            return result;
        }
        System.out.println("Enter the (Flight ID) to see the flight's itinerary:");
        for (Flight flight : flights) {
            System.out.println("Flight (" + flight.getId() + ") Departing " + flight.getDepartureDate() + " on " + flight.getDepartureLocation());
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        result = Long.parseLong(sc.next());
        return result;
    }

    public void promptForItinerary() {
        System.out.println("What is the flight number?");
        System.out.print("> ");
    }
}