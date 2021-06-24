package com.travelopedia.view;

import java.util.*;

public abstract class TravelopediaMenu {
    static final String errorMessage = "I'm sorry. I didn't understand your request. Please choose a single character from the following menu:";
    Map<String,String> menuItems;
    String prompt = "Your choice: ";


    public String getPrompt() {
        return prompt;
    }

    public void displayMenu() {
        for (Map.Entry<String,String> entry : menuItems.entrySet()) {
            System.out.println("(" + entry.getKey() + ")" + " " + entry.getValue());
        }
        System.out.println("\n\n");
    }


    public String promptForInput() {
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

    public abstract void doMenu();
}
