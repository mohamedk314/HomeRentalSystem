package gui;

import java.io.Serializable;

public abstract class Person implements Serializable {

    protected int ID;
    protected String SSN, Name, Contact_No,username,password,email;

    public Person() {}
    public Person(int ID, String SSN, String Name, String Contact_No, String username, String password, String email) {
        this.ID = ID;
        this.SSN = SSN;
        this.Name = Name;
        this.Contact_No = Contact_No;
        this.username = username;
        this.password = password;
        this.email = email;
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
    
    public abstract void Add();
    public abstract void Update();
    public abstract void Remove();
    
    @Override
    public String toString() {
        return "Person{" + "ID=" + ID + ", SSN=" + SSN + ", Name=" + Name + ", Contact_No=" + Contact_No + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean isSSNalid(String ssn) {
        boolean flag = true;
        if (ssn.length() == 14) {
            for (int i = 0; i < ssn.length(); i++) {
                if (!Character.isDigit(ssn.charAt(i))) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean isContactNoValid(String contact) {
        boolean flag = true;
        if (contact.length() == 11) {
            if (contact.substring(0, 3).equals("010") ||
                    contact.substring(0, 3).equals("011") ||
                    contact.substring(0, 3).equals("012") ||
                    contact.substring(0, 3).equals("015")) {
                for (int i = 0; i < contact.length(); i++) {
                    if (!Character.isDigit(contact.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean isNameValid(String Name) {
        boolean flag = false;
        for (int i = 0; i < Name.length(); i++) {

            if (Character.isLetter(Name.charAt(i)) | Name.charAt(i) == ' ') {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean isIDvalid(String ID) {
        boolean flag = true;
        for (int i = 0; i < ID.length(); i++) {
            if (!Character.isDigit(ID.charAt(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if (Integer.parseInt(ID) <= 0) {
                flag = false;
            }
        }
        return flag;
    }
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------