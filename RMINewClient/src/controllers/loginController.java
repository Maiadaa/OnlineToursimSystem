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
import rmi.FacadeInterface;
import rmi.person;
import rminewclient.Login;
/**
 *
 * @author Lenovo
 */
public class loginController {
    Login l = new Login();
    Registry r;
    person p;
    public loginController( Login l, Registry r, person p){
        this.l = l;
        this.r = r;
        this.p = p;
        
        l.getjButton1().addActionListener (new jbutton1Action ());
    }
    class jbutton1Action implements ActionListener{
        
        @Override
         public void actionPerformed(ActionEvent ae) {
            try{
                
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                
                String Email = l.getjTextField1().getText();
                String Password = l.getjTextField2().getText();
                
                g.getPersonLogin(Email, Password);
                
                System.out.println("Success");
                
                JOptionPane.showMessageDialog(null, "Logged In" );
            }catch (RemoteException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
