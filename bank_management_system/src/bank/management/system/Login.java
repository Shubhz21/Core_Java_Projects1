
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        setTitle("ATM");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/klogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,150,50);
        add(label);
        
        JLabel text= new JLabel("Welcome to Kotak Mahindra Bank");
        text.setFont(new Font("Osward",Font.BOLD,18));
        text.setBounds(90,40,300,120);
        add(text);
        
        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Arial",Font.BOLD,16));
        cardno.setBounds(80,120,300,120);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(170,169,160,25);
        cardTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Arial",Font.BOLD,16));
        pin.setBounds(120,170,300,120);
        add(pin);
        
         pinTextField = new JPasswordField();
        pinTextField.setBounds(170,219,100,25);
        pinTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(pinTextField);
        
         login = new JButton("Sign In");
        login.setBounds(121,262,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
         clear = new JButton("Clear");
        clear.setBounds(243,262,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
         signup = new JButton("Sign up");
        signup.setBounds(121,304,222,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(500, 480);
        setLocation(473, 172);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
    } else if(ae.getSource()== login){
        
    }
//    try{
//        if(cardTextField.equals("")){
//            JOptionPane.showMessageDialog(null, "Card number is Required for login!");
//        }
//        if(pinTextField.equals("")){
//            JOptionPane.showMessageDialog(null, "Password is Requiredfor login!");
//        }
//        }catch(Exception e){
//            System.out.println(e);
//        }
    
    else if(ae.getSource()== signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    
    public static void main(String []args){
        new Login();
    }
}
