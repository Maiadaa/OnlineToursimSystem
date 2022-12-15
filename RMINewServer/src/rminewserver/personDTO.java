/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.personDTOFacade;
/**
 *
 * @author Lenovo
 */
public class personDTO extends UnicastRemoteObject implements Serializable, personDTOFacade{
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

    public String getPhone() throws RemoteException{
        return Phone;
    }

    public void setPhone(String Phone) throws RemoteException{
        this.Phone = Phone;
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
    public void editPerson() throws RemoteException{
        this.setAddress(address);
        this.setPhone(Phone);
        this.setUsername(username);
        this.setPassword(password);
    }
}
