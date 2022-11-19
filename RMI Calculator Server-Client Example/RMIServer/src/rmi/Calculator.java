/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * 
 */

// This is the class which have the implmentations for the methods that will be invoked later remotely
public class Calculator extends UnicastRemoteObject implements CalculatorInterface {

    int lastResult = 0;
    public Calculator() throws RemoteException {
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        lastResult = x+y;
        return lastResult;
    }

    @Override
    public int getLastResult() throws RemoteException {
        return lastResult;
    }

    @Override
    public int sub(int x, int y) throws RemoteException {
        lastResult  = x-y;
        return lastResult;
    }


 
    
}

