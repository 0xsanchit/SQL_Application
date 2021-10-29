package com.g1;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentFrame extends JFrame {
    private JLabel heading;
    private JLabel l1, l2;
    private JTextField rollnoField;
    private JComboBox courseField;
    private JPanel contentPane;
    private String deptname;
    private String deptid;
    public EnrollmentFrame(SQLConnection sqlConnection, String depid) throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 10, 2000, 1000);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);
        this.deptid = depid;

        heading = new JLabel();
        heading.setFont(new Font("Times New Roman", Font.BOLD, 96));
        heading.setBorder(new EmptyBorder(5, 200, 5, 200));
        contentPane.add(heading);
        try {
            ResultSet resultSet = sqlConnection.executeQuery("select name from department d where d.deptId = "+depid);
            while(resultSet.next()) {
                deptname = resultSet.getString("name");
                // break;
            }
            heading.setText("Department of " + deptname);
        } catch (Exception e) {
            e.printStackTrace();
            setVisible(false);
            // UserLogin frame = new UserLogin();
            // frame.setVisible(true);
            JOptionPane.showMessageDialog(null, "MySQL Connection Failed!");
            // dispose();
            System.exit(0);
        }

        l1 = new JLabel("Enter a roll number");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        l1.setBorder(new EmptyBorder(5, 5, 50, 5));
        contentPane.add(l1);

        l2 = new JLabel("Select a course");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 40));
        l2.setBorder(new EmptyBorder(5, 5, 50, 5));
        contentPane.add(l2);
    }
}
