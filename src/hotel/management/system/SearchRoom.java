package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom() {
        
        setLayout(null);
        
        JLabel text = new JLabel("Search For Room");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(430,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(20,100,100,20);
        add(lblbed);
        
        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(100,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("only display available");
        available.setBounds(300,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        table = new JTable();
        table.setBounds(20,200,1000,500);
        add(table);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(20,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availibility");
        l2.setBounds(220,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(420,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(620,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(820,160,100,20);
        add(l5);
        
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
                
                String query1 = "Select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "Select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()) {
                    
                    rs = conn.s.executeQuery(query2);
                    
                } else {
                    
                    rs = conn.s.executeQuery(query1);
                
                }
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
        
        new SearchRoom();
    
    }
    
}
