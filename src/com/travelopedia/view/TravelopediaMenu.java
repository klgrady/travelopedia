package com.travelopedia.view;

import java.util.*;

public class TravelopediaMenu {
    static Map<String,String> menuItems = new LinkedHashMap<>();
    static String prompt = "Your choice: ";
    static final String errorMessage = "I'm sorry. I didn't understand your request. Please choose a single character from the following menu:";

    static String getPrompt() {
        return prompt;
    }

    public static void displayMenu() {
        for (Map.Entry<String,String> entry : menuItems.entrySet()) {
            System.out.println("(" + entry.getKey() + ")" + " " + entry.getValue());
        }
        System.out.println("\n\n");
    }


    public static String promptForInput() {
        String input = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(getPrompt());
        try {
            input = sc.next();
            if (!menuItems.containsKey(input.toLowerCase())) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println(errorMessage);
            promptForInput();
        }
        return input;
    }
}
