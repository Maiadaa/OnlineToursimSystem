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
    
    public void pay(double amout){
        JOptionPane.showMessageDialog(null, "You paied using credit card");
    }
    /**
     *
     * @param book
     * @return
     */
    @Override        
    public boolean Pay(booking book){
        return true;
    }
}
