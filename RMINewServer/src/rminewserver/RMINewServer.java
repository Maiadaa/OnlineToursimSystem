/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewserver;

import com.mongodb.client.MongoCollection;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;


/**
 *
 * 
 */
public class RMINewServer {



    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        SeifDB db = new SeifDB();
        System.out.println(db.getAllComplaints());
        complaint c = new complaint("test","test","test","test");
        db.insertComplaint(c);
        
        
        
        
        
                   
//        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
//        mongoLogger.setLevel(Level.SEVERE);
//        
//        //Calling the class for the database 
//        DBAssem db = new DBAssem();
//        client x = new client(0, "Hassan", "Ayman", "Male", 0, "m@gmail.com", "01128555666", "masr el gedida", "mahmoud123", "mahmoud123");
//        sysAgency s1 = new sysAgency();
//        s1.removeObserver(x);
//        db.close();
//        } 

        //int CarID, String Model, double RentalPrice, String Manufacturer, String CarType, int Seats, String plateNum
          //car c = new car(1, "P", 2.0, "for", "TR", 4, "250lft");
          
          //System.out.println(c.viewSummary());

    }
         
    
    
}
