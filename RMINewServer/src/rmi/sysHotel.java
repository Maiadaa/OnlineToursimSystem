package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rminewserver.hotel;

public interface sysHotel extends Remote {
    
    ArrayList <String> getHotels() throws RemoteException;
    
}
