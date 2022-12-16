package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface sysHotel extends Remote{
    
    ArrayList <Object> getHotels() throws RemoteException;
    
}
