package com.g1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

    Connection connection;

    SQLConnection() {
        connection = null;
    }

    public boolean connect(String username, String password) {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/academic_insti", username, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            // System.out.println("Query Failed");
            return false;
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Query Failed: " + query);
            return null;
        }
    }

    public boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}