
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
/**
 *
 * @author Shubham Funde
 */
public class MiniStatement extends JFrame{
    
    //String pinnumber;
    JLabel bank,mini,card, balance;
    
    MiniStatement(String pinnumber){
//        this.pinnumber=pinnumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        
        
         bank = new JLabel("Kotak Mahindra Bank");
        bank.setBounds(148,20,200,20);
        add(bank);
        
         mini = new JLabel();
        mini.setBounds(20,140,300,40);
        add(mini);
        
         card = new JLabel();
        card.setBounds(20,100,200,20);
        add(card);
        
        balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("money")+ "<br><br></html>");
                
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("money"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("money"));
                    }
            }
            balance.setText("Your Current Account Balance is Rs. "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        setSize(400,700);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public static void main(String []args){
        new MiniStatement("");
    }
}
