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
import javax.swing.JTextField;
import rmi.ClientInterface;
import rmi.NotificationInterface;
import rmi.client;
import rmi.subject_interface;
import rminewclient.ClientMenu;
import rminewclient.ViewNotifications;

/**
 *
 * 
 */
public class ClientMenuController {
    
    // We have reference to both the GUI and the rmi registry
    ClientMenu gui;
    Registry r;
    client c1;
    
    
    // The constructor takes the gui and the rmi registry as paramaters
    public ClientMenuController(ClientMenu gui, Registry r, client c) throws RemoteException
    {
        this.c1 = c;
        this.gui = gui;
        this.r = r;
        //gui.getNameField().setText(c.getFname());
        gui.getNameField().setText(c.getFname());
        try {
            ClientInterface cint = (ClientInterface) r.lookup("client_interface");
            ArrayList<String> subs = new ArrayList<String>();
            subs = cint.getAllSubs();
            for(int i = 0 ; i< subs.size();i++)
            {
                
                if(subs.get(i).equals(c1.getFname()))
                {
                    gui.getStatusField().setText("Subscribed");
                    gui.getViewNotButton().setEnabled(true);
                    gui.getUnSubButton().setEnabled(true);
                    gui.getSubButton().setEnabled(false);
                }
                else
                {
                    gui.getStatusField().setText("Unsubscribed");
                    gui.getViewNotButton().setEnabled(false);
                    gui.getUnSubButton().setEnabled(false);
                    gui.getSubButton().setEnabled(true);
                }
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientMenuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(ClientMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // This registers the button with our action listener below (the inner class)
        gui.getViewNotButton().addActionListener(new ViewNotificationsLogic());
        gui.getBackButton().addActionListener(new BackButtonLogic());
        gui.getSubButton().addActionListener(new SubscribeButtonLogic());
        gui.getUnSubButton().addActionListener(new UnSubButtonLogic());
        
    }
    class UnSubButtonLogic implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent ae)
        {
            try
            {
                JOptionPane.showMessageDialog(gui,"You are now removed from the subscribers list");
                gui.getSubButton().setEnabled(true);
                gui.getUnSubButton().setEnabled(false);
                gui.getViewNotButton().setEnabled(false);
                gui.getStatusField().setText("Unsubscribed");
                subject_interface s = (subject_interface) r.lookup("sub_interface");
                s.removeObserver(c1.getID(),c1.getFname(),c1.getLname(),c1.getGender(),c1.getEmail(),c1.getPhone(),c1.getUsername(),c1.getPassword(),c1.getClient_card_number());
            }
            catch(RemoteException | NotBoundException ex)
            {
                Logger.getLogger(ClientMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class SubscribeButtonLogic implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            try
            {
            subject_interface s = (subject_interface) r.lookup("sub_interface");
            s.addObserver(c1.getID(),c1.getFname(),c1.getLname(),c1.getGender(),c1.getEmail(),c1.getPhone(),c1.getUsername(),c1.getPassword(),c1.getClient_card_number());
            JOptionPane.showMessageDialog(gui,"You are now added to the subscribers list");
            gui.getSubButton().setEnabled(false);
            gui.getUnSubButton().setEnabled(true);
            gui.getViewNotButton().setEnabled(true);
            gui.getStatusField().setText("Subscribed");
            
            } 
            catch (RemoteException | NotBoundException ex) 
            {
                Logger.getLogger(ClientMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // This class is responsible for handling the button click
    class ViewNotificationsLogic implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                ViewNotifications v1 = new ViewNotifications();
                ViewNotificationsController cont = new ViewNotificationsController(v1,r);
                v1.setVisible(true);
                
            } catch (RemoteException ex) {
                Logger.getLogger(ClientMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     class BackButtonLogic implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.dispose();
        }
        
    }
    
}
