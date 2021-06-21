package com.travelopedia.view;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class MainMenuTest {
    Map<String,String> testMap;

    @Test
    public void testMainMenuOutputNotNull() {
        MainMenu.setMenuItems();
        Assert.assertNotNull(MainMenu.getMenuItems());
    }

    @Test
    public void testMainMenuOutputIsCorrect() {
        testMap = new LinkedHashMap<>();
        testMap.put("s",  "Search for flights");
        testMap.put("v", "View my trip");
        testMap.put("x", "Exit Travelopedia");
        MainMenu.setMenuItems();
        Assert.assertEquals(testMap, MainMenu.getMenuItems());
    }
}