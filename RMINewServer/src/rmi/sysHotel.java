package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rminewserver.hotel;

public interface sysHotel extends Remote {
    
    ArrayList <String> getHotels() throws RemoteException;
    ArrayList <String> getAllRooms(String name) throws RemoteException;
}
