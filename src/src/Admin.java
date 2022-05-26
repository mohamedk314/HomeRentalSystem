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
public class Admin extends Person implements Serializable{

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


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContact_No() {
        return Contact_No;
    }

    public void setContact_No(String Contact_No) {
        this.Contact_No = Contact_No;
    }

    @Override
    public String toString() {
        return "Admin{" + "ID=" + ID + ", SSN=" + SSN + ", Name=" + Name + ", Contact_No=" + Contact_No + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }

    

    public Admin() {
    }

    public Admin(int ID, String SSN, String Name, String Contact_No, String username, String password, String email) {
        super(ID, SSN, Name, Contact_No, username, password, email);
    }


  
    @Override
    public void Add() {
        ArrayList<Admin> admin = Admin.View();
        if (admin.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = admin.get(admin.size() - 1).ID + 1; 
        }
        admin.add(this);
        File file = new File("Admin.bin");
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
            for (int i = 0; i < admin.size(); i++) {
                outputStream.writeObject(admin.get(i));
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

    @Override
    public void Update() {
        ArrayList<Admin> admin = Admin.View();

        
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).ID == ID) {
                admin.set(i, this);
            }
        }

        
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Admin.bin"));
            for (int i = 0; i < admin.size(); i++) {
                outputStream.writeObject(admin.get(i));
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

    @Override
    public void Remove() {

        ArrayList<Admin> admin = Admin.View();
        
        for (int i = 0; i < admin.size(); i++) {
            if ((admin.get(i).ID == ID)) {
                admin.remove(i);
            }
        }
       
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Admin.bin"));
            for (int i = 0; i < admin.size(); i++) {
                outputStream.writeObject(admin.get(i));
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
        public static Admin SearchBySSN(String admin12) {
        ArrayList<Admin> admin = Admin.View();
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).SSN.equalsIgnoreCase(admin12)) {
                return admin.get(i);
            }
        }
        return null;
    }
        public ArrayList<Home> getAllHomes() {
        ArrayList<Home>home = Home.View();
        ArrayList<Home> home1 = new ArrayList<>();
        for (int i = 0; i < home.size(); i++) {
            if (home.get(i).getAdmin().ID == ID) {
                home1.add(home1.get(i));
            }
        }
        return home1;
    }
          public static ArrayList<Admin> View() {
        ArrayList<Admin> AdminList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {

            inputStream = new ObjectInputStream(new FileInputStream("Admin.bin"));
            boolean EOF = false;

            while (!EOF) {
                try {
                    Admin myObj = (Admin) inputStream.readObject();
                    AdminList.add(myObj);
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
        return AdminList;
    }

public boolean Login(String adminusername , String adminpassword) {
        ArrayList<Admin> admin = Admin.View();
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).username.equalsIgnoreCase(adminusername) && admin.get(i).password.equalsIgnoreCase(adminpassword)) {
                return true;
            }
        }
        return false;
    }
public static Admin SearchByID(int id) {
        ArrayList<Admin> admin = Admin.View();
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).ID == id) {
                return admin.get(i);
            }
        }
        return null;
    }
}
