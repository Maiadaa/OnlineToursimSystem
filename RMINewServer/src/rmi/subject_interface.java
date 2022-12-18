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
    public void addObserver(int id, String fname, String lname, String gender,String email, String phone,String username, String password, int cardnum)throws RemoteException;
    public void removeObserver (int id, String fname, String lname, String gender,String email, String phone,String username, String password, int cardnum) throws RemoteException;
    public void notifyObservers(String msg) throws RemoteException;
}
