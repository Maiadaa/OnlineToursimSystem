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
import rmi.GradeInterface;
import rmi.agencyDataMapperInterface;
import rminewclient.*;

/**
 *
 * @author manah
 */


public class carAgencyDataMapperController {
    carAgencyDataMapper gui;
    Registry r;

    public carAgencyDataMapperController(carAgencyDataMapper gui, Registry r) {
        this.gui = gui;
        this.r = r;
        gui.getAdd().addActionListener(new addbtnaction());
        gui.getDelete().addActionListener(new deletebtnaction());
    }
    
    class addbtnaction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                agencyDataMapperInterface datamapper = (agencyDataMapperInterface) r.lookup("dataMapper");
                String agencyname = gui.getjTextField1().getText();
                datamapper.insertCarAgyncy(agencyname);
               
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
        class deletebtnaction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                agencyDataMapperInterface datamapper = (agencyDataMapperInterface) r.lookup("dataMapper");
                String agencyname = gui.getjTextField1().getText();
                datamapper.deleteCarAgency(agencyname);
               
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
