/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewclient;

import controllers.MainWindowController;
import controllers.bookRoomWindowController;
import controllers.carAgencyDataMapperController;
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

        
        carAgencyDataMapper gui = new carAgencyDataMapper();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true); // This shows the gui
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1099);
        
        carAgencyDataMapperController x = new carAgencyDataMapperController(gui, r, new client());
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
//        String c = "m";
//        String chosenAgency = "hey";
//        bookRoomWindowController gui_controller = new bookRoomWindowController(gui, r, c, chosenAgency);
        
        
    }
    
}
