package com.g1;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Color;

public class ClassRoomFrame extends JFrame{
    private JComboBox<String> courseField;
    private JComboBox<String> teacherField;
    private JTextField classRoomField;
    private JPanel contentPane;
    private String deptname;
    private String deptid;
    private JButton process;
    private JButton back;

    private Vector<String> cids = new Vector<>();
    private Vector<String> cnames = new Vector<>();

    private Vector<String> tids = new Vector<>();
    private Vector<String> tnames = new Vector<>();

    public ClassRoomFrame(SQLConnection sqlConnection, String deptid) throws SQLException {
        this.deptid = deptid;

        try{
            ResultSet resultSet = sqlConnection.executeQuery("select name from department d where d.deptId = "+deptid);
            while(resultSet.next()) {
                deptname = resultSet.getString("name");
            }

            resultSet = sqlConnection.executeQuery("select * from course where deptNo = " + deptid);
            while(resultSet.next()) {
                cids.add(resultSet.getString("courseId"));
                cnames.add(resultSet.getString("cname"));
            }

            resultSet = sqlConnection.executeQuery("select * from professor where deptNo = " + deptid);
            while(resultSet.next()) {
                tids.add(resultSet.getString("empId"));
                tnames.add(resultSet.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
            setVisible(false);
            JOptionPane.showMessageDialog(null, "MySQL Connection Failed!");
            System.exit(0);
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 750);
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

        courseField= new JComboBox<>(cnames);
        courseField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        courseField.setBounds(481, 170, 381, 68);
        contentPane.add(courseField);
        
        teacherField = new JComboBox<>(tnames);
        teacherField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        teacherField.setBounds(481, 286, 381, 68);
        contentPane.add(teacherField);

        classRoomField = new JTextField();
        classRoomField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        classRoomField.setBounds(481, 402, 381, 68);
        contentPane.add(classRoomField);
        classRoomField.setColumns(10);

        JLabel lblPassword1 = new JLabel("Select Course");
        lblPassword1.setForeground(Color.BLACK);
        lblPassword1.setBackground(Color.CYAN);
        lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword1.setBounds(150, 170, 293, 52);
        contentPane.add(lblPassword1);

        JLabel lblPassword2 = new JLabel("Select Teacher");
        lblPassword2.setForeground(Color.BLACK);
        lblPassword2.setBackground(Color.CYAN);
        lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword2.setBounds(150, 286, 293, 52);
        contentPane.add(lblPassword2);

        JLabel lblUseruserName = new JLabel("Class Room");
        lblUseruserName.setBackground(Color.BLACK);
        lblUseruserName.setForeground(Color.BLACK);
        lblUseruserName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUseruserName.setBounds(150, 402, 293, 52);
        contentPane.add(lblUseruserName);

        process = new JButton("Process");
        process.setFont(new Font("Tahoma", Font.PLAIN, 26));
        process.setBounds(545, 508, 162, 73);
        process.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Do something
                String cRoom = classRoomField.getText();
                Integer index1 = courseField.getSelectedIndex();
                String cid = cids.get(index1);
                Integer index2 = teacherField.getSelectedIndex();
                String tid = tids.get(index2);
                try {
                    String result = Query1.updateCourse(sqlConnection, deptid, cid, tid, cRoom);
                    JOptionPane.showMessageDialog(null, result);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                classRoomField.setText("");
            }
        });

        contentPane.add(process);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 26));
        back.setBounds(245, 508, 162, 73);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Do something : navigate back
                try {
                    HomeFrame frame = new HomeFrame(sqlConnection);
                    setVisible(false);
                    frame.setVisible(true);
                    dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                
            }
        });

        contentPane.add(back);
    }
}
