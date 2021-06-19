package com.travelopedia.view;

import java.util.Map;

public class MainMenu extends TravelopediaMenu {

    public static void setMenuItems() {
        menuItems.clear();
        menuItems.put("s", "Search for flights");
        menuItems.put("v", "View my trip");
        menuItems.put("x", "Exit Travelopedia");
    }

    // for testing purposes only
    static Map<String,String> getMenuItems() {
        return menuItems;
    }
}