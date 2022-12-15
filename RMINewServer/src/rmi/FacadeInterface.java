/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import rminewserver.person;
import rminewserver.personDTO;
/**
 *
 * @author Lenovo
 */
public interface FacadeInterface extends Remote{
    public person getPerson(int ID) throws RemoteException;
    public void setPerson (int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException;
    public personDTO editPerson(String address, String Phone, String username, String password) throws RemoteException;
    public personDTO getPersonDTO(int ID) throws RemoteException;
    public personDTO setPersonDTO(String phone, String address, String username, String password) throws RemoteException;
}
