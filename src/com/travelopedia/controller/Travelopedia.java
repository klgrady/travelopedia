package com.travelopedia.controller;

import com.travelopedia.view.MainMenu;
import com.travelopedia.view.SearchMenu;
import com.travelopedia.view.ViewMenu;

import javax.swing.*;


public class Travelopedia {

    public static void main(String[] args) {
        // consoleStart();
        int newTicket;
        do {

             newTicket =  JOptionPane.showConfirmDialog(null,
                    "Would you like to schedule another flight?", "Travelopedia", JOptionPane.YES_NO_OPTION);
             if(newTicket != 0) JOptionPane.showMessageDialog(null,"Thank you for booking with us!"
                                                        ,"Travelopedia"
                                                        ,JOptionPane.PLAIN_MESSAGE
                                                        ,new ImageIcon("src/images/niceday.jpg"));
        }while(newTicket == 0);
    }

/*    private static void consoleStart() {
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
    }*/

}