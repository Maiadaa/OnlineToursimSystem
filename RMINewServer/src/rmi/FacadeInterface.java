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
    public person getPerson() throws RemoteException;
    public void setPerson (int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException;
    public personDTO editPerson() throws RemoteException;
    public personDTO getPersonDTO() throws RemoteException;
    public void setPersonDTO(personDTO dto) throws RemoteException;
}
