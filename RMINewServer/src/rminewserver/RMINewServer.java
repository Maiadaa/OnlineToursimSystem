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
import rmi.booking;
import rmi.client;
import static rminewserver.maiadaDB.database;
import static rminewserver.maiadaDB.mongoClient;


/**
 *
 * 
 */
public class RMINewServer {



    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        //Calling the class for the database 
        maiadaDB db = new maiadaDB();
        
        // Here we create our remote object
        booking g = (booking) new carmanager();
        
        // An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(1099);
        
        // Our remote object g is binded to the name "grade"
        r.bind("car", g);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        

    }
         
    
    
}
