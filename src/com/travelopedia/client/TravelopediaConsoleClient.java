package com.travelopedia.client;

import com.travelopedia.controller.TravelopediaConsole;
import com.travelopedia.model.Airport;

public class TravelopediaConsoleClient {

    public static void main(String[] args) {
        TravelopediaConsole console = new TravelopediaConsole();
        System.out.println("Travelopedia: Go where you want!");
        System.out.println("We currently serve the following locations: ");
        System.out.print("...");
        for (Airport location : Airport.values()) {
            System.out.print(location.getAirportCode() + "...");
        }
        System.out.println("\nWhat would you like to do? Choose from the menu options below.\n\n");
        console.consoleStart();
    }
}