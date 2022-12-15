/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lenovo
 */
public interface personInterface extends Remote {
    public int getID() throws RemoteException;
    public void setID(int ID) throws RemoteException;
    public String getFname() throws RemoteException;
    public void setFname(String Fname) throws RemoteException;
    public String getLname() throws RemoteException;
    public void setLname(String Lname) throws RemoteException;
    public String getGender() throws RemoteException;
    public void setGender(String gender) throws RemoteException;
    public int getAge() throws RemoteException;
    public void setAge(int age) throws RemoteException;
    public String getEmail() throws RemoteException;
    public void setEmail(String email) throws RemoteException;
    public String getPhone() throws RemoteException;
    public void setPhone(String phone) throws RemoteException;
    public String getAddress() throws RemoteException;
    public void setAddress(String address) throws RemoteException;
    public String getUsername() throws RemoteException;
    public void setUsername(String username) throws RemoteException;
    public String getPassword() throws RemoteException; 
    public void setPassword(String password) throws RemoteException;
}
