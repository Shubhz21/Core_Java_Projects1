
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Shubham Funde
 */
public class PinChange extends JFrame implements ActionListener {
    
    JLabel text,pintext,repintext;
        JPasswordField  pin,rpin;
            JButton change,back;
            String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    
     text = new JLabel("Change Your Pin");
    text.setForeground(Color.white);
    text.setFont(new Font("System", Font.BOLD, 15));
    text.setBounds(270,280,400,33);
    image.add(text);
    
     pintext = new JLabel("New Pin:");
    pintext.setForeground(Color.white);
    pintext.setFont(new Font("System", Font.BOLD, 15));
    pintext.setBounds(165,322,180,26);
    image.add(pintext);
    
    pin = new JPasswordField();
    pin.setFont(new Font("Raleway", Font.BOLD,25));
    pin.setBounds(330,324,180,25);
    image.add(pin);
            
     repintext = new JLabel("Re-Enter Pin:");
    repintext.setForeground(Color.white);
    repintext.setFont(new Font("System", Font.BOLD, 15));
    repintext.setBounds(165,365,180,26);
    image.add(repintext);
    
     rpin = new JPasswordField();
    rpin.setFont(new Font("Raleway", Font.BOLD,25));
    rpin.setBounds(330,367,180,25);
    image.add(rpin);
    
     change = new JButton("Change");
    change.setBounds(355,475,150,30);
    change.addActionListener(this);
    image.add(change);
    
     back = new JButton("Back");
    back.setBounds(355,509,150,30);
    back.addActionListener(this);
    image.add(back);
            
    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin= pin.getText();
            String repin = rpin.getText();
            
            if(!npin.equals(repin)){
                JOptionPane.showMessageDialog(null,"Entered Pin Does not Match!");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your pin");
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new pin");
            }
            
            
            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+repin+"'where pin='"+pinnumber+"'";
            String query2 = "update login set pin = '"+repin+"'where pin='"+pinnumber+"'";
            String query3 = "update SignupThree set pin = '"+repin+"'where pin='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "Pin Changed Successfully!");
            
            setVisible(false);
            new Transactions(repin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
      }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String []args){
        new PinChange("").setVisible(true);
    }
}
