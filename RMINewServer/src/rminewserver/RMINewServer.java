/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.booking;
import rmi.sysAirline;
import rmi.sysCarAgency;
import rmi.sysHotel;

/**
 *
 * 
 */
public class RMINewServer {



    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        //Calling the class for the database 
        DB db = new DB();
        
        // Here we create our remote object
        booking car = (booking) new car();
        booking ticket = (booking) new ticket();
        booking room = (booking) new room();
        booking pkg = (booking) new packageOffer();
        
        sysCarAgency carAgency = (sysCarAgency)new sysAgency();
        sysHotel hotel = (sysHotel)  new sysAgency() ;
        sysAirline airline = (sysAirline) new sysAgency();
        
        
        // An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(1099);
        
        // Our remote object g is binded to the name "grade"
        r.bind("car", car);
        r.bind("ticket", ticket);
        r.bind("room", room);
        r.bind("package", pkg);
        
        r.bind("carAgency", carAgency);
        r.bind("hotel", hotel);
        r.bind("airline", airline);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        
        System.out.println(db.getAllCar("k"));
        

    }
         
    
    
}
