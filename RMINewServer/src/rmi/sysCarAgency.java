package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rminewserver.carAgency;

public interface sysCarAgency extends Remote {

    ArrayList <String> getCarAgencies() throws RemoteException;
    ArrayList <String> getAllCars(String name) throws RemoteException;
}
