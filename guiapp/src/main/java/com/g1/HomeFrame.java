package com.g1;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class HomeFrame extends JFrame {
    private JLabel heading;
    private JLabel selectDepartment;
    private JPanel contentPane;
    private JComboBox<String> dropdownDept;
    private JButton proceed;
    private JLabel printmessage;

    private Vector<String> deptnames = new Vector<>();
    private Vector<String> deptids = new Vector<>();

    // public HomeFrame() {
    //     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     setBounds(100, 10, 2000, 1000);
    //     setResizable(true);
    //     contentPane = new JPanel();
    //     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    //     contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
    //     setContentPane(contentPane);

    //     heading = new JLabel("Welcome to the Application!");
    //     heading.setForeground(Color.BLACK);
    //     heading.setFont(new Font("Times New Roman", Font.PLAIN, 96));
    //     // heading.setBounds(80, 50, 500, 200);
    //     heading.setBorder(new EmptyBorder(5, 5, 5, 5));
    //     contentPane.add(heading);

    //     subheading = new JLabel("Here you can add course details of " + sem_val + " semester of year " + year_val);
    //     subheading.setForeground(Color.BLACK);
    //     subheading.setFont(new Font("Times New Roman", Font.PLAIN, 46));
    //     // subheading.setBounds(80, 100, 500, 200);
    //     contentPane.add(subheading);

    //     selectDepartment = new JLabel("Please select a department");
    //     selectDepartment.setForeground(Color.BLACK);
    //     selectDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 46));
    //     // selectDepartment.setBounds(80, 100, 500, 200);
    //     selectDepartment.setBorder(new EmptyBorder(100, 600, 150, 600));
    //     contentPane.add(selectDepartment);

    //     dropdownDept = new JComboBox<>(tryoutlist);
    //     // dropdownDept.setBounds(70, 200, 200, 100);
    //     dropdownDept.setBorder(new EmptyBorder(5, 5, 5, 5));
    //     dropdownDept.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    //     dropdownDept.setForeground(Color.BLACK);
    //     dropdownDept.setSize(1000, 100);
    //     contentPane.add(dropdownDept);

    //     proceed = new JButton("Proceed");
    //     proceed.setBorder(new EmptyBorder(5, 5, 5, 5));
    //     proceed.setFont(new Font("Times New Roman", Font.PLAIN, 46));
    //     proceed.setForeground(Color.BLACK);
    //     proceed.setBackground(contentPane.getBackground());
    //     proceed.setBorderPainted(true);
    //     proceed.setSize(1000, 100);
    //     // proceed.setMnemonic(KeyEvent.VK_A);
    //     contentPane.add(proceed);
    //     // proceed.addActionListener(new ActionListener(){
    //     //     @Override
    //     //     public void actionPerformed(ActionEvent e) {
    //     //         //Make a choice between switching panels and switching frames - whatever is better here.
    //     //         // System.out.println("Pressed");
    //     //         if(printmessage.isVisible()) {
    //     //             printmessage.setVisible(false);
    //     //         } else {
    //     //             printmessage.setText("Button Pressed!");
    //     //             printmessage.setVisible(true);
    //     //         }
    //     //     }        
    //     // });
    //     proceed.setFocusable(false);

    //     printmessage = new JLabel();
    //     printmessage.setForeground(Color.RED);
    //     printmessage.setFont(new Font("Times New Roman", Font.PLAIN, 28));
    //     // subheading.setBounds(80, 100, 500, 200);
    //     printmessage.setVisible(true);
    //     printmessage.setText("MySQL Connection Failed! Please try again later.");
    //     contentPane.add(printmessage);

    // }

    public HomeFrame(SQLConnection sqlConnection) throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // contentPane.scal
        contentPane.setLayout(null);

        // tryoutlist = new String[];
        // Vector<String> depts = new Vector<>();
        ResultSet resultSet = sqlConnection.executeQuery("select * from department");
        while (resultSet.next()) {
            deptnames.add(resultSet.getString("name"));
            deptids.add(resultSet.getString("deptId"));
        }
        // sqlConnection.closeConnection();

        heading = new JLabel("Welcome to the Application!");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        heading.setBounds(100, 13, 1000, 93);
        // heading.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(heading);

        // subheading = new JLabel("Here you can add course details of " + sem_val + " semester of year " + year_val);
        // subheading.setForeground(Color.BLACK);
        // subheading.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        // // subheading.setBounds(80, 100, 500, 200);
        // contentPane.add(subheading);

        selectDepartment = new JLabel("Please select a department");
        selectDepartment.setBackground(Color.BLACK);
        selectDepartment.setForeground(Color.BLACK);
        selectDepartment.setFont(new Font("Tahoma", Font.PLAIN, 31));
        selectDepartment.setBounds(50, 170, 493, 52);
        contentPane.add(selectDepartment);

        dropdownDept = new JComboBox<>(deptnames);
        dropdownDept.setFont(new Font("Tahoma", Font.PLAIN, 32));
        dropdownDept.setBounds(681, 170, 281, 68);
        contentPane.add(dropdownDept);

        proceed = new JButton("Proceed");
        proceed.setFont(new Font("Tahoma", Font.PLAIN, 26));
        proceed.setBounds(345, 392, 162, 73);
        // proceed.setMnemonic(KeyEvent.VK_A);
        contentPane.add(proceed);
        proceed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer index = dropdownDept.getSelectedIndex();
                // EnrollmentFrame frame;
                ClassRoomFrame cframe;
                try {
                    // frame = new EnrollmentFrame(sqlConnection, deptids.get(index));
                    // frame.setVisible(true);
                    cframe = new ClassRoomFrame(sqlConnection, deptids.get(index));
                    cframe.setVisible(true);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Unexpected Error Occured!");
                    System.exit(0);
                }
                setVisible(false);
                dispose();
            }        
        });

        printmessage = new JLabel();
        printmessage.setForeground(Color.RED);
        printmessage.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        printmessage.setBounds(0, 0, 1008, 562);
        contentPane.add(printmessage);

    }
}
