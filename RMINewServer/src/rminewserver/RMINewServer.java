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
import rmi.GradeInterface;

/**
 *
 * 
 */
public class RMINewServer {

    static Student s1;
    static Student s2;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        
                   
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        //Calling the class for the database 
        DB db = new DB();
        
        
         db.close();
        } 


         
    
    
}
