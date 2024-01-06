package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    JMenuBar mb;
    JMenu hotel, admin;
    JMenuItem reception, addemployee, addrooms, adddriver;
    
    Dashboard() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("TAJ GROUP WELCOMES YOU");
        text.setBounds(450,80,1000,50);
        text.setFont(new Font("Tahoma", Font.BOLD, 45));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        mb.setBackground(Color.WHITE);
        image.add(mb);
        
        hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        reception = new JMenuItem("Reception");
        reception.setBackground(Color.WHITE);
        reception.setForeground(Color.BLACK);
        reception.addActionListener(this);
        hotel.add(reception);
        
        admin = new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        addemployee = new JMenuItem("Add Employee");
        addemployee.setBackground(Color.WHITE);
        addemployee.setForeground(Color.BLACK);
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        addrooms = new JMenuItem("Add Rooms");
        addrooms.setBackground(Color.WHITE);
        addrooms.setForeground(Color.BLACK);
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        adddriver = new JMenuItem("Add Driver");
        adddriver.setBackground(Color.WHITE);
        adddriver.setForeground(Color.BLACK);
        adddriver.addActionListener(this);
        admin.add(adddriver);
        
        setBounds(0,0,1550,1000);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
    
        if(ae.getActionCommand().equals("Add Employee")) {
            
            new AddEmployee();
            
        } else if(ae.getActionCommand().equals("Add Rooms")) {
            
            new AddRooms();
            
        } else if(ae.getActionCommand().equals("Add Driver")) {
            
            new AddDriver();
            
        } else if(ae.getActionCommand().equals("Reception")) {
            
            new Reception();
            
        }
        
    }
    
    public static void main(String args[]) {
        
        new Dashboard();
    
    }
    
}