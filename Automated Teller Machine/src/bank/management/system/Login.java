
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


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
        
         signup = new JButton("New Bank Account");
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
                        
                        
                                  
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
        try{
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            
            else if(cardnumber.equals("")){
            JOptionPane.showMessageDialog(null, "Card number is Required for login!");
        } 
            else if(pinnumber.equals("")){
            JOptionPane.showMessageDialog(null, "Password is Required for login!");
        }
            
            else if (!isValidCardNumber(cardnumber)) {
                        JOptionPane.showMessageDialog(null, "Invalid Card number. Please check your card number.");
                    } else if (!isValidPin(pinnumber)) {
                        JOptionPane.showMessageDialog(null, "Invalid PIN. Please check your PIN.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Card number or PIN. Please check your credentials.");
                    }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    
    }
//    try{

//        }catch(Exception e){
//            System.out.println(e);
//        }
    
    else if(ae.getSource()== signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    
    private boolean isValidCardNumber(String cardNumber) {
    
        
        Conn conn = new Conn();
    String query = "select * from login where cardnumber = '" + cardNumber + "'";
    
    try {
        ResultSet rs = conn.s.executeQuery(query);
        return rs.next();  // Returns true if a record with the specified card number exists
    } catch (Exception e) {
        System.out.println(e);
        
    }
        
    return false;  
}

private boolean isValidPin(String pin) {
    
    Conn conn = new Conn();
    String query = "select * from login where pin = '" + pin + "'";
    
    try {
        ResultSet rs = conn.s.executeQuery(query);
        return rs.next();  // Returns true if a record with the specified PIN is correct
    } catch (Exception e) {
        System.out.println(e);
        
    }
    
    return false;  
}
    
    public static void main(String []args){
        new Login();
    }
}
