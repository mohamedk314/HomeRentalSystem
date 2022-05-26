package gui;

import gui.Clients;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LiveChat extends JFrame {
public  LiveChat(Clients client)
{
    try
    {
        setVisible(false);
        serverChat server = new serverChat(6969);
        Thread t = new Thread(server);
        t.start();
        PassengerChat user1 = new PassengerChat(6969, client.getName());
        PassengerChat user2 = new PassengerChat(6969, "Admin");
        Thread t1 = new Thread(user1);
        Thread t2 = new Thread(user2);
        t1.start();
        t2.start();
    } catch (IOException ex)
    {
        Logger.getLogger(LiveChat.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}