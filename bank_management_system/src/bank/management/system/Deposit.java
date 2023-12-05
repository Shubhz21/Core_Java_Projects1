
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
/**
 *
 * @author Shubham Funde
 */
public class Deposit extends JFrame implements ActionListener{
    
    JButton deposit, back;
    JTextField amount;
    JLabel text;
    String pinnumber;
    
    
    
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         text = new JLabel("Enter the amount you want to deposit");
        //text.setBackground(Color.black);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
         amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,12));
        amount.setBounds(170,350,300,25);
        image.add(amount);
        
         deposit = new JButton("Deposit");
        deposit.setBackground(Color.green);
        deposit.setForeground(Color.black);
        deposit.setBounds(360,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(360,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == deposit){
            String money = amount.getText();
            //String pnum = pinnumber;
            //Date date = new Date();
            Date uDate = new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit!");
            }else{
                try{
                    
                    int depositAmount = Integer.parseInt(money);

                // Check if withdrawal amount is greater than or equal to 100
                if (depositAmount < 100) {
                    JOptionPane.showMessageDialog(null, "Deposit amount should be atleast 100!");
                    return;
                }
                    
                Conn conn = new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+uDate+"','Deposit','"+money+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Deposited Successfully" );
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                }catch(Exception e){
                    System.out.println(e);
                    
                }
            }
        }
        if(ae.getSource() == back){
            setVisible(false);
            
            new Transactions(pinnumber).setVisible(true);
        }
        
        
        
    }
    
    
     

    

    
    
    
    
    public static void main(String []args){
        
        new Deposit("");
    }
}
