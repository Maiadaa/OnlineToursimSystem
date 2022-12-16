package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rminewserver.airline;

public interface sysAirline extends Remote {
    
    ArrayList <airline> getAirlines() throws RemoteException;
    
}
