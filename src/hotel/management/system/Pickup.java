package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    
    Pickup() {
        
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(430,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Type of Vehicle");
        lblbed.setBounds(20,100,100,20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()) {
                
                typeofcar.add(rs.getString("model"));
                
            }
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }        
        
        table = new JTable();
        table.setBounds(20,200,1000,500);
        add(table);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(20,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(163,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(304,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(448,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Model");
        l5.setBounds(591,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(734,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(877,160,100,20);
        add(l7);
        
        back = new JButton("Back");
        back.setBounds(900,100,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBounds(760,100,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);
        
        setBounds(200,20,1050,850);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == submit) {
            
            try {
                
                String query = "Select * from driver where model = '"+typeofcar.getSelectedItem()+"'";
                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
            
                e.printStackTrace();
                
            }
            
        } else {
            
            setVisible(false);
            new Reception();
            
        }
          
    }
    
    public static void main(String[] args) {
        
        new Pickup();
    
    }
    
}
