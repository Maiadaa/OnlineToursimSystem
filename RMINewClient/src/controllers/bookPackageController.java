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
import rminewclient.bookPackageWindow;


public class bookPackageController {
    // We have reference to both the GUI and the rmi registry
    static bookPackageWindow gui;
    static Registry r;
    static String c;
    JTable carstable;
    JTable roomsTable;
    JTable ticketTable;

    static String chosenAgency;
    
    
    // The constructor takes the gui and the rmi registry as paramaters
    public bookPackageController(bookPackageWindow gui, Registry r, String c, String chosenAgency)
    {
        this.gui = gui;
        this.r = r;
        this.c = c;
        this.chosenAgency = chosenAgency;
        
        System.out.println(this.c + " " + this.chosenAgency);
        
        
        this.carstable = this.gui.getCarsTbl();
        DefaultTableModel model;
        model = (DefaultTableModel) carstable.getModel();
        Object rowData[] = new Object[7];
        rowData[0] = "hey";
        model.addRow(rowData);
//        rowData[0] = "2";
//        model.addRow(rowData);
        this.gui.setCarsTbl(carstable);
        
        this.roomsTable = this.gui.getRoomsTbl();
        DefaultTableModel model2;
        model2 = (DefaultTableModel) roomsTable.getModel();
        Object rowData2[] = new Object[5];
        rowData2[0] = "hey";
        model2.addRow(rowData);
//        rowData[0] = "2";
//        model.addRow(rowData);
        this.gui.setRoomsTbl(carstable);

        this.carstable = this.gui.getTicketsTbl();
        DefaultTableModel model3;
        model3 = (DefaultTableModel) carstable.getModel();
        Object rowData3[] = new Object[3];
        rowData3[0] = "hey";
        model3.addRow(rowData);
//        rowData[0] = "2";
//        model.addRow(rowData);
        this.gui.setTicketsTbl(carstable);
        
        // This registers the button with our action listener below (the inner class)
        gui.getBookBtn().addActionListener(new bookCarBtnAction());
    }
    
    
    // This class is responsible for handling the button click
    class bookCarBtnAction implements ActionListener {
        
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                booking g = (booking) r.lookup("package");
                String agencies = "ticketAgency roomAgency carAgency";
                String identifiers = "";
                Double totalPrice = 0.0;
                
                // get selected room identifier
                int row = gui.getRoomsTbl().getSelectedRow();
                String  roomNum = gui.getRoomsTbl().getModel().getValueAt(row, 0).toString();
                totalPrice += Double.parseDouble(gui.getRoomsTbl().getModel().getValueAt(row, 4).toString());
                
                // get selected ticket identifier
                int trow = gui.getTicketsTbl().getSelectedRow();
                String  seatNum = gui.getTicketsTbl().getModel().getValueAt(trow, 0).toString();
                totalPrice += Double.parseDouble(gui.getTicketsTbl().getModel().getValueAt(row, 2).toString());
                
                // get selected car identifier 
                int crow = gui.getCarsTbl().getSelectedRow();
                String  carPlateNum = gui.getCarsTbl().getModel().getValueAt(crow, 0).toString();
                totalPrice += Double.parseDouble(gui.getCarsTbl().getModel().getValueAt(row, 6).toString());
                
                identifiers = seatNum + " " + roomNum + " " + carPlateNum;
                
                
                if(g.book(c, agencies, identifiers)){
                    JOptionPane.showMessageDialog(null, "Booked" );
                    System.out.println("done");
                    
                    //navigate to payment window 
                    PaymentWindow nextGui = new PaymentWindow();
                    PaymentWindowController pay = new PaymentWindowController(nextGui, r, c, totalPrice);
                    
                    nextGui.setVisible(true);
                    gui.dispose();
                }
               
            } catch (RemoteException ex) {
                Logger.getLogger(bookPackageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(bookPackageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}

