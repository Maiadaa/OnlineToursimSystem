/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

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
    public boolean Pay(booking book){
        return true;
    }
}
