package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditAdmin extends JFrame{
    JButton Update_Button, Cancel_Button;
    JLabel AdminID_Label, AdminIDValidity_Label;
    JTextField AdminID_TextField;
     Admin admin;
    public EditAdmin() {
        super("Update Admin");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        Update_Button = new JButton("Update");
        Cancel_Button = new JButton("Cancel");

        AdminID_Label = new JLabel("Enter Admin ID to be updated");
        AdminIDValidity_Label = new JLabel();
        AdminID_TextField = new JTextField();

        AdminID_TextField.setPreferredSize(new Dimension(240, 22));

        AdminIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Update_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        AdminIDValidity_Label.setForeground(Color.red);

        add(AdminID_Label);
        add(AdminID_TextField);
        add(AdminIDValidity_Label);

        add(Update_Button);
        add(Cancel_Button);

        Update_Button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                String AdminID = AdminID_TextField.getText().trim();

                if (!AdminID.isEmpty()) {
                    try {
                        if (Integer.parseInt(AdminID) > 0) {
                            AdminIDValidity_Label.setText("");
                        } else {
                            AdminID = null;
                            AdminIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        AdminID = null;
                        AdminIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    AdminID = null;
                    AdminIDValidity_Label.setText("Enter Home ID !");
                }

                if (AdminID != null) {
                    admin = Admin.SearchByID(Integer.parseInt(AdminID));
                    if (admin != null) {
                        Admin_UpdateInner cui = new Admin_UpdateInner();
                        cui.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Admin ID not found !");
                    }
                } else {
                    AdminIDValidity_Label.setText("Enter Admin ID !");
                }
            }
        }
        );
        Cancel_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private class Admin_UpdateInner extends JFrame {

        JButton Update_Button, Cancel_Button;
        //int ID, String SSN, String Name, String Contact_No, String username, String password, String email
        JTextField SSN_TextField , Name_TextField , Contact_No_TextField , username_TextField , password_TextField , email_TextField;
        

        public Admin_UpdateInner() {
            super("Update Home");
            setLayout(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            setSize(new Dimension(500, 475));
            setResizable(false);
            setLocationRelativeTo(this);

            Update_Button = new JButton("Update");
            Cancel_Button = new JButton("Cancel");
            
            Update_Button.setBounds(100, 400, 100, 30);
            Cancel_Button.setBounds(300, 400, 100, 30);
            
            int TodaysYear = new Date().getYear() + 1900;
            int noOfYears = TodaysYear - 1949;
            String[] Years = new String[noOfYears];
            for (int i = 0; i < noOfYears; i++) {
                Years[i] = TodaysYear - i + "";
            }


            SSN_TextField = new JTextField(admin.getSSN());
            SSN_TextField.setBounds(50, 25, 200, 25);
            
            Name_TextField = new JTextField(admin.getName());
            Name_TextField.setBounds(50, 75, 200, 25);
            
            Contact_No_TextField = new JTextField(admin.getContact_No());
            Contact_No_TextField.setBounds(50, 125, 200, 25);
            
            username_TextField = new JTextField(admin.getUsername());
            username_TextField.setBounds(50, 175, 200, 25);
            
            password_TextField = new JTextField(admin.getPassword());
            password_TextField.setBounds(50, 225, 200, 25);
            
            email_TextField = new JTextField(admin.getEmail());
            email_TextField.setBounds(50, 275, 200, 25);
            

            add(SSN_TextField);
            add(Name_TextField); 
            add(Contact_No_TextField); 
            add(username_TextField); 
            add(password_TextField); 
            add(email_TextField);
            add(Update_Button);
            add(Cancel_Button);

            Update_Button.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    String AdminID = AdminID_TextField.getText().trim();
                    int AdminIDINT = Integer.parseInt(AdminID);
                    String SSN = SSN_TextField.getText().trim();
                    String Name = Name_TextField.getText().trim();
                    String Contact = Contact_No_TextField.getText().trim();
                    String username = username_TextField.getText().trim();
                    String password = password_TextField.getText().trim();
                    String email = email_TextField.getText().trim();
                    
                                      try {
                                          
                            admin = new Admin(admin.getID() , SSN , Name , Contact , username , password , email);
                            admin.Update();
                            JOptionPane.showMessageDialog(null, "Record Successfully Updated !");
                            dispose();

                    } catch (HeadlessException | NumberFormatException ex) {
                        System.out.println(ex);
                    }
                }
                   String Location = SSN_TextField.getText().trim();
            }
            );
            Cancel_Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }
    }
         
}
