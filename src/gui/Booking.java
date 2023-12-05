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


public class Booking implements Serializable {

    private int ID;
    private Clients customers;
    private Home home;
    private long RentTime, ReturnTime;

    public Booking() {
    }

    public Booking(int ID, Clients customer,Home home, long RentTime, long ReturnTime) {
        this.ID = ID;
        this.customers = customer;
        this.home = home;
        this.RentTime = RentTime;
        this.ReturnTime = ReturnTime;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Booking{" + "ID=" + ID + ", customer=" + customers + ", home=" + home + ", RentTime=" + RentTime + ", ReturnTime=" + ReturnTime + '}';
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Clients getCustomers() {
        return customers;
    }

    public void setCustomers(Clients customers) {
        this.customers = customers;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public long getRentTime() {
        return RentTime;
    }

    public void setRentTime(long RentTime) {
        this.RentTime = RentTime;
    }

    public long getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(long ReturnTime) {
        this.ReturnTime = ReturnTime;
    }

   

    public void Add() {
        ArrayList<Booking> booking = Booking.View();
        if (booking.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = booking.get(booking.size() - 1).ID + 1;
        }
        this.ReturnTime = 0;
        booking.add(this);
        File file = new File("Booking.ser");
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
            for (int i = 0; i < booking.size(); i++) {
                outputStream.writeObject(booking.get(i));
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

    public void Update() {
        ArrayList<Booking> booking = Booking.View();

       
        for (int i = 0; i < booking.size(); i++) {
            if (booking.get(i).ID == ID) {
                booking.set(i, this);
            }
        }
       
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Booking.ser"));
            for (int i = 0; i < booking.size(); i++) {
                outputStream.writeObject(booking.get(i));
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

    public void Remove() {

        ArrayList<Booking> booking = Booking.View();
       
        for (int i = 0; i < booking.size() - 1; i++) {
            if ((booking.get(i).ID == ID)) {

                for (int j = i; j < booking.size() - 1; j++) {
                    booking.set(j, (booking.get(j + 1)));
                }

            }
        }
       
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Booking.ser"));
            for (int i = 0; i < booking.size() - 1; i++) {
                outputStream.writeObject(booking.get(i));
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
//yastaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa e7sb el 7sab hana
//    public int calculateBill() {
//      
//        long rentTime = this.getRentTime();
//        long returnTime = this.getReturnTime();
//        long totalTime = returnTime - rentTime;
//        totalTime = totalTime / (1000 * 60 * 60);
//
//        int rentPerHour = this.getCar().getRentPerHour();
//        if (totalTime != 0) {
//            return (int) (rentPerHour * totalTime);
//        } else {
//            return rentPerHour;
//        }
//    }
    
   

    public static ArrayList<Booking> SearchByCustomerID(int CustomerID) {
        ArrayList<Booking> bookingList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {

            inputStream = new ObjectInputStream(new FileInputStream("Booking.ser"));
            boolean EOF = false;

            while (!EOF) {
                try {
                    Booking myObj = (Booking) inputStream.readObject();
                    if (myObj.customers.getID() == CustomerID) {
                        bookingList.add(myObj);
                    }
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
        return bookingList;
    }

   
    public static ArrayList<Booking> SearchByHomeID(int homeID) {
        ArrayList<Booking> bookingList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {

            inputStream = new ObjectInputStream(new FileInputStream("Booking.ser"));
            boolean EOF = false;

            while (!EOF) {
                try {
                    Booking myObj = (Booking) inputStream.readObject();
                    if (myObj.home.getID() == homeID) {
                        bookingList.add(myObj);
                    }
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
        return bookingList;
    }

    public static ArrayList<Booking> View() {
        ArrayList<Booking> bookingList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {

            inputStream = new ObjectInputStream(new FileInputStream("Booking.ser"));
            boolean EOF = false;

            while (!EOF) {
                try {
                    Booking myObj = (Booking) inputStream.readObject();
                    bookingList.add(myObj);
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
        return bookingList;
    }

    public static ArrayList<Home> getBookedCars() {
        ArrayList<Home> bookedHomes = new ArrayList<>();
        ArrayList<Booking> bookings = Booking.View();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).ReturnTime == 0) {
                bookedHomes.add(bookings.get(i).home);
            }
        }
        return bookedHomes;
    }

    public static ArrayList<Home> getUnbookedCars() {
        ArrayList<Home> allHomes = Home.View();
        ArrayList<Home> bookedHomes = Booking.getBookedCars();
        for (int i = 0; i < bookedHomes.size(); i++) {
            allHomes.remove(bookedHomes.get(i));
        }
        return allHomes;
    }
}