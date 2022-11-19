/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * 
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            // My remote object [Skeleton]
            CalculatorInterface c = new Calculator();

            // My RMI Registry
            
            Registry registry = LocateRegistry.createRegistry(500);
            
            //Add my object to the RMI Registry
            // Now we have added the remote object in the RMI registry
            // The bind function take two things, unqiue name for the object and the remoted object
            registry.bind("calc", c);

   
            
            System.out.println("My calculator is ready...");   
        } catch (Exception ex) {
           System.out.println("Exception occured");
        }   
    }
}

