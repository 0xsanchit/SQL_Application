package com.g1;

// package BasicForm.src;

// import BasicForm.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    // public static void main(String[] args) {
    //     EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             try {
    //                 UserLogin frame = new UserLogin();
    //                 frame.setVisible(true);
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    // }

    /**
     * Create the frame.
     */
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // contentPane.scal
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("User Login: enter your MySQL creds");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(100, 13, 1000, 93);
        contentPane.add(lblNewLabel);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        userNameField.setBounds(481, 170, 281, 68);
        contentPane.add(userNameField);
        userNameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUseruserName = new JLabel("userName");
        lblUseruserName.setBackground(Color.BLACK);
        lblUseruserName.setForeground(Color.BLACK);
        lblUseruserName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUseruserName.setBounds(250, 170, 193, 52);
        contentPane.add(lblUseruserName);

        JLabel lblPassword = new JLabel("password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String useruserName = userNameField.getText();
                // String password = passwordField.getPassword().toString();
                String password = passwordField.getText();
                System.out.println("User: " + useruserName + " \nPassword: " + password + " \n");
                // try {
                //     Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                //         "root", "root");

                //     PreparedStatement st = (PreparedStatement) connection
                //         .prepareStatement("Select userName, password from student where userName=? and password=?");

                //     st.setString(1, useruserName);
                //     st.setString(2, password);
                //     ResultSet rs = st.executeQuery();
                //     if (rs.next()) {
                //         dispose();
                //         UserHome ah = new UserHome(useruserName);
                //         ah.setTitle("Welcome");
                //         ah.setVisible(true);
                //         JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                //     } else {
                //         JOptionPane.showMessageDialog(btnNewButton, "Wrong UseruserName & Password");
                //     }
                // } catch (SQLException sqlException) {
                //     sqlException.printStackTrace();
                // }
                SQLConnection sqlConnection = new SQLConnection();
                boolean status = sqlConnection.connect(useruserName, password);
                if (status == true) {
                    ResultSet resultSet = sqlConnection.executeQuery("select * from student");
                    try {
                        while (resultSet.next()) {
                            System.out.println(resultSet.getString("name"));
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    // sqlConnection.closeConnection();
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
                            setVisible(false);
                            frame.setVisible(true);
                            dispose();
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
                            setVisible(false);
                            frame.setVisible(true);
                            dispose();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
