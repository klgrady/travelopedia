package com.travelopedia.view;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class MainMenuTest extends TestCase {
    Map<String,String> testMap;

    @Test
    public void testMainMenuOutputNotNull() {
        MainMenu.setMenuItems();
        assertNotNull(MainMenu.getMenuItems());
    }

    @Test
    public void testMainMenuOutputIsCorrect() {
        testMap = new LinkedHashMap<>();
        testMap.put("s",  "Search for flights");
        testMap.put("v", "View my trip");
        testMap.put("x", "Exit Travelopedia");
        MainMenu.setMenuItems();
        assertEquals(testMap, MainMenu.getMenuItems());
    }
}