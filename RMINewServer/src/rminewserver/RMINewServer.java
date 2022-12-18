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
import rmi.*;


/**
 *
 * 
 */
public class RMINewServer {



    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
//        DBHagrass dBHagrass = new DBHagrass();
//        System.out.println(dBHagrass.getAllCar("haha"));
//        dBHagrass.close();
        
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
//        
        Registry r = LocateRegistry.createRegistry(1099);
        sysCarAgency x = new sysAgency();
        sysHotel xx = new sysAgency();
        sysAirline xxx = new sysAgency();
        agencyDataMapperInterface xxxx = new agencyDataMapper();
        System.out.println(xxx.getAirlines().size());
        r.bind("hotel", xx);
        r.bind("carAgency", x);
        r.bind("airline", xxx);
        r.bind("dataMapper", xxxx);
        System.out.println("server running");


    }
         
    
    
}
