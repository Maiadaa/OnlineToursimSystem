package rminewserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class person extends UnicastRemoteObject{
    
    private int ID;
    private String Fname;
    private String Lname;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;

    public person() throws RemoteException{
    }

    public person(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public person(String phone, String address, String username, String password) throws RemoteException{
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }
    
    public int getID() throws RemoteException{
        return ID;
    }

    public void setID(int ID) throws RemoteException{
        this.ID = ID;
    }

    public String getFname() throws RemoteException{
        return Fname;
    }

    public void setFname(String Fname) throws RemoteException{
        this.Fname = Fname;
    }

    public String getLname() throws RemoteException{
        return Lname;
    }

    public void setLname(String Lname) throws RemoteException{
        this.Lname = Lname;
    }

    public String getGender() throws RemoteException{
        return gender;
    }

    public void setGender(String gender) throws RemoteException{
        this.gender = gender;
    }

    public int getAge() throws RemoteException{
        return age;
    }

    public void setAge(int age) throws RemoteException{
        this.age = age;
    }

    public String getEmail() throws RemoteException{
        return email;
    }
    
    public void setEmail(String email) throws RemoteException{
        this.email = email;
    }

    public String getPhone() throws RemoteException{
        return phone;
    }

    public void setPhone(String phone) throws RemoteException{
        this.phone = phone;
    }

    public String getAddress() throws RemoteException{
        return address;
    }

    public void setAddress(String address) throws RemoteException{
        this.address = address;
    }

    public String getUsername() throws RemoteException{
        return username;
    }

    public void setUsername(String username) throws RemoteException{
        this.username = username;
    }

    public String getPassword() throws RemoteException{
        return password;
    }

    public void setPassword(String password) throws RemoteException{
        this.password = password;
    }
}
