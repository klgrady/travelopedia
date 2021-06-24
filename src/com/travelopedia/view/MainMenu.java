package com.travelopedia.view;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu extends TravelopediaMenu {

    public MainMenu() {
        menuItems = new LinkedHashMap<>();
        setMenuItems();
    }

    void setMenuItems() {
        menuItems.clear();
        menuItems.put("s", "Search for flights");
        menuItems.put("v", "View my trip");
        menuItems.put("x", "Exit Travelopedia");
    }

    // for testing purposes only
    public Map<String,String> getMenuItems() {
        return menuItems;
    }

    @Override
    public void doMenu() {
        // no-op for main menu
    }
}