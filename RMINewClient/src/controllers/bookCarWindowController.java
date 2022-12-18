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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rmi.booking;
import rminewclient.PaymentWindow;
import rminewclient.bookCarWindow;

/**
 *
 * @author LENOVO
 */
public class bookCarWindowController {
    // We have reference to both the GUI and the rmi registry
    static bookCarWindow gui;
    static Registry r;
    String c;
    JTable table;
    String chosenAgency;
    
    
    // The constructor takes the gui and the rmi registry as paramaters
    public bookCarWindowController(bookCarWindow gui, Registry r, String c, String chosenAgency)
    {
        this.gui = gui;
        this.r = r;
        this.c = c;
        this.chosenAgency = chosenAgency;
        
        System.out.println(this.c + " " + this.chosenAgency);
        
        
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
        gui.getBookBtn().addActionListener(new bookCarBtnAction(this.c, this.chosenAgency));
    }
    
    
    // This class is responsible for handling the button click
    class bookCarBtnAction implements ActionListener {
        String username;
        String chosenAgency;
        
        public bookCarBtnAction(String c, String chosenAgency) {
            this.username = c;
            this.chosenAgency = chosenAgency;
        }
        
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                booking g = (booking) r.lookup("car");
                
                // get selected row 
                int row = gui.getjTable1().getSelectedRow();
                String  carPlateNum = gui.getjTable1().getModel().getValueAt(row, 0).toString();
                
                if(g.book(this.username, this.chosenAgency, carPlateNum)){
                    //navigate to payment window 
                    System.out.println("done");
                }
               
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}