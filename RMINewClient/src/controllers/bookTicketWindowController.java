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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rmi.booking;
import rmi.sysAirline;
import rmi.sysHotel;
import rminewclient.PaymentWindow;
import rminewclient.bookTicketWindow;

/**
 *
 * @author LENOVO
 */
public class bookTicketWindowController {
    // We have reference to both the GUI and the rmi registry
    static bookTicketWindow gui;
    static Registry r;
    String c;
    JTable table;
    String chosenAgency;
    
    
    // The constructor takes the gui and the rmi registry as paramaters
    public bookTicketWindowController(bookTicketWindow gui, Registry r, String c, String chosenAgency) throws RemoteException, NotBoundException
    {
        this.gui = gui;
        this.r = r;
        this.c = c;
        this.chosenAgency = chosenAgency;
        
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();

            sysAirline Airline = (sysAirline) r.lookup("airline");
            ArrayList<String> hotelRooms = Airline.getAllFlights(chosenAgency);
            Object rowData[] = new Object[4];
            
            for(String str: hotelRooms) {
                String[] data = str.split(" ");
                rowData[0] = data[0];
                rowData[1] = data[1];
                rowData[2] = data[2];
                
                model.addRow(rowData);                
            }
            this.gui.setjTable1(table);
        
        // This registers the button with our action listener below (the inner class)
        gui.getBookBtn().addActionListener(new bookCarBtnAction());
    }
    
    
    // This class is responsible for handling the button click
    class bookCarBtnAction implements ActionListener {
        
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                booking g = (booking) r.lookup("ticket");
                
                // get selected row 
                int row = gui.getjTable1().getSelectedRow();
                String  seatNum = gui.getjTable1().getModel().getValueAt(row, 0).toString();
                Double totalPrice = Double.parseDouble(gui.getjTable1().getModel().getValueAt(row, 2).toString());
                
                if(g.book(c, chosenAgency, seatNum)){
                    JOptionPane.showMessageDialog(null, "Booked" );
                    System.out.println("done");
                    
                    //navigate to payment window 
                    PaymentWindow nextGui = new PaymentWindow();
                    PaymentWindowController pay = new PaymentWindowController(nextGui, r, c, totalPrice);
                    
                    nextGui.setVisible(true);
                    gui.dispose();
                }
               
            } catch (RemoteException ex) {
                Logger.getLogger(bookTicketWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(bookTicketWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
