package com.g1;

import java.sql.ResultSet;

public class App1 {
    public static void main(String[] args) throws Exception {
        SQLConnection sqlConnection = new SQLConnection();
        boolean status = sqlConnection.connect("<YOURUSERNAME>", "<YOURPASSWORD>");
        if (status == true) {
            ResultSet resultSet = sqlConnection.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            sqlConnection.closeConnection();
        } else {
            System.out.println("Connection Failed");
        }

    }
}
