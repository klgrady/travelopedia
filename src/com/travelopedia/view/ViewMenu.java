package com.travelopedia.view;

public class ViewMenu extends TravelopediaMenu {

    static void setMenuItems() {
        menuItems.clear();
        menuItems.put("e", "Locate all flights associated with your email address");
        menuItems.put("i", "Locate a flight by Flight ID");
        menuItems.put("m", "Return to the main menu");
        menuItems.put("x", "Exit Travelopedia");
    }

    public static String doSubMenu() {
        setMenuItems();
        displayMenu();
        return promptForInput();
    }
}