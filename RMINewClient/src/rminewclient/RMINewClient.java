/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewclient;

import controllers.adminMainMenu;
import controllers.bookCarWindowController;
import controllers.bookTicketWindowController;
import controllers.signupController;
import controllers.viewCarAgenciesController;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.client;
import rmi.person;

/**
 *
 * 
 */
public class RMINewClient {


    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry r = LocateRegistry.getRegistry(1099);

        viewCarAgencies gui = new viewCarAgencies();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true);
        
        viewCarAgenciesController x = new viewCarAgenciesController(gui, r, new client());

    }

    
}
