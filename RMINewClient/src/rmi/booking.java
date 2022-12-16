/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;

import java.rmi.RemoteException;


/**
 *
 * @author LENOVO
 */
public interface booking {
    
    public boolean book(client c) throws RemoteException;
    public String viewSummary(booking b);
    
}
