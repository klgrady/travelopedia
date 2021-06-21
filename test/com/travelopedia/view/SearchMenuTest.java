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

    @Before
    public void initiate() {
        systemInStash = System.in;
        testMap = new LinkedHashMap<>();
    }

    @Test
    public void testSubMenuItemsSearchByDate() {
        testDoSubMenu("d");
    }

    @Test
    public void testSubMenuItemsSearchByAirline() {
        testDoSubMenu("a");
    }

    @Test
    public void testSubMenuItemsSearchByPrice() {
        testDoSubMenu("p");
    }

    @Test
    public void testSubMenuItemsSearchByCheapest() {
        testDoSubMenu("c");
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
    public void testSubMenuNoSystemExitExpectsError() {
        testDoSubMenu("x");
    }

    @Test(expected = NoSuchElementException.class)
    public void testSetMenuItemsBadInputCreatesError() {
        testSearchMenuInput("f");
    }

    @Test
    public void testSubMenuOptions() {
        testDoSubMenu("m");
    }

    @Test(expected = NoSuchElementException.class)
    public void testSubMenuOptionNotAvailableCreatesError() {
        testDoSubMenu("1");
    }

    @Test
    public void testMainMenuOutputNotNull() {
        MainMenu.setMenuItems();
        assertNotNull(MainMenu.getMenuItems());
    }

    @Test
    public void testMainMenuOutputIsCorrect() {
        testMap = new LinkedHashMap<>();
        testMap.put("d", "Search by travel date (within the next 30 days)");
        testMap.put("a", "Search by an airline we offer");
        testMap.put("p", "Search by ticket price range");
        testMap.put("c", "Find the cheapest flight");
        testMap.put("m", "Return to the main menu");
        testMap.put("x", "Exit Travelopedia");
        SearchMenu.setMenuItems();
        assertEquals(testMap, MainMenu.getMenuItems());
    }

    private void testDoSubMenu(String a) {
        ByteArrayInputStream in = new ByteArrayInputStream(a.getBytes());
        System.setIn(in);
        String input = SearchMenu.doSubMenu();
        assertEquals(a, input);
    }

    private void testSearchMenuInput(String a) {
        ByteArrayInputStream in = new ByteArrayInputStream(a.getBytes());
        System.setIn(in);
        SearchMenu.setMenuItems();
        String input = SearchMenu.promptForInput();
        assertEquals(a, input);
    }

    @After
    public void cleanUp() {
        System.setIn(systemInStash);
    }
}