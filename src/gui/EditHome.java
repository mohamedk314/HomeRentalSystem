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

public class EditHome extends JFrame {
    JButton Update_Button, Cancel_Button;
    JLabel AdminID_Label, HomeIDValidity_Label;
    JTextField HomeID_TextField;
     Home home;
    public EditHome() {
        super("Update Home");
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
                        Home_UpdateInner cui = new Home_UpdateInner();
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

    private class Home_UpdateInner extends JFrame {

        JButton Update_Button, Cancel_Button;
        JTextField Location_TextField , BookedBy_Text;

        JSpinner RoomCount_Spinner , BathroomCount_Spinner , KitchenCount_Spinner , Price_Spinner ;

        public Home_UpdateInner() {
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

            RoomCount_Spinner = new JSpinner();
            RoomCount_Spinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
            RoomCount_Spinner.setFocusable(false);
            
            BathroomCount_Spinner = new JSpinner();
            BathroomCount_Spinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
            BathroomCount_Spinner.setFocusable(false);
            
            KitchenCount_Spinner = new JSpinner();
            KitchenCount_Spinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
            KitchenCount_Spinner.setFocusable(false);
            
            Price_Spinner = new JSpinner();
            Price_Spinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
            Price_Spinner.setFocusable(false);
            
//            BookedBy_Text = new JSpinner();
//            BookedBy_Text.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
//            BookedBy_Text.setFocusable(false);

              RoomCount_Spinner.setBounds(50, 50, 50, 20);
              BathroomCount_Spinner.setBounds(50, 100, 50, 20);
              KitchenCount_Spinner.setBounds(50, 150, 50, 20);
              Price_Spinner.setBounds(50, 200, 50, 20);
              BookedBy_Text.setBounds(50, 250, 50, 20);

            RoomCount_Spinner.setValue(home.getRoom());
            KitchenCount_Spinner.setValue(home.getKitchens());
            BathroomCount_Spinner.setValue(home.getBathroom());
            Price_Spinner.setValue(home.getPrice());
            BookedBy_Text = new JTextField(home.getBookedBy());
            Location_TextField = new JTextField(home.getLocation());
            Location_TextField.setBounds(50, 300, 200, 25);

            add(Location_TextField);
            add(RoomCount_Spinner);
            add(KitchenCount_Spinner);
            add(BathroomCount_Spinner);
            add(Price_Spinner);
            add(BookedBy_Text);

            add(Update_Button);
            add(Cancel_Button);

            Update_Button.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    String HomeID = HomeID_TextField.getText().trim();
                    int HomeIDINT = Integer.parseInt(HomeID);
                    String Location = Location_TextField.getText().trim();
                                      try {

                            home = new Home(home.getID() ,BookedBy_Text.getText(),
                            Integer.parseInt(RoomCount_Spinner.getValue()+""),
                            Integer.parseInt(BathroomCount_Spinner.getValue()+"") ,Integer.parseInt(KitchenCount_Spinner.getValue()+"" )
                                    , Location ,Double.parseDouble(Price_Spinner.getValue()+""));
                            home.Update();
                            JOptionPane.showMessageDialog(null, "Record Successfully Updated !");
                            dispose();

                    } catch (HeadlessException | NumberFormatException ex) {
                        System.out.println(ex);
                    }
                }
                   String Location = Location_TextField.getText().trim();
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