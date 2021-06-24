package com.travelopedia.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SearchMenuTest {
    InputStream systemInStash;
    Map<String,String> testMap;
    SearchMenu menu = new SearchMenu();

    @Before
    public void initiate() {
        systemInStash = System.in;
        testMap = new LinkedHashMap<>();
    }

    @Test
    public void testSetMenuItemsReturnToMainMenu() {
        testSearchMenuInput("m");
    }

    @Test
    public void testSetMenuItemsExit() {
        testSearchMenuInput("x");
    }

    @Test(expected = NoSuchElementException.class)
    public void testSetMenuItemsBadInputCreatesError() {
        testSearchMenuInput("f");
    }

    @Test
    public void testMainMenuOutputNotNull() {
        menu.setMenuItems();
        assertNotNull(menu.getMenuItems());
    }

    @Test
    public void testMainMenuOutputIsCorrect() {
        testMap = new LinkedHashMap<>();
        testMap.put("d", "Search by travel date (within the next 30 days)");
        testMap.put("m", "Return to the main menu");
        testMap.put("x", "Exit Travelopedia");
        menu.setMenuItems();
        assertEquals(testMap, menu.getMenuItems());
    }


    private void testSearchMenuInput(String a) {
        ByteArrayInputStream in = new ByteArrayInputStream(a.getBytes());
        System.setIn(in);
        menu.setMenuItems();
        String input = menu.promptForInput();
        assertEquals(a, input);
    }

    @After
    public void cleanUp() {
        System.setIn(systemInStash);
    }
}