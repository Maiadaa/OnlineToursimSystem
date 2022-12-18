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
import rmi.sysCarAgency;
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

         try {
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();

            sysCarAgency carAg = (sysCarAgency) r.lookup("carAgency");
            ArrayList<String> agencyCars = carAg.getAllCars(chosenAgency);
            Object rowData[] = new Object[6];
            
            for(String str: agencyCars) {
                String[] data = str.split(" ");
                rowData[0] = data[0];
                rowData[1] = data[1];
                rowData[2] = data[2];
                rowData[3] = data[3];
                rowData[4] = data[4];
                rowData[5] = data[5];
                
                model.addRow(rowData);                
            }
            this.gui.setjTable1(table);
            
        } catch (RemoteException ex) {
            Logger.getLogger(bookCarWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(bookCarWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        // This registers the button with our action listener below (the inner class)
        gui.getBookBtn().addActionListener(new bookCarBtnAction());
    }
    
    
    // This class is responsible for handling the button click
    class bookCarBtnAction implements ActionListener {
        
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                booking g = (booking) r.lookup("car");
                
                // get selected row 
                int row = gui.getjTable1().getSelectedRow();
                String  carPlateNum = gui.getjTable1().getModel().getValueAt(row, 0).toString();
                Double totalPrice = Double.parseDouble(gui.getjTable1().getModel().getValueAt(row, 5).toString());

                
                if(g.book(c, chosenAgency, carPlateNum)){
                    JOptionPane.showMessageDialog(null, "Booked" );
                    System.out.println("done");
                    
                    //navigate to payment window 
                    PaymentWindow nextGui = new PaymentWindow();
                    PaymentWindowController pay = new PaymentWindowController(nextGui, r, c, totalPrice);
                    
                    nextGui.setVisible(true);
                    gui.dispose();
                }
               
            } catch (RemoteException ex) {
                Logger.getLogger(bookCarWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(bookCarWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
