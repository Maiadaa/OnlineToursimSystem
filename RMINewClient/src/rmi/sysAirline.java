package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface sysAirline extends Remote{
    
    ArrayList <Object> getAirlines() throws RemoteException;
    
}