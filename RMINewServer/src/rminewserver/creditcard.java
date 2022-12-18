/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.payment_method;

/**
 *
 * @author Lenovo
 */
public class creditcard extends UnicastRemoteObject implements payment_method{
    
    public creditcard() throws RemoteException {
        
    }
    

    @Override
    public void pay(String c) throws RemoteException {
        SeifDB db = new SeifDB();
        String x = "Credit Card";
        db.updateBooking(c,x);
    }
    
}
