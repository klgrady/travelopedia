package com.travelopedia.view;

public class ViewMenu extends TravelopediaMenu {

    public ViewMenu() {
        setMenuItems();
    }

    static void setMenuItems() {
        menuItems.clear();
        menuItems.put("e", "Locate all flights associated with your email address");
        menuItems.put("a", "Locate a flight by Flight ID");
        menuItems.put("x", "Return to the main menu");
    }

    public static void displayMenu() {

    }

    public static String doSubMenu() {
        displayMenu();
        return promptForInput();
    }
}