package com.travelopedia.view;

public class TicketWindowFactory {
    TicketWindow window = null;
    TicketConfirmation  ticketConfirmation = null;



    public TicketWindowFactory(){}

    public static TicketWindow createTicketWindow(){
        return new TicketWindow();
    }

    public static TicketConfirmation createTicketConfirmationWindow(){
        return new TicketConfirmation();
    }

    public static TicketSelection createTicketSelectionWindow(){
        return new TicketSelection();
    }

}
