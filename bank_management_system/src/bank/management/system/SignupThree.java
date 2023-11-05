
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 *
 * @author Shubham Funde
 */
public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String Formno;
    
    
    SignupThree(String Formno){
        this.Formno = Formno;
        
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100,140,400,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(150,200,150,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(420,200,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(150,250,150,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(420,250,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4182");
        number.setFont(new Font("Raleway", Font.ITALIC, 19));
        number.setBounds(300,300,300,29);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 13));
        carddetail.setBounds(100,325,300,20);
        add(carddetail);
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,360,200,30);
        add(pin);
        
        JLabel pdetail = new JLabel("Your 4 Digit Password");
        pdetail.setFont(new Font("Raleway", Font.BOLD, 13));
        pdetail.setBounds(100,385,300,20);
        add(pdetail);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.ITALIC, 19));
        pnumber.setBounds(300,360,300,29);
        add(pnumber);
        
        JLabel srvcrqrd = new JLabel("Services Required:");
        srvcrqrd.setFont(new Font("Raleway", Font.BOLD, 18));
        srvcrqrd.setBounds(100,430,200,22);
        add(srvcrqrd);
                
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,490,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,490,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(270,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(440,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);  
        setSize(850,820);
        setLocation(350,0);
        setBackground(Color.white);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if (r3.isSelected()){
                accountType="Current Account";
            }else if (r4.isSelected()){
                accountType="Recurring Deposit Account";
            }
                Random randm = new Random();
                 
                String cardnumber = ""+ Math.abs((randm.nextLong()% 9000000L)+ 5040936000000000L);
                String pinnumber = "" + Math.abs((randm.nextLong()%9000L)+1000L);
                String facility = "";
                if(c1.isSelected()){
                    facility=facility+ " ATM CARD ";
                } if(c2.isSelected()){
                    facility = facility+" Internet Banking ";
                } if(c3.isSelected()){
                    facility = facility+" Mobile Banking ";
                } if(c4.isSelected()){
                    facility = facility+" Email & SMS Alerts ";
                } if(c5.isSelected()){
                    facility = facility+" Cheque-Book ";
                } if(c6.isSelected()){
                    facility = facility+"E-Statement ";
                }
                try{
                    if(accountType.equals("")){
                        JOptionPane.showMessageDialog(null,"Account Type is Required");
                    }else {
                        Conn conn = new Conn();
                        String query1 = "insert into signupthree values('"+Formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                        String query2 = "insert into login values('"+Formno+"','"+cardnumber+"','"+pinnumber+"')";
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Card No- "+cardnumber+"\n Pin: "+pinnumber);
                        setVisible(false);
                        new Login().setVisible(true);
                    }
                    
                }catch(Exception e){
                    System.out.println(e);
                    
                }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String []arg){
        new SignupThree("");
        
    }
    
}
