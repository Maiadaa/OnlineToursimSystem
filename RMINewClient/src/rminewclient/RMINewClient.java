/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewclient;

import controllers.bookCarWindowController;
import controllers.viewAirlineController;
import controllers.viewHotelController;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.client;

/**
 *
 * 
 */
public class RMINewClient {


    public static void main(String[] args) throws RemoteException {

        // We create an object from the GUI window
        // We connect to the RMI Registry

        
        bookCarWindow gui = new bookCarWindow();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true); // This shows the gui
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1099);
        
        bookCarWindowController vh = new bookCarWindowController(gui, r, "m", "k" );

        
        
        
        
    }
    
}
