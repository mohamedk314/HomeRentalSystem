package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener{
JButton Save = new JButton("Save");
    JButton Cancel = new JButton("Cancel");
    Clients h = new Clients();
    //int ID, String SSN, String Name, String Contact_No, String username, String password, String email
    JTextField SSN_Text = new JTextField("");
    JTextField Name_Text = new JTextField("");
    JTextField Contact_No_Text = new JTextField("");
    JTextField username_Text = new JTextField("");
    JTextField password_Text = new JTextField("");
    JTextField email_Text = new JTextField("");
    SignUp(){
        setTitle("Add new Client");
        setResizable(false);
        setSize(400,600);
        setLayout(null);
        setLocationRelativeTo (null);
//        setUndecorated(true);
        
        Save.setBounds(50, 500, 100, 40);
        Save.addActionListener(this);
        add(Save);
        
        Cancel.setBounds(250, 500, 100, 40);
        Cancel.addActionListener(this);
        add(Cancel);
        
        
                JLabel SSN_Label = new JLabel("SSN");
		SSN_Label.setForeground(Color.BLACK); //set font color of text
		SSN_Label.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		SSN_Label.setBounds(20, 25, 500, 80); //set x,y position within frame as well as dimensions
                add(SSN_Label);
                
                JLabel Name_Label = new JLabel("Name");
		Name_Label.setForeground(Color.BLACK); //set font color of text
		Name_Label.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		Name_Label.setBounds(20, 100, 500, 80); //set x,y position within frame as well as dimensions
                add(Name_Label);
                
                JLabel Contact_No_Label = new JLabel("Contact_No");
		Contact_No_Label.setForeground(Color.BLACK); //set font color of text
		Contact_No_Label.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		Contact_No_Label.setBounds(20, 175, 500, 80); //set x,y position within frame as well as dimensions
                add(Contact_No_Label);
                
                JLabel username_Label = new JLabel("username");
		username_Label.setForeground(Color.BLACK); //set font color of text
		username_Label.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		username_Label.setBounds(20, 250, 500, 80); //set x,y position within frame as well as dimensions
                add(username_Label);

                JLabel password_Label = new JLabel("password");
		password_Label.setForeground(Color.BLACK); //set font color of text
		password_Label.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		password_Label.setBounds(20, 325, 325, 80); //set x,y position within frame as well as dimensions
                add(password_Label);

                JLabel email_Label = new JLabel("email");
		email_Label.setForeground(Color.BLACK); //set font color of text
		email_Label.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		email_Label.setBounds(20, 400, 500, 80); //set x,y position within frame as well as dimensions
                add(email_Label);
                  
                
		SSN_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		SSN_Text.setBounds(180, 55, 200, 25); //set x,y position within frame as well as dimensions
                add(SSN_Text);
                
                
		Name_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		Name_Text.setBounds(180, 130, 200, 25); //set x,y position within frame as well as dimensions
                add(Name_Text);
                
                
		Contact_No_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		Contact_No_Text.setBounds(180, 205, 200, 25); //set x,y position within frame as well as dimensions
                add(Contact_No_Text);
                
                
		username_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		username_Text.setBounds(180, 280, 200, 25); //set x,y position within frame as well as dimensions
                add(username_Text);

                
		password_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		password_Text.setBounds(180, 355, 200, 25); //set x,y position within frame as well as dimensions
                add(password_Text);

                
		email_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		email_Text.setBounds(180, 430, 200, 25); //set x,y position within frame as well as dimensions
                add(email_Text);
        
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==Cancel){
            setVisible(false);
            Main m = new Main ();
        }
        if(e.getSource()==Save){
            if(SSN_Text.getText().isEmpty() || Name_Text.getText().isEmpty() || Contact_No_Text.getText().isEmpty() || username_Text.getText().isEmpty()
                    || password_Text.getText().isEmpty() || email_Text.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                String SSN1 = SSN_Text.getText().trim() , Name1 = Name_Text.getText().trim() , Contact_No1 = Contact_No_Text.getText().trim() ;
                String username1 = username_Text.getText().trim() , password1 = password_Text.getText().trim() , email1 = email_Text.getText().trim();
                h.setSSN(SSN1);
                h.setName(Name1);
                h.setContact_No(Contact_No1);
                h.setUsername(username1);
                h.setPassword(password1);
                h.setEmail(email1);
                h.Add();
                JOptionPane.showMessageDialog(null, "The report has been added", "Well Done", JOptionPane.INFORMATION_MESSAGE);
                Main m = new Main ();
            }
            
        }
        setVisible(false);
    }
    
}
