/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.FacadeInterface;
import rmi.person;

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

    //@Override
    @Override
    public person getPersonLogin(String Email, String Password) throws RemoteException {
        this.c.setEmail(Email);
        this.c.setPassword(Password);
        
        System.out.println(this.c);
        person p = db.getPerson(this.c);
        return p;
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
    public void editaddressDTO (String email, String address) throws RemoteException {
        //dto.setAddress(address);
        db.editaddressDTO(email, address);
    }
    
    @Override
    public void editPhoneDTO (String email, String Phone) throws RemoteException {
        db.editPhoneDTO(email, Phone);
    }
    
    @Override
    public void editUsername (String email, String username) throws RemoteException{
        db.editUsername(email, username);
    }
    
    @Override
    public void editPassword (String email, String password) throws RemoteException{
        db.editPass(email, password);
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
