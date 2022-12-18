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
import rmi.FacadeInterface;
import rmi.client;
import rmi.person;
import rminewclient.ClientMenu;
import rminewclient.EditAccount;

/**
 *
 * @author Lenovo
 */
public class EditController {
    EditAccount ed = new EditAccount();
    Registry r;
    person p;
    
    public EditController (EditAccount ed, Registry r, person p){
        this.ed = ed;
        this.r = r;
        this.p = p;
        
        String email = p.getEmail();
        ed.getjTextField1().setText(email); 
        
        ed.getjButton2().addActionListener(new jbutton2Action ());
        ed.getjButton3().addActionListener(new jbutton3Action ());
        ed.getjButton4().addActionListener(new jbutton4Action ());
        ed.getjButton5().addActionListener(new jbutton5Action ());
        ed.getjButton6().addActionListener(new jbutton6Action ());
    }
    class jbutton2Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                String email = p.getEmail();
                ed.getjTextField1().setText(email);
                String address = ed.getjTextField2().getText();
//                String phone = ed.getjTextField3().getText();
//                String username = ed.getjTextField4().getText();
//                String password = ed.getjTextField5().getText();
                
                g.editaddressDTO(email, address);
//                g.editPhoneDTO(email, phone);
//                g.editUsername(email, username);
//                g.editPassword(email, password);
            } catch (RemoteException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class jbutton3Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                String email = p.getEmail();
                ed.getjTextField1().setText(email);
//                String address = ed.getjTextField2().getText();
                String phone = ed.getjTextField3().getText();
//                String username = ed.getjTextField4().getText();
//                String password = ed.getjTextField5().getText();
                
//                g.editaddressDTO(email, address);
                g.editPhoneDTO(email, phone);
//                g.editUsername(email, username);
//                g.editPassword(email, password);
            } catch (RemoteException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class jbutton4Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                String email = p.getEmail();
                ed.getjTextField1().setText(email);
//                String address = ed.getjTextField2().getText();
//                String phone = ed.getjTextField3().getText();
                String username = ed.getjTextField4().getText();
//                String password = ed.getjTextField5().getText();
                
//                g.editaddressDTO(email, address);
//                g.editPhoneDTO(email, phone);
                g.editUsername(email, username);
//                g.editPassword(email, password);
            } catch (RemoteException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class jbutton5Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                String email = p.getEmail();
                ed.getjTextField1().setText(email);
//                String address = ed.getjTextField2().getText();
//                String phone = ed.getjTextField3().getText();
//                String username = ed.getjTextField4().getText();
                String password = ed.getjTextField5().getText();
                
//                g.editaddressDTO(email, address);
//                g.editPhoneDTO(email, phone);
//                g.editUsername(email, username);
                g.editPassword(email, password);
            } catch (RemoteException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class jbutton6Action implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent ae){
            try{
                ClientMenu nextGui = new ClientMenu();
                ClientMenuController pay = new ClientMenuController(nextGui, r, null);
                nextGui.setVisible(true);
                ed.dispose();
            }catch (RemoteException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
