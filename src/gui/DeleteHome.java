package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteHome extends JFrame{
    JButton Remove_Button, Cancel_Button;
    JLabel Home_ID_LABEL, HomeIDValidity_Label;
    JTextField HomeID_TextField;

    private Home home;

    public DeleteHome() {
        super("Remove Home");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        

        Remove_Button = new JButton("Remove");
        Cancel_Button = new JButton("Cancel");

        Home_ID_LABEL = new JLabel("Enter Home ID to be removed");
        HomeIDValidity_Label = new JLabel();
        HomeID_TextField = new JTextField();

        HomeID_TextField.setPreferredSize(new Dimension(240, 22));

        HomeIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Remove_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        HomeIDValidity_Label.setForeground(Color.red);

        add(Home_ID_LABEL);
        add(HomeID_TextField);
        add(HomeIDValidity_Label);

        add(Remove_Button);
        add(Cancel_Button);

        Remove_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String homeID = HomeID_TextField.getText().trim();
                if (!homeID.isEmpty()) {
                    try {
                        if (Integer.parseInt(homeID) > 0) {
                            HomeIDValidity_Label.setText("");

                            Home home = Home.SearchByID(Integer.parseInt(homeID));
                            if (home != null) {
                                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to remove this Home \n "
                                        + home.toString() + "\n Are you sure you want to continue ??", "Confirmation",
                                        JOptionPane.OK_CANCEL_OPTION);
                                if (showConfirmDialog == 0) {
                                    home.Remove();
                                    removeAll();
//                                    HomeM cd = new HomeM();
                                    dispose();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Home ID not found !");
                            }
                        } else {
                            homeID = null;
                            HomeIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        homeID = null;
                        HomeIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    homeID = null;
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
        setVisible(true);
    }
}
