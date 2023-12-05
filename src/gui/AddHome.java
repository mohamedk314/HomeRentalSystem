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


public class AddHome extends JFrame implements ActionListener{
    JButton Save = new JButton("Save");
    JButton Cancel = new JButton("Cancel");
    Home h = new Home ();
    
    JTextField roomcount_Text = new JTextField("");
    JTextField bathroomcount_Text = new JTextField("");
    JTextField kitchencount_Text = new JTextField("");
    JTextField Location_Text = new JTextField("");
    JTextField price_Text = new JTextField("");
    JTextField BookedBy_Text = new JTextField("Not Booked");
    AddHome(){
setTitle("Add new Home");
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
        
        
        JLabel roomcount = new JLabel("roomcount");
		roomcount.setForeground(Color.BLACK); //set font color of text
		roomcount.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		roomcount.setBounds(20, 25, 500, 80); //set x,y position within frame as well as dimensions
                add(roomcount);
                
                JLabel bathroomcount = new JLabel("bathroomcount");
		bathroomcount.setForeground(Color.BLACK); //set font color of text
		bathroomcount.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		bathroomcount.setBounds(20, 100, 500, 80); //set x,y position within frame as well as dimensions
                add(bathroomcount);
                
                JLabel kitchencount = new JLabel("kitchencount");
		kitchencount.setForeground(Color.BLACK); //set font color of text
		kitchencount.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		kitchencount.setBounds(20, 175, 500, 80); //set x,y position within frame as well as dimensions
                add(kitchencount);
                
                JLabel Location = new JLabel("Location");
		Location.setForeground(Color.BLACK); //set font color of text
		Location.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		Location.setBounds(20, 250, 500, 80); //set x,y position within frame as well as dimensions
                add(Location);

                JLabel price = new JLabel("price");
		price.setForeground(Color.BLACK); //set font color of text
		price.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		price.setBounds(20, 325, 325, 80); //set x,y position within frame as well as dimensions
                add(price);

                JLabel BookedBy = new JLabel("BookedBy");
		BookedBy.setForeground(Color.BLACK); //set font color of text
		BookedBy.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		BookedBy.setBounds(20, 400, 500, 80); //set x,y position within frame as well as dimensions
                add(BookedBy);
                
                
                
                
                
                
                
		roomcount_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		roomcount_Text.setBounds(180, 55, 200, 25); //set x,y position within frame as well as dimensions
                add(roomcount_Text);
                
                
		bathroomcount_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		bathroomcount_Text.setBounds(180, 130, 200, 25); //set x,y position within frame as well as dimensions
                add(bathroomcount_Text);
                
                
		kitchencount_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		kitchencount_Text.setBounds(180, 205, 200, 25); //set x,y position within frame as well as dimensions
                add(kitchencount_Text);
                
                
		Location_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		Location_Text.setBounds(180, 280, 200, 25); //set x,y position within frame as well as dimensions
                add(Location_Text);

                
		price_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		price_Text.setBounds(180, 355, 200, 25); //set x,y position within frame as well as dimensions
                add(price_Text);

                
		BookedBy_Text.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
		BookedBy_Text.setBounds(180, 430, 200, 25); //set x,y position within frame as well as dimensions
                add(BookedBy_Text);
        
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==Cancel){
            setVisible(false);
        }
        if(e.getSource()==Save){
            if(roomcount_Text.getText().isEmpty() || bathroomcount_Text.getText().isEmpty() || kitchencount_Text.getText().isEmpty() || Location_Text.getText().isEmpty()
                    || price_Text.getText().isEmpty() || BookedBy_Text.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                String roomcount1 = roomcount_Text.getText().trim() , bathroomcount1 = bathroomcount_Text.getText().trim() , kitchencount1 = kitchencount_Text.getText().trim() ;
                String Location1 = Location_Text.getText().trim() , price1 = price_Text.getText().trim() , BookedBy1 = BookedBy_Text.getText().trim();
                h.setRoom(Integer.parseInt(roomcount1));
                h.setBathroom(Integer.parseInt(bathroomcount1));
                h.setKitchens(Integer.parseInt(kitchencount1));
                h.setLocation(Location1);
                h.setPrice(Double.parseDouble(price1));
                h.setBookedBy(BookedBy1);
                h.Add();
                JOptionPane.showMessageDialog(null, "The report has been added", "Well Done", JOptionPane.INFORMATION_MESSAGE);
//                HomeM H = new HomeM ();
            }
            setVisible(false);
        }
    }
}
