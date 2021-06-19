package com.travelopedia.view;

import java.time.LocalDateTime;

public class SearchMenu extends TravelopediaMenu {

    static void setMenuItems() {
        menuItems.clear();
        menuItems.put("d", "Search by travel date (within the next 30 days)");
        menuItems.put("a", "Search by an airline we offer");
        menuItems.put("p", "Search by ticket price range");
        menuItems.put("c", "Find the cheapest flight");
        menuItems.put("m", "Return to the main menu");
    }

    private static void followUpInput(String input) {
        switch (input) {
            case "d":
                generateSearchByDatePrompts();
                break;
            case "a":
                generateSearchByAirlinePrompts();
                break;
            case "p":
                generateSearchByPriceRangePrompts();
                break;
            case "c":
                generateSearchByCheapestFlightPrompts();
                break;
            case "m":
                break;
            default:
                System.out.println("I'm sorry. I didn't understand your request. Please choose a single character from the following menu:");
                promptForInput();
        }
    }

    public static String doSubMenu() {
        setMenuItems();
        displayMenu();
        String input = promptForInput();
        followUpInput(input);
        return input;
    }

    private static void generateSearchByDatePrompts() {
        LocalDateTime preferredDeparture;

    }

    private static void generateSearchByAirlinePrompts() {

    }

    private static void generateSearchByPriceRangePrompts() {
    }

    private static void generateSearchByCheapestFlightPrompts() {
    }
}


