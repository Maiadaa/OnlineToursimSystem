/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lenovo
 */
public interface payment_method extends Remote{
      /**
     * 
     * @param booking
     */
    public void pay();
    
//    boolean Pay(booking booking) throws RemoteException;
}
