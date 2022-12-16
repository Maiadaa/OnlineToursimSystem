/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.FacadeInterface;

public class account_facade extends UnicastRemoteObject implements FacadeInterface{
    person c;
    DBSama db = new DBSama();
    personDTO dto = new personDTO();
    public account_facade() throws RemoteException{
        c = new person("","","","");
    }
    
    @Override
    public personDTO getPersonDTO(int ID) throws RemoteException {        
        dto.getAddress();
        dto.getPassword();
        dto.getPhone();
        dto.getUsername();
        return dto;
    }

    //tested
    @Override
    public void setPerson(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException {
        //person p = new person(ID, Fname, Lname, gender, age, email, phone, address, username, password);
        c.setID(ID);
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
        db.setPerson(c);
    }

    @Override
    public personDTO editPersonDTO (int ID, String address, String Phone, String username, String password) throws RemoteException {
        if (ID == c.getID()){
        dto.setAddress(address);
        dto.setPhone(Phone);
        dto.setUsername(username);
        dto.setPassword(password);
        db.editPersonDTO(ID, dto);
        return dto;
        }
        return null;
    }

    //tested
    @Override
    public personDTO setPersonDTO(int ID, String Phone, String address, String username, String password) throws RemoteException {
        personDTO dt = new personDTO(Phone, address, username, password);
        dt.setID(ID);
        dt.setAddress(address);
        dt.setPhone(Phone);
        dt.setUsername(username);
        dt.setPassword(password); 
        db.setPersonDTO(dt);
        return dt;
    }
}
