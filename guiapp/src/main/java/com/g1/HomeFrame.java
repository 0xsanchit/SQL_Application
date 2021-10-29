package com.g1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class HomeFrame extends JFrame {
    private JLabel heading;
    private JLabel subheading;
    private JLabel selectDepartment;
    private JPanel contentPane;
    private String sem_val = "even";
    private String year_val = "2006";

    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 10, 2000, 1000);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        heading = new JLabel("Welcome to the Application!");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 96));
        heading.setBounds(80, 50, 500, 200);
        heading.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(heading);

        subheading = new JLabel("Here you can add course details of " + sem_val + " semester of year " + year_val);
        subheading.setForeground(Color.BLACK);
        subheading.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        subheading.setBounds(80, 100, 500, 200);
        contentPane.add(subheading);

        selectDepartment = new JLabel("Please select a department");
        selectDepartment.setForeground(Color.BLACK);
        selectDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        selectDepartment.setBounds(80, 100, 500, 200);
        selectDepartment.setBorder(new EmptyBorder(100, 5, 5, 5));
        contentPane.add(selectDepartment);
    }
}
