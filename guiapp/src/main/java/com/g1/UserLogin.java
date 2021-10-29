package com.g1;

// package BasicForm.src;

// import BasicForm.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField rollnoField;
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
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // contentPane.scal
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Form! Duh");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        nameField.setBounds(481, 170, 281, 68);
        contentPane.add(nameField);
        nameField.setColumns(10);

        rollnoField = new JTextField();
        rollnoField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        rollnoField.setBounds(481, 286, 281, 68);
        contentPane.add(rollnoField);

        JLabel lblUsername = new JLabel("Name");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 170, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Roll Number");
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
                // String userName = nameField.getText();
                // String password = rollnoField.getText();
                // try {
                //     Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                //         "root", "root");

                //     PreparedStatement st = (PreparedStatement) connection
                //         .prepareStatement("Select name, password from student where name=? and password=?");

                //     st.setString(1, userName);
                //     st.setString(2, password);
                //     ResultSet rs = st.executeQuery();
                //     if (rs.next()) {
                //         dispose();
                //         UserHome ah = new UserHome(userName);
                //         ah.setTitle("Welcome");
                //         ah.setVisible(true);
                //         JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                //     } else {
                //         JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                //     }
                // } catch (SQLException sqlException) {
                //     sqlException.printStackTrace();
                // }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
