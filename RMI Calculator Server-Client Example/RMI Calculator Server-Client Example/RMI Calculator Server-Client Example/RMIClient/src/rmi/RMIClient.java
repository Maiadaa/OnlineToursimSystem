/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIClient {

    public static void main(String[] args) {
        try {
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(500);

            // Search for the stub "calc"
            // Lookup function is for feteching on the remote object which is registered on the server
            // We must fetech by the same name which we bind the object with in the server
            CalculatorInterface c = (CalculatorInterface) registry.lookup("calc");
            
            //list all remote objects
            System.out.println(Arrays.toString(registry.list()));
            
            // Invoke the remote methods on the remote object
            System.out.println("The last result was " + c.getLastResult());
            System.out.println("The new result is " + c.add(5, 3));
            System.out.println("The last result was " + c.getLastResult());

            int r = c.sub(10, 5);
            System.out.println("Sub = " + r);
                       

        } catch (Exception ex) {
            System.out.println("Exception occured");
        }
    }
}
