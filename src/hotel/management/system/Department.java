package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    Department() {
        
        setLayout(null);
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(350,10,100,20);
        add(l2);
        
        back = new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        setBounds(400,200,700,450);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    
    }
    
    public static void main(String[] args) {
        
        new Department();
    
    }
    
}
