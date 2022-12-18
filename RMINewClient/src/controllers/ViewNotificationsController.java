/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import rmi.ClientInterface;
import rmi.client;
import rmi.subject_interface;
import rminewclient.ClientMenu;
import rminewclient.ViewNotifications;
import rmi.NotificationInterface;

/**
 *
 * 
 */
public class ViewNotificationsController {
    
    // We have reference to both the GUI and the rmi registry
    ViewNotifications gui;
    Registry r;
    JTable table = new JTable();
    
    
    // The constructor takes the gui and the rmi registry as paramaters
    public ViewNotificationsController(ViewNotifications gui, Registry r) throws RemoteException
    {
        
        this.gui = gui;
        this.r = r;
        try {
            NotificationInterface v = (NotificationInterface)this.r.lookup("notif_interface");
            System.out.println(v.viewNoti());
            table = gui.getNotifTable();
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            Object rowData[] = new Object[1];
            for(int i =0;i<v.viewNoti().size();i++)
            {
                rowData[0] = v.viewNoti().get(i);
                model.addRow(rowData);
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ViewNotificationsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(ViewNotificationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gui.setNotifTable(table);
        gui.getBackButton().addActionListener(new BackButtonLogic());
    }

     class BackButtonLogic implements ActionListener {
        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.dispose();
        }
        
    }
    
}
