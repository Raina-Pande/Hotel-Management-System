package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhaar;
    JRadioButton rbmale, rbfemale;
    ButtonGroup bg;
    JComboBox cbjob;
    JButton submit;
    
    AddEmployee() {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(325,100,250,200);
        add(image);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,20,100,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfname.setBounds(140,20,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(40, 60, 100, 30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfage.setBounds(140,60,150,30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(40, 100, 100, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(140, 100, 60, 30);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(220, 100, 100, 30);
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(rbfemale);
        
        bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("Job");
        lbljob.setBounds(40, 140, 100, 30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbljob);
        
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(140,140,150,30);
        cbjob.setBackground(Color.WHITE);
        cbjob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(cbjob);
        
        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(40, 180, 100, 30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfsalary.setBounds(140,180,150,30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 220, 100, 30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfphone.setBounds(140,220,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(40, 260, 100, 30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfemail.setBounds(140,260,150,30);
        add(tfemail);
        
        JLabel lblaadhaar = new JLabel("Aadhaar");
        lblaadhaar.setBounds(40, 300, 100, 30);
        lblaadhaar.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblaadhaar);
        
        tfaadhaar = new JTextField();
        tfaadhaar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfaadhaar.setBounds(140,300,150,30);
        add(tfaadhaar);
        
        submit = new JButton("Submit");
        submit.setBounds(140,350,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);
        
        setBounds(470,200,610,400);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhaar = tfaadhaar.getText();
        
        String gender = null; 
        if (rbmale.isSelected()) {
            
            gender = "Male";
            
        } else if(rbfemale.isSelected()) {
            
            gender = "Female";
        
        }
        
        String job = (String) cbjob.getSelectedItem(); 
        
        try {
            
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhaar+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
            
        } catch(Exception e) {
            
            e.printStackTrace();
        
        }
    
    }
    
    public static void main(String args[]) {
    
        new AddEmployee();
        
    }
    
}
