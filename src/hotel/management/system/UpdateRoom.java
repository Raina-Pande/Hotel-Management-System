package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus;
    JButton check,update,back;
    
    UpdateRoom() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,330,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,20,500,340);
        add(image);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(90,20,250,30);
        text.setForeground(Color.BLACK);
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,90,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,90,160,25);
        add(ccustomer);
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                
                ccustomer.add(rs.getString("number"));
            
            }
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,140,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,140,160,25);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30,190,100,20);
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,190,160,25);
        add(tfavailable);
        
        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setBounds(30,240,100,20);
        add(lblstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200,240,160,25);
        add(tfstatus);
        
        check = new JButton("Check");
        check.setBounds(30, 325, 90,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150, 325, 90,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270, 325, 90,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
                        
        setBounds(300,200,940,430);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == check) {

            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try {
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    
                    tfroom.setText(rs.getString("room"));
                    
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()) {
                    
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                    
                }
                
            } catch(Exception e) {
                
                e.printStackTrace();
            
            }
                       
        } else if(ae.getSource() == update) {

            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
            try {
                
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability='"+available+"',cleaning_status='"+status+"' where roomnumber='"+room+"'");
                JOptionPane.showMessageDialog(null,"Data updated successfully");
                setVisible(false);
                new Reception();
            
            } catch (Exception e) {
                
                e.printStackTrace();
            
            }
            
        } else if(ae.getSource() == back) { 
            
            setVisible(false);
            new Reception();
            
        }
    
    }
    
    public static void main(String args[]) {
        
        new UpdateRoom();
    
    }
    
}
