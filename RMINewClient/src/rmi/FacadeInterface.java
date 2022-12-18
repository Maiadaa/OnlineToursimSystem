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
public interface FacadeInterface extends Remote{
    public void setPerson (int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException;
    public personDTO getPersonDTO(int ID) throws RemoteException;
    public personDTO setPersonDTO(String phone, String address, String username, String password) throws RemoteException;
    public person getPersonLogin(String Email, String Password) throws RemoteException;
    public void editPersonDTO (String email, String address, String Phone, String username, String password) throws RemoteException;
    public void editaddressDTO (String email, String address) throws RemoteException;
    public void editPhoneDTO (String email, String Phone) throws RemoteException;
    public void editUsername (String email, String username) throws RemoteException;
    public void editPassword (String email, String password) throws RemoteException;  
}
