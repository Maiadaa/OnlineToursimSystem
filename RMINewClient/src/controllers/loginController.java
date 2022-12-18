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
import rminewclient.EditAccount;
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
                l.setVisible(true);
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                
                String Email = l.getjTextField1().getText();
                String Password = l.getjTextField2().getText();
                
               person p = g.getPersonLogin(Email, Password);
                System.out.println(p);
                System.out.println("Success");
                
                JOptionPane.showMessageDialog(null, "Logged In" );
                
                EditAccount nextGui = new EditAccount();
                EditController pay = new EditController(nextGui, r, p);
                    
                nextGui.setVisible(true);
                l.dispose();
            }catch (RemoteException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
