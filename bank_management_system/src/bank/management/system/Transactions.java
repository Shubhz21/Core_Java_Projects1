
package bank.management.system;
import java.util.Locale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Shubham Funde
 */
public class Transactions extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    
    JButton deposit, fastcash, withdrawl, ministatement, pinchange, exit, balanceenquiry;
    String pinnumber;
    Timer timer;
    
    Transactions(String pinnumber){
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        this.pinnumber= pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.green);
        image.add(text);
        
         deposit = new JButton("Deposite");
        deposit.setBounds(170,415,100,30);
        deposit.setBackground(Color.gray);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdrawal");
        withdrawl.setBounds(360,415,150,30);
        withdrawl.setBackground(Color.green);
        withdrawl.setForeground(Color.black);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash = new JButton("Fastcash");
        fastcash.setBounds(170,450,100,30);
        fastcash.setBackground(Color.yellow);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(360,450,150,30);
        ministatement.setBackground(Color.red);
        ministatement.setForeground(Color.yellow);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,100,30);
        pinchange.setBackground(Color.gray);
        pinchange.setForeground(Color.white);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(360,485,150,30);
        balanceenquiry.setBackground(Color.green);
        balanceenquiry.setForeground(Color.black);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit = new JButton("Exit");
        exit.setBounds(410,520,100,30);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
         timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                JOptionPane.showMessageDialog(null,"You have been exceeded time limit! \n please sign in again..");
                dispose();
                //System.exit(0);
                new Login().setVisible(true);
                
                
            }
                                   
        });
        
        timer.setRepeats(false); 
        timer.start();
               
    }
    
     @Override
    public void mouseClicked(MouseEvent e) {
        restartTimer();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        restartTimer();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        restartTimer();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        restartTimer();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        restartTimer();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        restartTimer();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        restartTimer();
    }

    
    private void restartTimer() {
        timer.restart();
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            timer.stop();
            System.exit(0);
        }else if(ae.getSource()==deposit){
            
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            timer.stop();
        }else if(ae.getSource()== withdrawl){
            timer.stop();
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            timer.stop();
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            timer.stop();
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            timer.stop();
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            timer.stop();
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    
    
    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
