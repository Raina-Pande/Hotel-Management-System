package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    EmployeeInfo() {
        
        setLayout(null);
                
        table = new JTable();
        table.setBounds(0,40,1200,400);
        add(table);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(150,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(450,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(600,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(750,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(900,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhaar");
        l8.setBounds(1050,10,100,20);
        add(l8);
        
        back = new JButton("Back");
        back.setBounds(550,550,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        setBounds(250,200,1200,600);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    
    }
    
    public static void main(String[] args) {
        
        new EmployeeInfo();
    
    }
    
}
