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
public interface personDTOFacade extends Remote{
    public String getPhone() throws RemoteException;
    public void setPhone(String Phone) throws RemoteException;
    public String getAddress() throws RemoteException;
    public void setAddress(String address)  throws RemoteException;
    public String getUsername()  throws RemoteException;
    public void setUsername(String username)  throws RemoteException;
    public String getPassword() throws RemoteException;
    public void setPassword(String password) throws RemoteException;
    public void editPerson(String address, String Phone, String username, String password) throws RemoteException;
}