package com.travelopedia.controller;

import com.travelopedia.view.MainMenu;
import com.travelopedia.view.SearchMenu;
import com.travelopedia.view.ViewMenu;


public class Travelopedia {

    public static void main(String[] args) {
        String choice = getMainMenuOptions();
        while (!choice.toLowerCase().equals("x")) {
            switch (choice.toLowerCase()) {
                case "s":
                    choice = SearchMenu.doSubMenu();
                    break;
                case "v":
                    choice = ViewMenu.doSubMenu();
                    break;
                default:
                    choice = getMainMenuOptions();
            }
            System.out.println();
        }
        System.out.println("Thank you for traveling with Travelopedia!");
    }

    private static String getMainMenuOptions() {
        String choice;
        MainMenu.setMenuItems();
        MainMenu.displayMenu();
        choice = MainMenu.promptForInput();
        return choice;
    }

}