package com.g1;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Color;

public class EnrollmentFrame extends JFrame {
    // private JLabel l1, l2;
    private JTextField rollnoField;
    private JComboBox<String> courseField;
    private JPanel contentPane;
    private String deptname;
    private JButton process;
    private JButton back;

    private Vector<String> cids = new Vector<>();
    private Vector<String> cnames = new Vector<>();
    public EnrollmentFrame(SQLConnection sqlConnection, String depid) throws SQLException {

        try {
            ResultSet resultSet = sqlConnection.executeQuery("select name from department d where d.deptId = "+depid);
            while(resultSet.next()) {
                deptname = resultSet.getString("name");
                // break;
            }

            resultSet = sqlConnection.executeQuery("select * from course c where c.deptNo = " + depid + " and exists (select * from teaching t where t.sem = 'even' and t.year = 2006 and t.courseId = c.courseId)");
            while(resultSet.next()) {
                cids.add(resultSet.getString("courseId"));
                cnames.add(resultSet.getString("cname"));
            }
        } catch (Exception e) {
            setVisible(false);
            // UserLogin frame = new UserLogin();
            // frame.setVisible(true);
            JOptionPane.showMessageDialog(null, "MySQL Connection Failed!");
            // dispose();
            System.exit(0);
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // contentPane.scal
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Department of " + deptname);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(100, 13, 1000, 93);
        contentPane.add(lblNewLabel);

        rollnoField = new JTextField();
        rollnoField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        rollnoField.setBounds(481, 170, 281, 68);
        contentPane.add(rollnoField);
        rollnoField.setColumns(10);

        courseField= new JComboBox<>(cnames);
        courseField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        courseField.setBounds(481, 286, 281, 68);
        contentPane.add(courseField);
        // courseField.se

        JLabel lblUseruserName = new JLabel("Roll Number");
        lblUseruserName.setBackground(Color.BLACK);
        lblUseruserName.setForeground(Color.BLACK);
        lblUseruserName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUseruserName.setBounds(150, 170, 293, 52);
        contentPane.add(lblUseruserName);

        JLabel lblPassword = new JLabel("Select Course");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(150, 286, 293, 52);
        contentPane.add(lblPassword);

        process = new JButton("Process");
        process.setFont(new Font("Tahoma", Font.PLAIN, 26));
        process.setBounds(545, 392, 162, 73);
        process.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Do something
                String rno = rollnoField.getText();
                Integer index = courseField.getSelectedIndex();
                String cid = cids.get(index);
                try {
                    String result = Query2.makeEnrollment(sqlConnection, rno, cid);
                    JOptionPane.showMessageDialog(null, result);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "MySQL Connection Failed!");
                    System.exit(0);
                }
                rollnoField.setText("");
            }
        });

        contentPane.add(process);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 26));
        back.setBounds(245, 392, 162, 73);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Do something : navigate back
                try {
                    HomeFrame frame = new HomeFrame(sqlConnection);
                    setVisible(false);
                    frame.setVisible(true);
                    dispose();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Unexpected Error Occured!");
                    System.exit(0);
                }
                
            }
        });

        contentPane.add(back);

        // label = new JLabel("");
        // label.setBounds(0, 0, 1008, 562);
        // contentPane.add(label);
    }
}
