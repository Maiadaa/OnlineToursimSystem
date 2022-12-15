/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Lenovo
 */
public class account_facade {
    person c;
    
    public account_facade() throws RemoteException{
        c = new person("","","","");
    }
    public void getPerson(){
        
    }
    public void setPerson(person person){
        
    }
    public void editPerson(person person){
        
    }
    public void getPeronDTO (personDTO dto){
        
    }
    public void setPerson(personDTO dto){
        
    }
    public personDTO getCourse() throws RemoteException {
        
        personDTO dto=new personDTO(c.getTitle(), c.getDescription());
        return dto;
    }

    
}
