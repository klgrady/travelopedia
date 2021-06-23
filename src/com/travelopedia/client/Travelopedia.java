package com.travelopedia.client;

import com.travelopedia.view.*;
import com.travelopedia.view.TicketWindowFactory;

import javax.swing.*;
import java.awt.*;


public class Travelopedia {

    public static void main(String[] args) {
        int newTicket;
        do {
             TicketWindow ticketWindow = TicketWindowFactory.createTicketWindow();
             newTicket =  JOptionPane.showConfirmDialog(null,
                    "Would you like to schedule another flight?", "Travelopedia", JOptionPane.YES_NO_OPTION);
             if(newTicket != 0) JOptionPane.showMessageDialog(null,"Thank you for booking with us!"
                     ,"Travelopedia"
                     ,JOptionPane.PLAIN_MESSAGE
                     ,new ImageIcon(new ImageIcon("src/images/travelopedia.png")
                             .getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH)));
        }while(newTicket == 0);
    }



}