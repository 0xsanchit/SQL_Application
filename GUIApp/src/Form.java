// package BasicForm.src;

// import BasicForm.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JrollnoField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Form extends JFrame {

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
    //                 // HomeFrame frame = new HomeFrame();
    //                 // frame.setVisible(true);
    //                 new Form().setVisible(true);
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    // }

    /**
     * Create the frame.
     */
    public Form() {
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

        JLabel lblname = new JLabel("Name");
        lblname.setBackground(Color.BLACK);
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblname.setBounds(250, 166, 193, 52);
        contentPane.add(lblname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setForeground(Color.BLACK);
        lblrollno.setBackground(Color.CYAN);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblrollno.setBounds(250, 286, 193, 52);
        contentPane.add(lblrollno);

        btnNewButton = new JButton("Enter details");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // do something here :)
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
