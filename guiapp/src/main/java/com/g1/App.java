package com.g1;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Launches the Login Frame
     * @param args The arguments of the program.
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Unexpected Error Occured!");
                    System.exit(0);
                }
            }
        });
    }
}
