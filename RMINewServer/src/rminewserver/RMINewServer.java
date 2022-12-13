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
        
        // Here we create our remote object
        GradeInterface g = new Grade();
        
        // An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(1099);
        
        // Our remote object g is binded to the name "grade"
        r.bind("grade", g);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        
        
        s1 = new Student ("Meriam", 123, "Meriam12@yahoo.com");
        s2 = new Student ("Alaa", 1234, "Alaa19@yahoo.com");
        
        db.insertStudent(s1);
        db.insertStudent(s2);
        
         db.close();
        } 


         
    
    
}
