
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 *
 * @author Shubham Funde
 */
public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    Choice accountType;
    JTextField name,password,username,meter;
    
    Signup(){
//        setSize(700,400);
//        setLocation(450,150);
        
        setBounds(450,150,700, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,240),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        
        
        JLabel heading = new JLabel("Create Account");
        heading.setBounds(100,51, 140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(heading);
        
         accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,52,150,20);
        panel.add(accountType);
        
        
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100,90, 140,20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lblmeter);
        
         meter = new JTextField();
        meter.setBounds(260,93,150,20);
        panel.add(meter);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100,130, 140,20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lblusername);
        
         username = new JTextField();
        username.setBounds(260,133,150,20);
        panel.add(username);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,170, 140,20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lblname);
        
         name = new JTextField();
        name.setBounds(260,173,150,20);
        panel.add(name);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100,210, 140,20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lblpassword);
        
         password = new JTextField();
        password.setBounds(260,213,150,20);
        panel.add(password);
        
         create = new JButton("Create");
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);
        
         back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(280,260,120,25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== create){ 
            
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
            
            try{
                
                Conn c = new Conn();
                
                String query = "insert into login values()";
                
                
            }catch(Exception er){
                er.printStackTrace();
            }
            
    }else if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
    public static void main(String [] arg){
        new Signup();
    }
    
}
