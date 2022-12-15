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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * 
 */
public class RMINewServer {



    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        
                   
//        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
//        mongoLogger.setLevel(Level.SEVERE);
//        
//        //Calling the class for the database 
//        DB db = new DB();
//        client x = new client(1, null, null, null, null, null);
//        db.insertStudent(x);
//         db.close();
//        } 

        //int CarID, String Model, double RentalPrice, String Manufacturer, String CarType, int Seats, String plateNum
          car c = new car(1, "P", 2.0, "for", "TR", 4, "250lft");
          
          System.out.println(c.viewSummary());

    }
         
    
    
}
