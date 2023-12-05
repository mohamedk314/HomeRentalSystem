package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class serverChat extends JFrame implements Runnable {
    int port;
    ServerSocket serverSocket;
    JTextArea textArea = new JTextArea(40, 50);
    public serverChat(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        JPanel panel = new JPanel();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JTextField textField = new JTextField(40);
        JButton button = new JButton("send");
        JScrollPane scrollPane = new JScrollPane(textArea);


        panel.add(scrollPane);
        panel.add(textField);
        panel.add(button);
        add(panel);
//        setVisible(true);
        setTitle("Server");
    }


    @Override
    public void run(){
        while(true){
            try {
                Socket socket1 = serverSocket.accept();
                PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
                BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                System.out.println("connected");

                Socket socket2 = serverSocket.accept();
                PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);
                BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                System.out.println("connected");

                String msg1, msg2;
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            String msg1 = "";
                            try {

                                msg1 = in1.readLine();
                                textArea.append("User 1" + msg1 + "\n");
                            } catch (IOException ex) {
                                Logger.getLogger(serverChat.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out2.println(msg1);

                        }
                    }

                }).start();

                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            String msg1 = "";
                            try {

                                msg1 = in2.readLine();
                                textArea.append("User 2" + msg1 + "\n");
                            } catch (IOException ex) {
                                Logger.getLogger(serverChat.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out1.println(msg1);

                        }
                    }

                }).start();



            } catch (IOException ex) {
                Logger.getLogger(serverChat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}