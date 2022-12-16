/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Lenovo
 */
public class personDTO extends UnicastRemoteObject implements Serializable, personDTOFacade{
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    private String Phone;
    private String address;
    private String username;
    private String password;
    
    public personDTO (String Phone, String address, String username, String password) throws RemoteException{
        this.Phone = Phone;
        this.address = address;
        this.username = username;
        this.password = password;
}
    public personDTO() throws RemoteException{
        
    }

    @Override
    public String getPhone() throws RemoteException{
        return Phone;
    }

    @Override
    public void setPhone(String Phone) throws RemoteException{
        this.Phone = Phone;
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
    @Override
    public void editPerson (String address, String Phone, String username, String password) throws RemoteException{
        this.setAddress(address);
        this.setPhone(Phone);
        this.setUsername(username);
        this.setPassword(password);
    }
}
