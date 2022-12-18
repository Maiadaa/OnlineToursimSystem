/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface payment_method extends Remote{

    public void pay(String c) throws RemoteException;
    
}
