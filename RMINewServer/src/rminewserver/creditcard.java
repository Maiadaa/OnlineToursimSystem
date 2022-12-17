/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import javax.swing.JOptionPane;
import rmi.payment_method;
import rmi.booking;

/**
 *
 * @author Lenovo
 */
public class creditcard implements payment_method{
    
    public creditcard() {
    }
    
   
    /**
     *
     * @param book
     * @return
     */
    
    @Override
    public void pay(){
        JOptionPane.showMessageDialog(null,"You are paying by visa");
    }
    
}
