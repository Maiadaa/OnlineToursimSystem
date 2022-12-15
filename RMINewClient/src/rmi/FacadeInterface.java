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
    public personInterface getPerson() throws RemoteException;
    public void setPerson (int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException;
    public personDTOFacade editPerson(personDTOFacade dto) throws RemoteException;
    public personDTOFacade getPersonDTO() throws RemoteException;
    public personDTOFacade setPersonDTO(String phone, String address, String username, String password) throws RemoteException;
}
