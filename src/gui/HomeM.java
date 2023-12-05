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
public class HomeM extends JFrame implements ActionListener{

    JButton Add = new JButton();
    JButton Edit = new JButton();
    JButton Delete = new JButton();
    JButton Back = new JButton();
    JButton Search = new JButton();
    JButton Refresh = new JButton();
    Home q = new Home ();
    private static DefaultTableModel tablemodel; 
    JScrollPane Scroll;
    JTable DataTable = new JTable();
    JTextField Search_text = new JTextField("Search by Home ID");
    
        public static DefaultTableModel getTablemodel() {
        return tablemodel;
    }
    HomeM(){
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
                
        String[] ColumnNames = {"ID","roomcount","bathroomcount","kitchencount","Location","price","BookedBy"};
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
        ArrayList<Home> home = Home.View();
        for (int i = 0; i < home.size(); i++) {
            int ID = home.get(i).getID();
            String BookedBy = home.get(i).getBookedBy();
            int roomcount = home.get(i).getRoom();
            int bathroomcount = home.get(i).getBathroom();
            int kitchencount = home.get(i).getKitchens();
            String Location = home.get(i).getLocation();
            Double price = home.get(i).getPrice();
            Admin admin = home.get(i).getAdmin();

            
             Object[] contents = {ID , roomcount , bathroomcount , kitchencount , Location , price , BookedBy};
             tablemodel.addRow(contents);
            
        }
//        tablemodel.removeRow(3);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DataTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        DataTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        

        
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
        Home h = new Home();
        if(e.getSource()==Back){//Back
            AdminDashboard b = new AdminDashboard();
            setVisible(false);
        }
        if(e.getSource()==Search){
            String ID1 = Search_text.getText().trim();
            int ID = Integer.parseInt(ID1);
            JOptionPane.showMessageDialog(null, h.SearchByID(ID),"Search", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getSource()==Add){
            AddHome z = new AddHome();
             
//             setVisible(false);
        }
        if(e.getSource()==Delete){
        DeleteHome dh = new DeleteHome();
        }
        if(e.getSource()==Refresh){
            setVisible(false);
            HomeM nw = new HomeM();
        }
        if(e.getSource()==Edit){
//            setVisible(false);
            EditHome eh = new EditHome();
        }
        }
    }
    

