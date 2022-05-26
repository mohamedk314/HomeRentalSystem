package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ClientM extends JFrame implements ActionListener{

    JButton Add = new JButton();
    JButton Edit = new JButton();
    JButton Delete = new JButton();
    JButton Back = new JButton();
    JButton Search = new JButton();
    JButton Refresh = new JButton();
    private static DefaultTableModel tablemodel; 
    JScrollPane Scroll;
    JTable DataTable = new JTable();
    JTextField Search_text = new JTextField("Search by Home ID");
    Clients c = new Clients();
        public static DefaultTableModel getTablemodel() {
        return tablemodel;
    }
    ClientM(){
        setTitle("Home Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1500,1000);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));
        setLocationRelativeTo (null);
        
        Back.setBounds(80, 900, 275, 50);
        Back.setBackground(Color.white);
        Back.setLabel("Back");
        Back.addActionListener(this);
        add(Back);
        
        Add.setBounds(435, 900, 275, 40);
        Add.setBackground(Color.white);
        Add.setLabel("Add");
        Add.addActionListener(this);
        add(Add);
        
        Edit.setBounds(790, 900, 275, 40);
        Edit.setBackground(Color.white);
        Edit.setLabel("Edit");
        Edit.addActionListener(this);
        add(Edit);
        
        Delete.setBounds(1145, 900, 275, 40);
        Delete.setBackground(Color.white);
        Delete.setLabel("Delete");
        Delete.addActionListener(this);
        add(Delete);
        
        Search.setBounds(1145, 80, 275, 40);
        Search.setBackground(Color.white);
        Search.setLabel("Search");
        Search.addActionListener(this);
        add(Search);
        
        Refresh.setBounds(50,80, 275, 40);
        Refresh.setBackground(Color.white);
        Refresh.setLabel("Refresh");
        Refresh.addActionListener(this);
        add(Refresh);
         
                Search_text.setBounds(335, 80, 800, 40);
                add(Search_text);
                
        String[] ColumnNames = {"ID","SSN","Contact_No","username","password","email"};
        //String SSN, Name, Contact_No,username,password,email;
        Scroll = new JScrollPane();
        DataTable = new JTable();

        tablemodel = new DefaultTableModel(ColumnNames, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
               
                return false;
            }
        };
        
        
        DataTable = new JTable(getTablemodel());

        Scroll = new JScrollPane();
        Scroll.setViewportView(DataTable);
        DataTable.setFillsViewportHeight(true);
        ArrayList<Clients> client = Clients.View();
        for (int i = 0; i < client.size(); i++) {
            int ID = client.get(i).getID();
            String SSN = client.get(i).getSSN();
            String Contact_No = client.get(i).getContact_No();
            String username = client.get(i).getUsername();
            String password = client.get(i).getPassword();
            String email = client.get(i).getEmail();

            
             Object[] contents = {ID , SSN , Contact_No , username , password , email };
             tablemodel.addRow(contents);
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DataTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        
//        DataTable.getColumnModel().getColumn(0).setMinWidth(20);
//        DataTable.getColumnModel().getColumn(1).setMinWidth(20);
//        DataTable.getColumnModel().getColumn(2).setMinWidth(170);
//        DataTable.getColumnModel().getColumn(3).setMinWidth(170);
//        DataTable.getColumnModel().getColumn(4).setMinWidth(140);
//        DataTable.getColumnModel().getColumn(5).setMinWidth(150);
//        DataTable.getColumnModel().getColumn(6).setMinWidth(90);
//       

        DataTable.getTableHeader().setReorderingAllowed(false);
        Scroll.setBounds(50, 130, 1400, 720);
        add(Scroll);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){//Back
            AdminDashboard b = new AdminDashboard();
            setVisible(false);
        }
        if(e.getSource()==Delete){
            DeleteClient dcc = new DeleteClient();
        }
        if(e.getSource()==Refresh){
            setVisible(false);
            ClientM rfrsh = new ClientM();
        }
        if(e.getSource()==Add){
            AddClient ac = new AddClient();
        }
        if(e.getSource()==Edit){
            EditClient ec = new EditClient ();
        }
        if(e.getSource()==Search){
            String ID1 = Search_text.getText().trim();
            int ID = Integer.parseInt(ID1);
            JOptionPane.showMessageDialog(null, c.SearchByID(ID),"Search", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
}
