
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author Shubham Funde
 */
public class MiniStatement extends JFrame implements ActionListener{
    
    

String pinnumber;
JButton b1, b2;
    JLabel l1,l4;
    MiniStatement(String pinnumber){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/klogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,150,50);
        add(label);
        
        l1 = new JLabel();
        l1.setBounds(20, 120, 350, 280);
        add(l1);
        
        JLabel l2 = new JLabel("Kotak Mahindra Bank");
        l2.setBounds(140, 70, 200, 20);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 100, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 420, 300, 20);
        add(l4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("money") + "<br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("money"));
                }else{
                    balance -= Integer.parseInt(rs.getString("money"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        
        b1 = new JButton("Exit");
        b1.addActionListener(this);
        b1.setBounds(20, 500, 100, 25);
        //add(b1);
        
        
        
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
            }
        });

        
        timer.setRepeats(false); // Set to false to execute the ActionListener only once
        timer.start();
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
        this.setVisible(false);
        
            
        
                   
    }

    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}