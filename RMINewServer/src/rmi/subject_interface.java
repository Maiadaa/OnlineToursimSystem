/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mahmo
 */
public interface subject_interface extends Remote
{
    public void addObserver(client observer)throws RemoteException;
    public void removeObserver (client observer) throws RemoteException;
    public void notifyObservers(String msg) throws RemoteException;
}
