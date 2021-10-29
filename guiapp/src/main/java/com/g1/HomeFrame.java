package com.g1;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.FlowLayout;

public class HomeFrame extends JFrame {
    private JLabel heading;
    private JLabel subheading;
    private JLabel selectDepartment;
    private JPanel contentPane;
    private JComboBox dropdownDept;
    private String sem_val = "even";
    private String year_val = "2006";

    private String[] tryoutlist = {"CS", "Elec", "Mech", "Chem", "Meta"};

    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 10, 2000, 1000);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        setContentPane(contentPane);

        heading = new JLabel("Welcome to the Application!");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 96));
        // heading.setBounds(80, 50, 500, 200);
        heading.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(heading);

        subheading = new JLabel("Here you can add course details of " + sem_val + " semester of year " + year_val);
        subheading.setForeground(Color.BLACK);
        subheading.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        // subheading.setBounds(80, 100, 500, 200);
        contentPane.add(subheading);

        selectDepartment = new JLabel("Please select a department");
        selectDepartment.setForeground(Color.BLACK);
        selectDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        // selectDepartment.setBounds(80, 100, 500, 200);
        selectDepartment.setBorder(new EmptyBorder(100, 600, 5, 600));
        contentPane.add(selectDepartment);

        dropdownDept = new JComboBox<>(tryoutlist);
        // dropdownDept.setBounds(70, 200, 200, 100);
        dropdownDept.setBorder(new EmptyBorder(50, 5, 5, 5));
        dropdownDept.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        dropdownDept.setForeground(Color.BLACK);
        dropdownDept.setSize(1000, 100);
        contentPane.add(dropdownDept);
    }
}
