
package bank.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;



public class SignupTwo extends JFrame  implements ActionListener{
    
        
    JTextField pan,name, mothername ,email, aadhaar, city, state, maritalstatus, mobile;
    JButton next;
    String Formno;
    JRadioButton syes ,sno, eyes, eno;
    
    
    JComboBox religion ,category, income, eduQual, occupation;
    
    
        Random ran = new Random();
        long first4 = (ran.nextLong() % 9000L) + 1000L;
        String first = "" + Math.abs(first4);
    
    SignupTwo(String Formno){
        this.Formno = Formno;
        setLayout(null);
        
        
        setTitle("New Account Application Form - Page 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Ralway",Font.BOLD,21));
        additionalDetails.setBounds(300,70,450,46);
        add(additionalDetails);
        
        JLabel reliGion= new JLabel("Religion:");
        reliGion.setFont(new Font("Arial",Font.BOLD,17));
        reliGion.setBounds(80,122,300,120);
        add(reliGion);
              
        JLabel cateGory= new JLabel("Category:");
        cateGory.setFont(new Font("Arial",Font.BOLD,17));
        cateGory.setBounds(80,170,300,120);
        add(cateGory);
                      
        JLabel inCome= new JLabel("Income:");
        inCome.setFont(new Font("Arial",Font.BOLD,17));
        inCome.setBounds(80,218,300,120);
        add(inCome);      

        JLabel eduCational= new JLabel("Educational");
        eduCational.setFont(new Font("Arial",Font.BOLD,17));
        eduCational.setBounds(80,266,300,120);
        add(eduCational);
        
        JLabel qualiFication= new JLabel("Qualification:");
        qualiFication.setFont(new Font("Arial",Font.BOLD,17));
        qualiFication.setBounds(80,290,300,120);
        add(qualiFication);
        
        JLabel occuPation= new JLabel("Occupation:");
        occuPation.setFont(new Font("Arial",Font.BOLD,17));
        occuPation.setBounds(80,362,300,120);
        add(occuPation);
        
        JLabel panNo= new JLabel("PAN No:");
        panNo.setFont(new Font("Arial",Font.BOLD,17));
        panNo.setBounds(80,410,300,120);
        add(panNo);
        
        JLabel adhaarNo= new JLabel("Adhaar No:");
        adhaarNo.setFont(new Font("Arial",Font.BOLD,17));
        adhaarNo.setBounds(80,458,300,120);
        add(adhaarNo);
        
        JLabel existingAccount= new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Arial",Font.BOLD,17));
        existingAccount.setBounds(80,506,300,120);
        add(existingAccount);
        
        JLabel seniorCtzn= new JLabel("Senior Citizen:");
        seniorCtzn.setFont(new Font("Arial",Font.BOLD,17));
        seniorCtzn.setBounds(80,554,300,120);
        add(seniorCtzn);
        
        
        String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBackground(Color.white);
        religion.setBounds(230,169,300,30);
        religion.setFont(new Font("Arial",Font.BOLD,15));
        add(religion);
        
        
        String valCategory[]= {"General", "OBC","SC","ST","OTHER"};
        category = new JComboBox(valCategory);
        category.setBackground(Color.white);
        category.setBounds(230,217,300,30);
        category.setFont(new Font("Arial",Font.BOLD,15));
        add(category);
        
        String valIncome[]= {"Null", "< 1,50,000","< 2,50,000","< 5,00,000,","Upto 12,00,000"};
        income = new JComboBox(valIncome);
        income.setBackground(Color.white);
        income.setBounds(230,265,300,30);
        income.setFont(new Font("Arial",Font.BOLD,15));
        add(income);
        
        
        
        String valEdu[]= {"Non Education", "Graduate","Post Graduation","Doctrate","Other"};
        eduQual = new JComboBox(valEdu);
        eduQual.setBackground(Color.white);
        eduQual.setBounds(230,337,300,30);
        eduQual.setFont(new Font("Arial",Font.BOLD,15));
        add(eduQual);
        
        String valOcc[]= {"Salaried", "Self-Employed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(valOcc);
        occupation.setBounds(232,409,250,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(230,553,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(343,553,100,34);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup ssgroup= new ButtonGroup();
        ssgroup.add(syes);
        ssgroup.add(sno);
        
        
        pan = new JTextField();
        pan.setBounds(230,457,300,30);
        pan.setFont(new Font("Arial",Font.BOLD,15));
        add(pan);
        
        aadhaar = new JTextField();
        aadhaar.setBounds(230,505,300,30);
        aadhaar.setFont(new Font("Arial",Font.BOLD,15));
        add(aadhaar);
        
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(230,601,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(343,601,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup egroup= new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
        
        
        
        
        next = new JButton("Next");
        next.setBounds(530,670,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    
    
    
    public void actionPerformed(ActionEvent ae) {
        
        //String Formno = first;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) eduQual.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = pan.getText();
        String sseniorctzn = null;
        if(syes.isSelected()){
            sseniorctzn="Yes";
        }else if(sno.isSelected()){
            sseniorctzn="No";
        }
         
        String ExistingAcc = null;
        if(eyes.isSelected()){
            ExistingAcc="Yes";
        }else if(eno.isSelected()){
            ExistingAcc="No";
        }
        
        
        String saadhaar = aadhaar.getText();
        
        
        try{
            if(saadhaar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhaar is Required");
            }else{
            Conn c = new Conn();
            String query = "insert into signupTwo values ('"+Formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhaar+"','"+ExistingAcc+"','"+sseniorctzn+"')";
            c.s.executeUpdate(query);
            
            new SignupThree(Formno).setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String []args){
        
        new SignupTwo("").setVisible(true);
    }

    
    
}


