package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminDashboard extends JFrame implements ActionListener{
    JButton Admin = new JButton();
    JButton Clients = new JButton();
    JButton Homes = new JButton();
    JButton Logout = new JButton();
    JButton PieChart = new JButton();
    
    AdminDashboard(){
    setTitle("Home Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(750,500);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));
        setLocationRelativeTo (null);
        
        Admin.setBounds(25, 100, 200, 50);
        Admin.setBackground(Color.white);
        Admin.setLabel("Admin");
        Admin.addActionListener(this);
        add(Admin);
        
        Clients.setBounds(25, 200, 200, 50);
        Clients.setBackground(Color.white);
        Clients.setLabel("Clients");
        Clients.addActionListener(this);
        add(Clients);
        
        Homes.setBounds(25, 300, 200, 50);
        Homes.setBackground(Color.white);
        Homes.setLabel("Homes");
        Homes.addActionListener(this);
        add(Homes);
        
        Logout.setBounds(500, 100, 100, 25);
        Logout.setBackground(Color.white);
        Logout.setLabel("Logout");
        Logout.addActionListener(this);
        add(Logout);
        
        PieChart.setBounds(500, 300, 200, 50);
        PieChart.setBackground(Color.white);
        PieChart.setLabel("View Data");
        PieChart.addActionListener(this);
        add(PieChart);
        
        

//        JLabel L1 = new JLabel("Admins");
//		L1.setForeground(Color.white); //set font color of text
//		L1.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
//		L1.setBounds(90, 25, 500, 80); //set x,y position within frame as well as dimensions
//                add(L1);
//                
//                JLabel L2 = new JLabel("Clients");
//		L2.setForeground(Color.white); //set font color of text
//		L2.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
//		L2.setBounds(320, 25, 500, 80); //set x,y position within frame as well as dimensions
//                add(L2);
//                
//                JLabel L3 = new JLabel("Homes");
//		L3.setForeground(Color.white); //set font color of text
//		L3.setFont(new Font("PLAIN",Font.PLAIN,20)); //set font of text
//		L3.setBounds(540, 25, 500, 80); //set x,y position within frame as well as dimensions
//                add(L3);
        setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Logout){//Back
            Main l = new Main();
        }
        if(e.getSource()==Admin){
            AdminM a = new AdminM();
        }
        if(e.getSource()==Clients){
            ClientM c = new ClientM();
        }
        if(e.getSource()==Homes){
            HomeM h = new HomeM();
        }
        if(e.getSource()==Clients){
            Clients c = new Clients();
        }
        if(e.getSource()==PieChart){
            runChart pc = new runChart ();
        }
        setVisible(false);
    }
}
