package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    CustomerInfo() {
        
        setLayout(null);
                
        table = new JTable();
        table.setBounds(0,40,1350,400);
        add(table);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(170,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(338,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(507,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(675,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(845,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(1013,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(1182,10,100,20);
        add(l8);
        
        back = new JButton("Back");
        back.setBounds(650,550,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        setBounds(80,200,1350,600);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    
    }
    
    public static void main(String[] args) {
        
        new CustomerInfo();
    
    }
    
}
