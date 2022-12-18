/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewclient;

import controllers.carAgencyDataMapperController;
import controllers.viewAirlineController;
import controllers.viewCarAgenciesController;
import controllers.viewHotelController;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.NamingException;




/**
 *
 * 
 */
public class RMINewClient {


    public static void main(String[] args) throws RemoteException, NotBoundException, NamingException {

        // We create an object from the GUI window

        // We connect to the RMI Registry

        
//        bookCarWindow gui = new bookCarWindow();
//        gui.setLocationRelativeTo(null); // This makes the window appears centered
//        gui.setVisible(true); // This shows the gui
       
//        MainWindow gui = new MainWindow();
//        gui.setLocationRelativeTo(null); // This makes the window appears centered
//        gui.setVisible(true); // This shows the gui

        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1099);
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object

//        String c = "m1";
//        String chosenAgency = "";
//        bookingWindowController gui_controller = new bookingWindowController(gui, r, c, chosenAgency);
        

//        MainWindowController gui_controller = new MainWindowController(gui, r);
//        viewCarAgencies gui = new viewCarAgencies();
//        viewCarAgenciesController x = new viewCarAgenciesController(gui, r);
        viewAirline gui = new viewAirline();
//          viewHotel gui = new viewHotel();
//        viewHotelController x = new viewHotelController(gui, r);
        viewAirlineController x = new viewAirlineController(gui, r);
//        carAgencyDataMapper gui = new carAgencyDataMapper();
//        carAgencyDataMapperController x = new carAgencyDataMapperController(gui, r);
        gui.setVisible(true);

        
    }
    
}
