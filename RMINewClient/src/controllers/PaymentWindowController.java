/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author PC
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.client;
import rmi.payment_method;
import rminewclient.PaymentWindow;

public class PaymentWindowController {
    PaymentWindow gui;
    Registry r;
    client c;

    public PaymentWindowController(PaymentWindow gui, Registry r, client c) {
        this.gui = gui;
        this.r = r;
        this.c = c;
        
        gui.getPayButton().addActionListener(new payButtonAction(this.c));
    }
    
    class payButtonAction implements ActionListener{
        private client c;
        public payButtonAction (client c){
            this.c =c;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                payment_method p = (payment_method) r.lookup("visa");
                payment_method pp = (payment_method) r.lookup("cash");
                
                String x = gui.getMethodField().getText();
                
                if (x.equals("visa")){
                    p.pay();   
                }
                else if(x.equals("cash")){
                    pp.pay();
                }

                

//                if(gui.getCardRaido().isSelected()){
//                    cash ca = new cash();
//                    gui.getCardField().setEditable(false);
//                    c.setPayement(cash);
//                }
//                else if (gui.getCardRaido().isSelected()){
//                    creditcard cc = new creditcard();
//                    gui.getCardField().setEditable(true);
//                    int cardDetails =Integer.parseInt(gui.getCardField().getText());
//                    c.setClient_card_number(cardDetails);
//                    c.setPayement(cc);
//                }
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    
    
    
    
}
