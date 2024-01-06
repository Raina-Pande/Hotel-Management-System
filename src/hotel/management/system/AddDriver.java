package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    JButton add,cancel;
    
    AddDriver() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(140,10,200,20);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setBounds(60,70,120,30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setFont(new Font("Tahoma",Font.PLAIN,13));
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds(60,110,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setFont(new Font("Tahoma",Font.PLAIN,13));
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);
        
        String genderOptions[] = {"Male","Female"};
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lblcomany = new JLabel("Car Company");
        lblcomany.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcomany.setBounds(60,190,120,30);
        add(lblcomany);
        
        tfcompany = new JTextField();
        tfcompany.setFont(new Font("Tahoma",Font.PLAIN,13));
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblmodel.setBounds(60,230,120,30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setFont(new Font("Tahoma",Font.PLAIN,13));
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);
        
        String driverOptions[] = {"Available","Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds(60,310,200,30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setFont(new Font("Tahoma",Font.PLAIN,13));
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,360,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,360,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,80,500,300);
        add(image);
                                       
        setBounds(300,200,980,430);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == add) {
            
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try {
                
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New driver added successfully");
                
            } catch (Exception e) {
            
                e.printStackTrace();
            
            }
        
        } else {
        
            setVisible(false);
            
        }
    
    }
    
    public static void main(String args[]) {
        
        new AddDriver();
    
    }
    
}
