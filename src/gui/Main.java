package gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.*;

public class Main extends JFrame implements ActionListener , EventListener{

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    
    Main(){
        setTitle("Home Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,500);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));
        setLocationRelativeTo (null);
//        setUndecorated(true);
      
        b1.setBounds(80, 70, 340, 30);//BUTTON of admin login
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setLabel("Admin Login");
        b1.addActionListener(this);
        add(b1);
        
        b2.setBounds(80, 170, 340, 30);//BUTTON of member login
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setLabel("Client Login");
        b2.addActionListener(this);
        add(b2);
        
        b3.setBounds(80, 270, 340, 30);//BUTTON of siging up for member
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setLabel("Sign Up as a new client");
        b3.addActionListener(this);
        add(b3);
        
        b4.setBounds(80, 370, 340, 30);//BUTTON of retriving
        b4.setBackground(Color.white);
        b4.setForeground(Color.black);
        b4.setLabel("About our Project <3");
        b4.addActionListener(this);
        add(b4);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1){ // for login as admin
        LoginAdmin a = new LoginAdmin();
        setVisible(false);
        }
        
        if(e.getSource()==b2){ // for login as member
        ClientLogin c = new ClientLogin();
        setVisible(false);
        }
        
        if(e.getSource()==b3){ // for sign up
        SignUp ac = new SignUp();
        }
        
        if(e.getSource()==b4){ // for retrive password and username
        JOptionPane.showMessageDialog(null, "Under the great supervision of Dr Walaa AbdelHamid and Dr Ammar Mohamed \n"
                                          + " our group that cosists of Mohamed , Abdelrahman , Shahd , Monad and Youssef \n" 
                                                  + "did a great job performing in their first project in oop course ." , "About our Project " ,JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }

}