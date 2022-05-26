package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ClientLogin extends JFrame implements ActionListener{
    
    JButton Back = new JButton();
    JButton Login = new JButton();
    
    JTextField UserName_Text = new JTextField();
    private JPasswordField Password_Field = new JPasswordField();
ClientLogin(){
    setTitle("Home Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,500);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));
//        setUndecorated(true);
        setLocationRelativeTo (null);
        
        
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
        
        UserName_Text.setBounds(170, 80, 300, 25);
                add(UserName_Text);
                
                Password_Field.setBounds(170, 180, 300, 25);
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
        
        setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        Clients a = new Clients ();
        if(e.getSource()==Back){//back
            Main l = new Main();
        }
        if(e.getSource()==Login){//submit
            if(UserName_Text.getText().isEmpty() && !Password_Field.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter a username", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!UserName_Text.getText().isEmpty() && Password_Field.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter a  password ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(UserName_Text.getText().isEmpty() && Password_Field.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter a  password and a username", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!UserName_Text.getText().isEmpty() && !Password_Field.getText().isEmpty() ){ 
                if(!a.Login(UserName_Text.getText(), Password_Field.getText())){
                    JOptionPane.showMessageDialog(null, "Password Is Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
                if(a.Login(UserName_Text.getText(), Password_Field.getText())){
                    JOptionPane.showMessageDialog(null, "Welcome Client :)", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                ClientDashboard cd = new ClientDashboard ();

                }
            }
        }
        setVisible(false);
        }
        
    }
    //ClientDashboard
