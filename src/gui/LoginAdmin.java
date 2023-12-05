package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginAdmin extends JFrame implements ActionListener{
    JButton Back = new JButton("return");
    JButton Login = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    
     JTextField Username_Field = new JTextField();
    
    private JPasswordField Password_Field = new JPasswordField();
    LoginAdmin(){
        setTitle("Home Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,500);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));
        setLocationRelativeTo (null);
        setVisible(true);
        
        JLabel L1 = new JLabel("UserName");
		L1.setForeground(Color.white); //set font color of text
		L1.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		L1.setBounds(20, 50, 500, 80); //set x,y position within frame as well as dimensions
                add(L1);
        
        JLabel L2 = new JLabel("Passowrd");
		L2.setForeground(Color.white); //set font color of text
		L2.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		L2.setBounds(20, 150, 500, 80); //set x,y position within frame as well as dimensions
                add(L2);
                
                Username_Field.setBounds(170, 80, 300, 25);//username
                add(Username_Field);
                
                Password_Field.setBounds(170, 180, 300, 25);//password
                add(Password_Field);
        
        
        Back.setBounds(25, 400, 200, 50);
        Back.setBackground(Color.white);
        Back.setLabel("Back");
        Back.addActionListener(this);
        add(Back);
        
        Login.setBounds(250, 400, 200, 50);
        Login.setBackground(Color.white);
        Login.setLabel("Login");
        Login.addActionListener(this);
        add(Login);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Admin a = new Admin();
        if(e.getSource()==Back){//Back
            Main l = new Main();
        }
        if(e.getSource()==Login){
            if(Username_Field.getText().isEmpty() && !Password_Field.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter a username", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!Username_Field.getText().isEmpty() && Password_Field.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter a  password ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(Username_Field.getText().isEmpty() && Password_Field.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter a  password and a username", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(Username_Field.getText().equals("Admin") && Password_Field.getText().equals("Admin") ){
                JOptionPane.showMessageDialog(null, "Welcome Back Admin :)", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                AdminDashboard h =  new AdminDashboard();
            }
            else if(!Username_Field.getText().isEmpty() && !Password_Field.getText().isEmpty() ){
                if(a.Login(Username_Field.getText(), Password_Field.getText())){
                    JOptionPane.showMessageDialog(null, "Welcome Back Admin :)", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    AdminDashboard h =  new AdminDashboard();
                }
                if(!a.Login(Username_Field.getText(), Password_Field.getText())){
                    JOptionPane.showMessageDialog(null, "Password Is Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
            }
        }
        
        setVisible(false);
    }
}
