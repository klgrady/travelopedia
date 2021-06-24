package com.travelopedia.model.data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBC {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelopediamysql",
                    "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from flights");


            while (resultSet.next()) {
                System.out.println(resultSet.getString("airlineID"));

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
