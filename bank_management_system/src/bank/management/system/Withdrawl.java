
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
public class Withdrawl extends JFrame implements ActionListener{
    
    JButton withdraw, back;
    JTextField amount;
    JLabel text;
    String pinnumber;
    
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         text = new JLabel("Enter the amount you want to Withdraw");
        //text.setBackground(Color.black);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
         amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,12));
        amount.setBounds(170,350,300,25);
        image.add(amount);
        
         withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.green);
        withdraw.setForeground(Color.black);
        withdraw.setBounds(360,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
        
        if(ae.getSource() == withdraw){
            String money = amount.getText();
            //String pnum = pinnumber;
            //Date date = new Date();
            Date uDate = new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw!");
            }else{
                try{
                    
                    int withdrawalAmount = Integer.parseInt(money);

                
                if (withdrawalAmount < 100) {
                    JOptionPane.showMessageDialog(null, "Withdrawal amount should be atleast 100!");
                    return;
                }
                
                if (withdrawalAmount % 100 != 0) {
                    JOptionPane.showMessageDialog(null, "Withdrawal amount should be a multiple of 100!");
                    return;
                }
                    
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                    return;
                }
                String query ="insert into bank values('"+pinnumber+"','"+uDate+"', 'Withdrawl' ,'"+money+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
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
        
        new Withdrawl("");
    }
}
