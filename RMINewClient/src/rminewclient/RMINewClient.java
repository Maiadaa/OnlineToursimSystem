/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewclient;

import controllers.MainWindowController;
import controllers.bookCarWindowController;
import controllers.viewCarAgenciesController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        String c = "m1";
        String chosenAgency = "";
        bookCarWindowController gui_controller = new bookCarWindowController(gui, r, c, chosenAgency);
        
        
    }
    
}
