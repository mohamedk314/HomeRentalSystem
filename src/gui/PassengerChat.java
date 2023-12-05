package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PassengerChat extends JFrame implements Runnable{


    Socket socket;
    int port;
    String name;
    JTextArea textArea = new JTextArea(40, 50);

    public PassengerChat(int port, String name) throws IOException {
        this.port = port;
        this.name = name;
        socket = new Socket("localhost", port);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        JPanel panel = new JPanel();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JTextField textField = new JTextField(40);
        JButton button = new JButton("send");

        button.addActionListener(e->{
            try {
                String str = name+":"+textField.getText();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(str);
                textArea.append( str + "  (SENT)" + "\n");
                textField.setText("");
            } catch (IOException ex) {
                Logger.getLogger(PassengerChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);


        panel.add(scrollPane);
        panel.add(textField);
        panel.add(button);
        add(panel);
        setVisible(true);
        setTitle(name);


    }

    @Override
    public void run() {
        try {
            while(true){
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = "";
                str = bf.readLine();
                textArea.append(str + "   (RECEIVED)" + "\n");
                System.out.println("sent message");


            }
        } catch (IOException ex) {
            Logger.getLogger(PassengerChat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public  String getName() {
        return name;
    }

}