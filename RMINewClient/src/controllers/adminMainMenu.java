package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.GradeInterface;
import rminewclient.viewCarAgencies;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rmi.*;
import rminewclient.bookCarWindow;
import rminewclient.carAgencyDataMapper;
import rminewclient.adminMenu;
import rminewclient.airlineAgencyDataMapper;
import rminewclient.hotelDataMapper;
/**
 *
 * 
 */
public class adminMainMenu {
    
    // We have reference to both the GUI and the rmi registry
    adminMenu gui;
    Registry r;
    person c;
    // The constructor takes the gui and the rmi registry as paramaters
    public adminMainMenu(adminMenu gui, Registry r, person C) throws RemoteException, NotBoundException
    {
        this.c = C;
        this.gui = gui;
        this.r = r;
        
        gui.getjButton1().addActionListener(new caragencydatamapper());
        gui.getjButton2().addActionListener(new hoteldatamapper());
        gui.getjButton3().addActionListener(new airlineDataMapperr());
    }
    
    class caragencydatamapper implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            //call menu assem
            carAgencyDataMapper gui2 = new carAgencyDataMapper();
            try {
                carAgencyDataMapperController x = new carAgencyDataMapperController(gui2, r, c);
                gui2.setVisible(true);
                        } catch (RemoteException ex) {
                Logger.getLogger(adminMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class hoteldatamapper implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            //call menu assem
            hotelDataMapper gui2 = new hotelDataMapper();
            try {
                hotelDataMapperController x = new hotelDataMapperController(gui2, r, c);
                gui2.setVisible(true);
                        } catch (RemoteException ex) {
                Logger.getLogger(adminMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class airlineDataMapperr implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            //call menu assem
            airlineAgencyDataMapper gui2 = new airlineAgencyDataMapper();
            try {
                airlineDataMapperController x = new airlineDataMapperController(gui2, r, c);
                gui2.setVisible(true);
                        } catch (RemoteException ex) {
                Logger.getLogger(adminMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
