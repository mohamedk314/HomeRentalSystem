package gui;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList; 


public class Clients extends Person implements Serializable {

    public Clients() {
        super();
    }

    public Clients(int ID, String SSN, String Name, String Contact_No, String username, String password, String email) {
        super(ID, SSN, Name, Contact_No, username, password, email);
    }

    public int getID() {
        return ID;
    }

    public String getSSN() {
        return SSN;
    }

    public String getName() {
        return Name;
    }

    public String getContact_No() {
        return Contact_No;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Client{" + "ID=" + ID + ", SSN=" + SSN + ", Name=" + Name + ", Contact_No=" + Contact_No + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void Add() {
        ArrayList<Clients> customers = Clients.View();
        if (customers.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = customers.get((customers.size() - 1)).ID + 1; 
        }
        customers.add(this);
        File file = new File("Customer.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            for (int i = 0; i < customers.size(); i++) {
                outputStream.writeObject(customers.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void Update() {
        ArrayList<Clients> customers = Clients.View();

        
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).ID == ID) {
                customers.set(i, this);
            }
        }
        
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Customer.bin"));
            for (int i = 0; i < customers.size(); i++) {
                outputStream.writeObject(customers.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void Remove() {

        ArrayList<Clients> customers = Clients.View();

        
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).ID == ID) {
                customers.remove(i);
            }
        }

        
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Customer.bin"));
            for (int i = 0; i < customers.size(); i++) {
                outputStream.writeObject(customers.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static ArrayList<Clients> SearchByName(String name) {
        ArrayList<Clients> customers = Clients.View();
        ArrayList<Clients> s = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).Name.equalsIgnoreCase(name)) {
                s.add(customers.get(i));
            }
        }
        return s;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static Clients SearchBySSN(String CustomerSSN) {
        ArrayList<Clients> customers = Clients.View();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).SSN.equalsIgnoreCase(CustomerSSN)) {
                return customers.get(i);
            }
        }
        return null;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static Clients SearchByID(int id) {
        ArrayList<Clients> customers = Clients.View();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).ID == id) {
                return customers.get(i);
            }
        }
        return null;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static ArrayList<Clients> View() {
        ArrayList<Clients> CustomerList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {

            inputStream = new ObjectInputStream(new FileInputStream("Customer.bin"));
            boolean EOF = false;

            while (!EOF) {
                try {
                    Clients myObj = (Clients) inputStream.readObject();
                    CustomerList.add(myObj);
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return CustomerList;
    }
 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean Login(String clientusername , String clientpassword) {
        ArrayList<Clients> client = Clients.View();
        for (int i = 0; i < client.size(); i++) {
            if (client.get(i).username.equalsIgnoreCase(clientusername) && client.get(i).password.equalsIgnoreCase(clientpassword)) {
                return true;
            }
        }
        return false;
    }
 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String SearchByIDtoreturnName(int id) {
        ArrayList<Clients> client = Clients.View();
        for (int i = 0; i < client.size(); i++) {
            if (client.get(i).ID == id) {
                return client.get(i).Name;
            }
        }
        return null;
    }
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
