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
import java.rmi.registry.Registry;
import rmi.client;
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
                client c = (client) r.lookup("purchase");
                if(gui.getCardRaido().isSelected()){
                    cash ca = new cash();
                    gui.getCardField().setEditable(false);
                    c.setPayement(cash);
                }
                else if (gui.getCardRaido().isSelected()){
                    creditcard cc = new creditcard();
                    gui.getCardField().setEditable(true);
                    int cardDetails =Integer.parseInt(gui.getCardField().getText());
                    c.setClient_card_number(cardDetails);
                    c.setPayement(cc);
                }
            }catch(Remote){
                
            }
        }
       
    }
    
    
    
    
    
}
