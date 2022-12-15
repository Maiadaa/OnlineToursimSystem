package rminewserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.personInterface;

public class person extends UnicastRemoteObject implements personInterface{
    
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
    
    @Override
    public int getID() throws RemoteException{
        return ID;
    }

    @Override
    public void setID(int ID) throws RemoteException{
        this.ID = ID;
    }

    @Override
    public String getFname() throws RemoteException{
        return Fname;
    }

    @Override
    public void setFname(String Fname) throws RemoteException{
        this.Fname = Fname;
    }

    @Override
    public String getLname() throws RemoteException{
        return Lname;
    }

    @Override
    public void setLname(String Lname) throws RemoteException{
        this.Lname = Lname;
    }

    @Override
    public String getGender() throws RemoteException{
        return gender;
    }

    @Override
    public void setGender(String gender) throws RemoteException{
        this.gender = gender;
    }

    @Override
    public int getAge() throws RemoteException{
        return age;
    }

    @Override
    public void setAge(int age) throws RemoteException{
        this.age = age;
    }

    @Override
    public String getEmail() throws RemoteException{
        return email;
    }

    @Override
    public void setEmail(String email) throws RemoteException{
        this.email = email;
    }

    @Override
    public String getPhone() throws RemoteException{
        return phone;
    }

    @Override
    public void setPhone(String phone) throws RemoteException{
        this.phone = phone;
    }

    @Override
    public String getAddress() throws RemoteException{
        return address;
    }

    @Override
    public void setAddress(String address) throws RemoteException{
        this.address = address;
    }

    @Override
    public String getUsername() throws RemoteException{
        return username;
    }

    @Override
    public void setUsername(String username) throws RemoteException{
        this.username = username;
    }

    @Override
    public String getPassword() throws RemoteException{
        return password;
    }

    @Override
    public void setPassword(String password) throws RemoteException{
        this.password = password;
    }
}
