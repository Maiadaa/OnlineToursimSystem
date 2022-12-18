/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.client;
import rmi.subject_interface;
import static rminewserver.DBAssem.gson;

/**
 *
 * @author mahmo
 */
public class Observer extends UnicastRemoteObject implements subject_interface  {
    
    DBAssem db = new DBAssem();
    private ArrayList <rmi.client> sysClients = new ArrayList <rmi.client>();

    public Observer() throws RemoteException {
    }
    
    
    @Override
     public void addObserver(int id, String fname, String lname, String gender,String email, String phone,String username, String password, int cardnum ) throws RemoteException{
        rmi.client c1 = new rmi.client();
        c1.setFname(fname);
        c1.setLname(lname);
        c1.setID(id);
        c1.setGender(gender);
        c1.setUsername(username);
        c1.setEmail(email);
        c1.setPassword(password);
        c1.setPhone(phone);
        c1.setClient_card_number(cardnum);
        db.subscribeClient(c1);
    }
    @Override
    public void removeObserver(int id, String fname, String lname, String gender,String email, String phone,String username, String password, int cardnum) throws RemoteException {
        try {
            client c1 = new client();
        c1.setFname(fname);
        c1.setLname(lname);
        c1.setID(id);
        c1.setGender(gender);
        c1.setUsername(username);
        c1.setEmail(email);
        c1.setPassword(password);
        c1.setPhone(phone);
        c1.setClient_card_number(cardnum);
            db.removeSubscribtion(c1);
        } catch (RemoteException ex) {
            Logger.getLogger(sysAgency.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error occured removing the subscribtion");
        }
    }  
    
//    @Override
//    public void notifyObservers(String agencyName) throws RemoteException {
//        try {
//            this.sysClients = db.getAllSubscribers();
//        } catch (RemoteException ex) {
//            Logger.getLogger(sysAgency.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String msg = "NEW AGENCY ADDED: -> " + agencyName + "Was successfully added to the system";
//        for(int i = 0; i<sysClients.size();i++)
//        {
//          sysClients.get(i).Update(msg);
//        }
//    }

    @Override
    public void notifyObservers(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
}
