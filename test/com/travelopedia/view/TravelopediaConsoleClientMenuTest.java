package com.travelopedia.view;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class TravelopediaConsoleClientMenuTest {
    Map<String,String> testMap;
    MainMenu menu = new MainMenu();

    @Test
    public void testMainMenuOutputNotNull() {
        menu.setMenuItems();
        Assert.assertNotNull(menu.getMenuItems());
    }

    @Test
    public void testMainMenuOutputIsCorrect() {
        testMap = new LinkedHashMap<>();
        testMap.put("s",  "Search for flights");
        testMap.put("v", "View my trip");
        testMap.put("x", "Exit Travelopedia");
        menu.setMenuItems();
        Assert.assertEquals(testMap, menu.getMenuItems());
    }
}