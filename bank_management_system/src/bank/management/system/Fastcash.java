
package bank.management.system;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Shubham Funde
 */
public class Fastcash extends JFrame implements ActionListener {
    
    JButton b100, b1000, b500, b2000, b5000, exit, b10000;
    String pinnumber;
    
    
    Fastcash(String pinnumber){
        
        this.pinnumber= pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.green);
        image.add(text);
        
         b100 = new JButton("Rs 100");
        b100.setBounds(170,415,100,30);
        b100.setBackground(Color.gray);
        b100.setForeground(Color.white);
        b100.addActionListener(this);
        image.add(b100);
        
         b500 = new JButton("Rs 500");
        b500.setBounds(360,415,150,30);
        b500.setBackground(Color.gray);
        b500.setForeground(Color.white);
        b500.addActionListener(this);
        image.add(b500);
        
         b1000 = new JButton("Rs 1000");
        b1000.setBounds(170,450,100,30);
        b1000.setBackground(Color.gray);
        b1000.setForeground(Color.white);
        b1000.addActionListener(this);
        image.add(b1000);
        
         b2000 = new JButton("Rs 2000");
        b2000.setBounds(360,450,150,30);
        b2000.setBackground(Color.gray);
        b2000.setForeground(Color.white);
        b2000.addActionListener(this);
        image.add(b2000);
        
         b5000 = new JButton("Rs 5000");
        b5000.setBounds(170,485,100,30);
        b5000.setBackground(Color.gray);
        b5000.setForeground(Color.white);
        b5000.addActionListener(this);
        image.add(b5000);
        
         b10000 = new JButton("Rs 10000");
        b10000.setBounds(360,485,150,30);
        b10000.setBackground(Color.gray);
        b10000.setForeground(Color.white);
        b10000.addActionListener(this);
        image.add(b10000);
        
         exit = new JButton("Back");
        exit.setBounds(410,520,100,30);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
        
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            
            new Transactions(pinnumber).setVisible(true);
        }else if(ae.getSource() == b100){
            String money = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b500){
            String money = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        } 
        else if(ae.getSource() == b1000){
            String money = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2000){
            String money = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b5000){
            String money = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b10000){
            String money = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("money"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("money"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(money)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+money+" Debited Successfully!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        new Fastcash("").setVisible(true);
    }
}

