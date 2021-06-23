package com.travelopedia.view;

import javax.swing.*;
import java.awt.*;

public class TicketSelection extends JPanel{
    private JButton bookButton;
    private JButton cancelButton;
    private JTable table1;

    public TicketSelection(){
        super(new BorderLayout());

        String[] columnNames = {"Flight" , "Departure", "Destination", "Departure Time", "Arrival Time", "Tickets Available"};
        String[][] tableData = {{"AA123","Miami","New York", "0500 am", "1000 pm", "3"},
                {"AA123","Miami","New York", "0500 am", "1000 pm", "3"},
                {"AA123","Miami","New York", "0500 am", "1000 pm", "3"},
                {"AA123","Miami","New York", "0500 am", "1000 pm", "3"},
                {"AA123","Miami","New York", "0500 am", "1000 pm", "3"}};

        table1 = new JTable(tableData, columnNames);
        display();
    }

    private void display() {
        JFrame f = new JFrame("ListPanel");
        f.setTitle("Flight Selection");
        f.setPreferredSize(new Dimension(600,400));
        //f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel topPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(table1);
        topPanel.add(scrollPane);
        topPanel.setSize(750,275);
        JPanel bottomPanel = new JPanel();
        bookButton = new JButton("Book");
        bottomPanel.add(bookButton);
        jSplitPane.setTopComponent(topPanel);
        jSplitPane.setBottomComponent(bottomPanel);
        jSplitPane.setSize(1000,1000);
        f.add(jSplitPane);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    /*public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TicketSelection().display();
            }
        });

    }*/
}
