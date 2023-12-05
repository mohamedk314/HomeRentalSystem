package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ClientDashboard extends JFrame implements ActionListener{
    JButton Chat = new JButton();
    JButton Book = new JButton();
    JButton UnBook = new JButton();
    Home q = new Home ();
    private static DefaultTableModel tablemodel; 
    JScrollPane Scroll;
    JTable DataTable = new JTable();
    
        public static DefaultTableModel getTablemodel() {
        return tablemodel;
    }
    ClientDashboard(){
        setTitle("Home Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1500,1000);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));
        setLocationRelativeTo (null);
        
        Book.setBounds(435, 900, 275, 40);
        Book.setBackground(Color.white);
        Book.setLabel("Book");
        Book.addActionListener(this);
        add(Book);
        
        UnBook.setBounds(790, 900, 275, 40);
        UnBook.setBackground(Color.white);
        UnBook.setLabel("UnBook");
        UnBook.addActionListener(this);
        add(UnBook);
                
        
        Chat.setBounds(1145, 80, 275, 40);
        Chat.setBackground(Color.white);
        Chat.setLabel("Customer Service");
        Chat.addActionListener(this);
        add(Chat);
        
        
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
        if(e.getSource()==Chat){
//            setVisible(false);
            Clients c = new Clients ();
            LiveChat lc = new LiveChat(c);
        }
        if(e.getSource()==Book){
            BookHome bh = new BookHome ();
//            setVisible(false);
        }
        
        
    }
    
}
