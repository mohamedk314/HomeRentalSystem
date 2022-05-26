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

public class EditClient extends JFrame{
    JButton Update_Button, Cancel_Button;
    JLabel ClientID_Label, ClientIDValidity_Label;
    JTextField ClientID_TextField;
     Clients client;
    public EditClient() {
        super("Update Client");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        Update_Button = new JButton("Update");
        Cancel_Button = new JButton("Cancel");

        ClientID_Label = new JLabel("Enter Client ID to be updated");
        ClientIDValidity_Label = new JLabel();
        ClientID_TextField = new JTextField();

        ClientID_TextField.setPreferredSize(new Dimension(240, 22));

        ClientIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Update_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        ClientIDValidity_Label.setForeground(Color.red);

        add(ClientID_Label);
        add(ClientID_TextField);
        add(ClientIDValidity_Label);

        add(Update_Button);
        add(Cancel_Button);

        Update_Button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                String AdminID = ClientID_TextField.getText().trim();

                if (!AdminID.isEmpty()) {
                    try {
                        if (Integer.parseInt(AdminID) > 0) {
                            ClientIDValidity_Label.setText("");
                        } else {
                            AdminID = null;
                            ClientIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        AdminID = null;
                        ClientIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    AdminID = null;
                    ClientIDValidity_Label.setText("Enter Client ID !");
                }

                if (AdminID != null) {
                    client = Clients.SearchByID(Integer.parseInt(AdminID));
                    if (client != null) {
                        Client_UpdateInner cui = new Client_UpdateInner();
                        cui.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Client ID not found !");
                    }
                } else {
                    ClientIDValidity_Label.setText("Enter Client ID !");
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

    private class Client_UpdateInner extends JFrame {

        JButton Update_Button, Cancel_Button;
        //int ID, String SSN, String Name, String Contact_No, String username, String password, String email
        JTextField SSN_TextField , Name_TextField , Contact_No_TextField , username_TextField , password_TextField , email_TextField;
        

        public Client_UpdateInner() {
            super("Update Client");
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


            SSN_TextField = new JTextField(client.getSSN());
            SSN_TextField.setBounds(50, 25, 200, 25);
            
            Name_TextField = new JTextField(client.getName());
            Name_TextField.setBounds(50, 75, 200, 25);
            
            Contact_No_TextField = new JTextField(client.getContact_No());
            Contact_No_TextField.setBounds(50, 125, 200, 25);
            
            username_TextField = new JTextField(client.getUsername());
            username_TextField.setBounds(50, 175, 200, 25);
            
            password_TextField = new JTextField(client.getPassword());
            password_TextField.setBounds(50, 225, 200, 25);
            
            email_TextField = new JTextField(client.getEmail());
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
                    String AdminID = ClientID_TextField.getText().trim();
                    int AdminIDINT = Integer.parseInt(AdminID);
                    String SSN = SSN_TextField.getText().trim();
                    String Name = Name_TextField.getText().trim();
                    String Contact = Contact_No_TextField.getText().trim();
                    String username = username_TextField.getText().trim();
                    String password = password_TextField.getText().trim();
                    String email = email_TextField.getText().trim();
                    
                                      try {
                                          
                            client = new Clients(client.getID() , SSN , Name , Contact , username , password , email);
                            client.Update();
                            JOptionPane.showMessageDialog(null, "Record Successfully Updated !");
                            dispose();

                    } catch (HeadlessException | NumberFormatException ex) {
                        System.out.println(ex);
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
    }
}
