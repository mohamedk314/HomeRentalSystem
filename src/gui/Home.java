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

public class Home implements Serializable  {
 private int ID;
    protected String BookedBy = "Not Booked";
    protected int room;
    protected int bathroom;
    protected int kitchens;
    protected String location;
    protected Double price;
       protected Admin admin;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Home()
{
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Home(int ID , String BookedBy, int room, int bathroom, int kitchens, String location, Double price) {
        this.ID = ID;
        this.BookedBy = BookedBy;
        this.room = room;
        this.bathroom = bathroom;
        this.kitchens = kitchens;
        this.location = location;
        this.price = price;
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Home{" + "ID=" + ID + ", BookedBy=" + BookedBy + ", room=" + room + ", bathroom=" + bathroom + ", kitchens=" + kitchens + ", location=" + location + ", price=" + price + ", admin=" + admin + '}';
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBookedBy(String BookedBy) {
        this.BookedBy = BookedBy;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public void setKitchens(int kitchens) {
        this.kitchens = kitchens;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRoom() {
        return room;
    }

    public int getBathoom() {
        return bathroom;
    }

    public String getBookedBy() {
        return BookedBy;
    }

    public int getBathroom() {
        return bathroom;
    }

    public int getKitchens() {
        return kitchens;
    }

    public String getLocation() {
        return location;
    }

    public Double getPrice() {
        return price;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public static ArrayList<Home> View() {
        ArrayList<Home> homelist = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
 
            inputStream = new ObjectInputStream(new FileInputStream("home.ser"));
            boolean EOF = false;

            while (!EOF) {
                try {
                    Home myObj = (Home) inputStream.readObject();
                    homelist.add(myObj);
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
        return homelist;
}    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public void Add() {
        ArrayList<Home> home = Home.View();
        if (home.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = home.get(home.size() - 1).ID + 1;
        }
        home.add(this);
        File file = new File("home.ser");
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
            for (int i = 0; i < home.size(); i++) {
                outputStream.writeObject(home.get(i));
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
public void Update() {
        ArrayList<Home> home = Home.View();
       
        for (int i = 0; i < home.size(); i++) {
            if (home.get(i).ID == ID) {
                home.set(i, this);
            }
        }
       
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("home.ser"));
            for (int i = 0; i < home.size(); i++) {
                outputStream.writeObject(home.get(i));
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
public void Remove() {
        ArrayList<Home> home = Home.View();
       
        for (int i = 0; i < home.size(); i++) {
            if ((home.get(i).ID == ID)) {
                home.remove(i);
            }
        }
       
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("home.ser"));
            for (int i = 0; i < home.size(); i++) {
                outputStream.writeObject(home.get(i));
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
public static Home SearchByID(int id) {
        ArrayList<Home> home = Home.View();
        for (int i = 0; i < home.size(); i++) {
            if (home.get(i).ID == id) {
                return home.get(i);
            }
        }
        return null;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public static void DeletebyID(int id) {
        ArrayList<Home> homelist = Home.View();
        ObjectInputStream inputStream = null;
            for (int i = 0; i < homelist.size(); i++) {
            if (homelist.get(i).ID == id) {
                homelist.remove(i);
            }
        }
        }
}        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------