package com.travelopedia.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelerInformation extends JFrame {
    private JPanel panel1;
    private JButton enterButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    public TravelerInformation() {
        setTitle("Travelopedia Booking");
        setContentPane(panel1);
        setVisible(true);
        setSize(400, 400);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.out.println(textField1.getText() + textField2.getText()
                        + textField3.getText() + textField4.getText()
                        + textField5.getText() + textField6.getText()
                        + textField7.getText() + textField8.getText());

            }
        });
    }

    public static void main(String[] args) {
        TravelerInformation passengerInformation = new TravelerInformation();

    }

}
