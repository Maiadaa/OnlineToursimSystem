/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.FacadeInterface;
import rmi.personDTOFacade;

/**
 *
 * @author Lenovo
 */
public class account_facade extends UnicastRemoteObject implements FacadeInterface{
    person c;
    
    public account_facade() throws RemoteException{
        c = new person("","","","");
    }
    
    public personDTOFacade getPersonDTO() throws RemoteException {        
        personDTO dto=new personDTO(c.getPhone(), c.getAddress(), c.getUsername(), c.getPassword());
        return dto;
    }

    @Override
    public person getPerson() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setPerson(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException {
        c.setFname(Fname);
        c.setLname(Lname);
        c.setGender(gender);
        c.setGender(gender);
        c.setAge(age);
        c.setEmail(email);
        c.setPhone(phone);
        c.setAddress(address);
        c.setUsername(username);
        c.setPassword(password);
    }

    @Override
    public personDTOFacade editPerson(personDTOFacade d) throws RemoteException {
        d.editPerson();
        return d;
    }

    @Override
    public personDTOFacade setPersonDTO(String phone, String address, String username, String password) throws RemoteException {
        personDTO dto = new personDTO(phone, address, username, password);
        dto.setAddress(address);
        dto.setPhone(phone);
        dto.setUsername(username);
        dto.setPassword(password);       
        return dto;
    }
}
