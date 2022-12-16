/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.booking;
import rmi.client;
import rminewclient.bookCarWindow;

/**
 *
 * @author LENOVO
 */
public class bookingWindowController {
    // We have reference to both the GUI and the rmi registry
    bookCarWindow gui;
    Registry r;
    client c;
    
    // The constructor takes the gui and the rmi registry as paramaters
    public bookingWindowController(bookCarWindow gui, Registry r, client c)
    {
        this.gui = gui;
        this.r = r;
        this.c = c;
        
        // This registers the button with our action listener below (the inner class)
        gui.getBookBtn().addActionListener(new bookCarBtnAction(this.c));
    }
    
    
    // This class is responsible for handling the button click
    class bookCarBtnAction implements ActionListener {
        private client c;
        public bookCarBtnAction(client c) {
            this.c = c;
        }
        
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                booking g = (booking) r.lookup("booking");
                
                // get selected row 
                int row = gui.getjTable1().getSelectedRow();
                String  carPlateNum = gui.getjTable1().getModel().getValueAt(row, 0).toString();
                
                g.book(this.c);
               
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
