
package bank.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.*;


public class SignupOne extends JFrame  implements ActionListener{
    
        
    JTextField name, mothername ,email, address, city, state, maritalstatus, mobile;
    JButton next, cancel;
    String Formno;
    JRadioButton male, female, Married, Single, Other;
    JDateChooser dateChooser;
    
    
        Random ran = new Random();
        long first4 = (ran.nextLong() % 9000L) + 1000L;
        String first = "" + Math.abs(first4);
    
    SignupOne(){
//        this.first = first;

        setLayout(null);
        
        
        
        
        
        JLabel formno = new JLabel("Application Form No. "+first);
        formno.setFont(new Font("Ralway",Font.BOLD,30));
        formno.setBounds(230,27,450,46);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Ralway",Font.BOLD,21));
        personalDetails.setBounds(300,70,450,46);
        add(personalDetails);
        
        JLabel Name= new JLabel("Name:");
        Name.setFont(new Font("Arial",Font.BOLD,17));
        Name.setBounds(80,122,300,120);
        add(Name);
              
        JLabel motherName= new JLabel("Mother's Name:");
        motherName.setFont(new Font("Arial",Font.BOLD,17));
        motherName.setBounds(80,170,300,120);
        add(motherName);
                      
        JLabel Dateofbirth= new JLabel("Date of Birth:");
        Dateofbirth.setFont(new Font("Arial",Font.BOLD,17));
        Dateofbirth.setBounds(80,218,300,120);
        add(Dateofbirth);      

        JLabel Gender= new JLabel("Gender:");
        Gender.setFont(new Font("Arial",Font.BOLD,17));
        Gender.setBounds(80,266,300,120);
        add(Gender);
        
        JLabel Email= new JLabel("Email:");
        Email.setFont(new Font("Arial",Font.BOLD,17));
        Email.setBounds(80,314,300,120);
        add(Email);
        
        JLabel Maritalstatus= new JLabel("Marital Status:");
        Maritalstatus.setFont(new Font("Arial",Font.BOLD,17));
        Maritalstatus.setBounds(80,362,300,120);
        add(Maritalstatus);
        
        JLabel Address= new JLabel("Address:");
        Address.setFont(new Font("Arial",Font.BOLD,17));
        Address.setBounds(80,410,300,120);
        add(Address);
        
        JLabel City= new JLabel("City:");
        City.setFont(new Font("Arial",Font.BOLD,17));
        City.setBounds(80,458,300,120);
        add(City);
        
        JLabel Mobile= new JLabel("Mobile:");
        Mobile.setFont(new Font("Arial",Font.BOLD,17));
        Mobile.setBounds(80,506,300,120);
        add(Mobile);
        
        JLabel State= new JLabel("State:");
        State.setFont(new Font("Arial",Font.BOLD,17));
        State.setBounds(80,554,300,120);
        add(State);
        
        name = new JTextField();
        name.setBounds(230,169,300,30);
        name.setFont(new Font("Arial",Font.BOLD,15));
        add(name);
        
        mothername = new JTextField();
        mothername.setBounds(230,217,300,30);
        mothername.setFont(new Font("Arial",Font.BOLD,15));
        add(mothername);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(230,265,300,30);
        //email.setFont(new Font("Arial",Font.BOLD,15));
        add(dateChooser);
        
        male = new JRadioButton("Male");
        male.setBounds(232,313,100,34);
        male.setBackground(Color.white);
        add(male);
        
        
        female = new JRadioButton("Female");
        female.setBounds(345,313,100,34);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        email = new JTextField();
        email.setBounds(230,361,300,30);
        email.setFont(new Font("Arial",Font.BOLD,15));
        add(email);
        
        Married = new JRadioButton("Married");
        Married.setBounds(232,409,100,34);
        Married.setBackground(Color.white);
        add(Married);
        
         Single = new JRadioButton("Single");
        Single.setBounds(345,409,100,34);
        Single.setBackground(Color.white);
        add(Single);
        
        Other = new JRadioButton("Other");
        Other.setBounds(445,409,100,34);
        Other.setBackground(Color.white);
        add(Other);
        
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(Married);
        maritalgroup.add(Single);
        maritalgroup.add(Other);
        
        address = new JTextField();
        address.setBounds(230,457,300,30);
        address.setFont(new Font("Arial",Font.BOLD,15));
        add(address);
        
        city = new JTextField();
        city.setBounds(230,505,300,30);
        city.setFont(new Font("Arial",Font.BOLD,15));
        add(city);
        
        
        
        state = new JTextField();
        state.setBounds(230,553,300,30);
        state.setFont(new Font("Arial",Font.BOLD,15));
        add(state);
        
        mobile = new JTextField();
        mobile.setBounds(230,601,300,30);
        mobile.setFont(new Font("Arial",Font.BOLD,15));
        add(mobile);
        
        
        next = new JButton("Next");
        next.setBounds(530,670,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400,670,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        String Formno = first;
        String Name = name.getText();
        String motherName = mothername.getText();
        String Dateofbirth = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        
        String Email = email.getText();
        
        String Maritalstatus = null;
        if(Single.isSelected()){
            Maritalstatus="Single";
        }else if(Married.isSelected()){
            Maritalstatus="Married";
        }else if(Other.isSelected()){
            Maritalstatus="Other";
        }
        
        String Address = address.getText();
        String City = city.getText();
        String Mobile = mobile.getText();
        String State = state.getText();
        
        try{
             if(ae.getSource()==cancel){
                 
                setVisible(false);
                new Login().setVisible(true);
            }
             else if(Name.equals("")){
                
                JOptionPane.showMessageDialog(null, "All fields are Required!");
            }
                    
                    else{
                
            Conn c = new Conn();
            String query = "insert into signup values ('"+Formno+"','"+Name+"','"+motherName+"','"+Dateofbirth+"','"+gender+"','"+Maritalstatus+"','"+Address+"','"+City+"','"+Mobile+"','"+State+"','"+Email+"')";
            c.s.executeUpdate(query);
            
            new SignupTwo(first).setVisible(true);
            setVisible(false);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String []args){
        
        
        new SignupOne().setVisible(true);
    }

    
    
}


