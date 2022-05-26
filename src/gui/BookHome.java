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
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class BookHome extends JFrame {
    JButton Update_Button, Cancel_Button;
    JLabel AdminID_Label, HomeIDValidity_Label;
    JTextField HomeID_TextField;
     Home home;
    public BookHome() {
        super("Book Home");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        Update_Button = new JButton("Update");
        Cancel_Button = new JButton("Cancel");

        AdminID_Label = new JLabel("Enter Home ID to be updated");
        HomeIDValidity_Label = new JLabel();
        HomeID_TextField = new JTextField();

        HomeID_TextField.setPreferredSize(new Dimension(240, 22));

        HomeIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Update_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        HomeIDValidity_Label.setForeground(Color.red);

        add(AdminID_Label);
        add(HomeID_TextField);
        add(HomeIDValidity_Label);

        add(Update_Button);
        add(Cancel_Button);

        Update_Button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                String HomeID = HomeID_TextField.getText().trim();

                if (!HomeID.isEmpty()) {
                    try {
                        if (Integer.parseInt(HomeID) > 0) {
                            HomeIDValidity_Label.setText("");
                        } else {
                            HomeID = null;
                            HomeIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        HomeID = null;
                        HomeIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    HomeID = null;
                    HomeIDValidity_Label.setText("Enter Home ID !");
                }

                if (HomeID != null) {
                    home = Home.SearchByID(Integer.parseInt(HomeID));
                    if (home != null) {
                        Book_Inner cui = new Book_Inner();
                        cui.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Home ID not found !");
                    }
                } else {
                    HomeIDValidity_Label.setText("Enter Home ID !");
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

    private class Book_Inner extends JFrame {

        JButton Update_Button, Cancel_Button;
        JTextField BookedBy_Text;
        public Book_Inner() {
            super("Book Home");
            setLayout(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(new Dimension(200, 80));
            setResizable(false);
            setLocationRelativeTo(this);

            Update_Button = new JButton("Update");
            Cancel_Button = new JButton("Cancel");
            
            Update_Button.setBounds(100, 400, 100, 30);
            Cancel_Button.setBounds(300, 400, 100, 30);

              BookedBy_Text.setBounds(50, 250, 50, 20);

            BookedBy_Text = new JTextField(home.getBookedBy());

            add(BookedBy_Text);

            add(Update_Button);
            add(Cancel_Button);

            Update_Button.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    String HomeID = BookedBy_Text.getText().trim();
                    
                                      try {
                            home = new Home();
                            home.setBookedBy(HomeID);
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