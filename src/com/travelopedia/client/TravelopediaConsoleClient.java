package com.travelopedia.client;

import com.apps.util.SplashApp;
import com.travelopedia.controller.TravelopediaConsole;
import com.travelopedia.model.Airport;

public class TravelopediaConsoleClient implements SplashApp {

    public static void main(String[] args) {
        TravelopediaConsoleClient client = new TravelopediaConsoleClient();
        // client.welcome("img/travelopedia-logo.png");
        client.start();
    }

    @Override
    public void start() {
        TravelopediaConsole console = new TravelopediaConsole();
        System.out.println("T R A V E L O P E D I A: Go where you want!");
        System.out.println("We currently serve the following locations: ");
        System.out.print("...");
        for (Airport location : Airport.values()) {
            System.out.print(location.getAirportCode() + "...");
        }
        System.out.println("\nWhat would you like to do? Choose from the menu options below.\n\n");
        console.consoleStart();
    }

}