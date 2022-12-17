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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    JTable table;
    
    
    // The constructor takes the gui and the rmi registry as paramaters
    public bookingWindowController(bookCarWindow gui, Registry r, client c, String chosenAgency)
    {
        this.gui = gui;
        this.r = r;
        this.c = c;
        
        
        this.table = this.gui.getjTable1();
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        
        Object rowData[] = new Object[7];
        rowData[0] = "hey";
        model.addRow(rowData);
//        rowData[0] = "2";
//        model.addRow(rowData);
        
        this.gui.setjTable1(table);
        
        // This registers the button with our action listener below (the inner class)
        gui.getBookBtn().addActionListener(new bookCarBtnAction(this.c, chosenAgency));
    }
    
    
    // This class is responsible for handling the button click
    class bookCarBtnAction implements ActionListener {
        private client c;
        private String chosenAgency;
        
        public bookCarBtnAction(client c, String agency) {
            this.c = c;
            this.chosenAgency = agency;
        }
        
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                booking g = (booking) r.lookup("car");
                
                // get selected row 
                int row = gui.getjTable1().getSelectedRow();
                String  carPlateNum = gui.getjTable1().getModel().getValueAt(row, 0).toString();
                
                System.out.println(carPlateNum);
                
                g.book(this.c, this.chosenAgency, carPlateNum);
               
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
