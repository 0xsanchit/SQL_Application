package com.g1;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        boolean status = false;
        try {
            status = sqlConnection.connect("<YOURUSERNAME>", "<YOURPASSWORD>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (status == true) {
            ResultSet resultSet = sqlConnection.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            sqlConnection.closeConnection();
        } else {
            System.out.println("Connection Failed");
        }
        if(status)
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // UserLogin frame = new UserLogin();
                    HomeFrame frame;
                    frame = new HomeFrame(sqlConnection);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        else
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // UserLogin frame = new UserLogin();
                    HomeFrame frame;
                    frame = new HomeFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
