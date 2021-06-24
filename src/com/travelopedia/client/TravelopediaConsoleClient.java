package com.travelopedia.client;

import com.travelopedia.controller.AirportsAccess;
import com.travelopedia.controller.TravelopediaConsole;

public class TravelopediaConsoleClient {

    public static void main(String[] args) {
        TravelopediaConsoleClient client = new TravelopediaConsoleClient();
        // client.welcome("img/travelopedia-logo.png");
        client.start();
    }

    public void start() {
        TravelopediaConsole console = new TravelopediaConsole();
        System.out.println("T R A V E L O P E D I A: Go where you want!");
        System.out.println("We currently serve the following locations: ");
        System.out.print("...");
        for (String location : AirportsAccess.getAirportLocations()) {
            System.out.print(location + "...");
        }
        System.out.println("\nWhat would you like to do? Choose from the menu options below.\n\n");
        console.consoleStart();
    }

}