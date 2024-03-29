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
import rmi.client;
import rminewclient.*;

/**
 *
 * @author manah
 */


public class carAgencyDataMapperController {
    carAgencyDataMapper gui;
    Registry r;
    client c = new client();

    public carAgencyDataMapperController(carAgencyDataMapper gui, Registry r, client C) throws RemoteException{
        this.gui = gui;
        this.r = r;
        this.c = C;
        
        gui.getAdd().addActionListener(new addbtnaction());
        gui.getDelete().addActionListener(new deletebtnaction());
        gui.getBack().addActionListener(new backbtn());
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
                Logger.getLogger(carAgencyDataMapperController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(carAgencyDataMapperController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(carAgencyDataMapperController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(carAgencyDataMapperController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    class backbtn implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            //call menu assem
            gui.dispose();
        }
        
    }
}
