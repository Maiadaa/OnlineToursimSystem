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
public class cash implements payment_method{
    
    public cash(){
        
    }
    
    public void pay(double amount){
        JOptionPane.showMessageDialog(null,"You are paying bu cash");
    }
    
    @Override
    public boolean Pay(booking book){
        return true;
    }
}
