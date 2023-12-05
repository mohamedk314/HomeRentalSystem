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

public class DeleteAdmin extends JFrame{
    JButton Remove_Button, Cancel_Button;
    JLabel Admin_ID_LABEL, AdminIDValidity_Label;
    JTextField AdminID_TextField;

    private Admin admin;

    public DeleteAdmin() {
        super("Remove Admin");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        

        Remove_Button = new JButton("Remove");
        Cancel_Button = new JButton("Cancel");

        Admin_ID_LABEL = new JLabel("Enter Admin ID to be removed");
        AdminIDValidity_Label = new JLabel();
        AdminID_TextField = new JTextField();

        AdminID_TextField.setPreferredSize(new Dimension(240, 22));

        AdminIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Remove_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        AdminIDValidity_Label.setForeground(Color.red);

        add(Admin_ID_LABEL);
        add(AdminID_TextField);
        add(AdminIDValidity_Label);

        add(Remove_Button);
        add(Cancel_Button);

        Remove_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminID = AdminID_TextField.getText().trim();
                if (!adminID.isEmpty()) {
                    try {
                        if (Integer.parseInt(adminID) > 0) {
                            AdminIDValidity_Label.setText("");

                            Admin admin = Admin.SearchByID(Integer.parseInt(adminID));
                            if (admin != null) {
                                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to remove this Admin \n "
                                        + admin.toString() + "\n Are you sure you want to continue ??", "Confirmation",
                                        JOptionPane.OK_CANCEL_OPTION);
                                if (showConfirmDialog == 0) {
                                    admin.Remove();
                                    removeAll();
//                                    HomeM cd = new HomeM();
                                    dispose();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Admin ID not found !");
                            }
                        } else {
                            adminID = null;
                            AdminIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        adminID = null;
                        AdminIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    adminID = null;
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
        setVisible(true);
    }
}
