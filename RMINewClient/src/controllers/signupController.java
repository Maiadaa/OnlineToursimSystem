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
import javax.swing.JTextField;
import rmi.FacadeInterface;
import rmi.person;
import rminewclient.signupForm;

/**
 *
 * @author Lenovo
 */
public class signupController {
    signupForm sf = new signupForm();
    Registry r;
    person p;
    public signupController(signupForm sf, Registry r, person p){
        this.sf = sf;
        this.r = r;
        this.p = p;
        
        sf.getjButton1().addActionListener(new jbutton1Action(this.p));
    }
    class jbutton1Action implements ActionListener{

        private person p;
        
        public jbutton1Action (person p) {
            this.p = p;
        }
        
        @Override
         public void actionPerformed(ActionEvent ae) {
            try{
                FacadeInterface g = (FacadeInterface) r.lookup("Person");
                
                String Fname = sf.getjTextField2().getText();
                String Lname = sf.getjTextField3().getText();
                String age = sf.getjTextField5().getText();
                int Age =Integer.parseInt(age);
                String Email = sf.getjTextField6().getText();
                String Phone = sf.getjTextField7().getText();
                String Address = sf.getjTextField8().getText();
                String Username = sf.getjTextField9().getText();
                String Password = sf.getjTextField10().getText();
                String Gender = null;
                if (sf.getjRadioButton1().isSelected()== true){
                    Gender = "Male";
                }
                else if (sf.getjRadioButton2().isSelected()== true){
                    Gender = "Female";
                }
                g.setPerson(0, Fname, Lname, Gender,  Age, Email, Phone, Address, Username, Password);
            
            } catch (RemoteException ex) {
                Logger.getLogger(signupController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(signupController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
